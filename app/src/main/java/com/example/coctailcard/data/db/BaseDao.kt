package com.example.coctailcard.data.db

import android.util.Log
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.room.Transaction
import androidx.room.Upsert
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.example.coctailcard.data.models.TableUpdateTimestamp
import com.example.network.RequestResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.mp.KoinPlatformTools
import java.util.Date

private const val TAG = "Base DAO"
private const val defaultRefreshDelayInSeconds = 300L // default = 5min

/**
 * Add common patter CRUD to dao's easily
 */
@Dao
abstract class BaseDao<T : Any> {
    abstract val tableName: String

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun save(obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun save(items: List<T>)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract suspend fun insert(obj: T)

    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract suspend fun insert(items: List<T>)

    @Upsert
    abstract suspend fun upsert(obj: T)

    @Delete
    abstract suspend fun delete(obj: T)

    suspend fun deleteAll(): Int {
        val query = SimpleSQLiteQuery("delete from $tableName")
        return executeRawQuery(query)
    }

    suspend fun fetchAll(): List<T> {
        val query = SimpleSQLiteQuery("SELECT * FROM $tableName")
        return fetchRawQuery(query)
    }

    @Transaction
    open suspend fun updateTransaction(items: List<T>) {
        Log.d(TAG, "updateTransaction: started")
        deleteAll()
        insert(items)
        Log.d(TAG, "updateTransaction: finished")
    }


    @RawQuery
    abstract fun executeRawQuery(query: SupportSQLiteQuery): Int

    @RawQuery
    abstract suspend fun fetchRawQuery(query: SupportSQLiteQuery): List<T>
}

fun <T : Any> BaseDao<T>.fetchAllAndRefresh(
    refreshVia: suspend () -> RequestResult<List<T>>,
    fetchVia: suspend BaseDao<T>.() -> List<T> = { fetchAll() },
    saveVia: suspend BaseDao<T>.(List<T>) -> Unit = { updateTransaction(it) },
    fetchId: suspend BaseDao<T>.() -> String = { "${this.tableName}.fetchAll" },
    refreshInterval: Timestamp = defaultRefreshDelayInSeconds,
    forceRefresh: Boolean = false,
): Flow<List<T>> = flow {
    emit(fetchVia())

    // get from table latest requests time of last request for id
    val timestampDao = KoinPlatformTools.defaultContext().get().get<TableUpdateTimestampDao>()
    val id = fetchId()
    val lastTimestamp = timestampDao.fetchId(id)?.timestamp ?: 0L
    val currentTimestamp = Date().time

    // check if last request was executed more than refresh interval seconds ago
    val shouldRefresh = (currentTimestamp - lastTimestamp) >= refreshInterval

    if (forceRefresh || shouldRefresh) {
        runCatching {
            when (val result = refreshVia()) {
                is RequestResult.Success -> {
                    // save to table latest current time for id
                    timestampDao.upsert(TableUpdateTimestamp(id, currentTimestamp))
                    result.data
                }

                else -> throw IllegalStateException("Request error")
            }
        }.onSuccess {
            saveVia(it)
            emit(fetchVia())
        }.onFailure {
            Log.e("DAO", "Error while refreshing data \n${it.stackTraceToString()}")
        }
    }
}

fun <T : Any> BaseDao<T>.fetchOneAndRefresh(
    refreshVia: suspend () -> RequestResult<T>,
    fetchVia: suspend BaseDao<T>.() -> T,
    saveVia: suspend BaseDao<T>.(T) -> Unit = { upsert(it) },
    fetchId: suspend BaseDao<T>.() -> String = { "${this.tableName}.fetchAll" },
    refreshInterval: Timestamp = defaultRefreshDelayInSeconds,
    forceRefresh: Boolean = false,
): Flow<T> = flow {
    emit(fetchVia())

    // get from table latest requests time of last request for id
    val timestampDao = KoinPlatformTools.defaultContext().get().get<TableUpdateTimestampDao>()
    val id = fetchId()
    val lastTimestamp = timestampDao.fetchId(id)?.timestamp ?: 0L
    val currentTimestamp = Date().time

    // check if last request was executed more than refresh interval seconds ago
    val shouldRefresh = (currentTimestamp - lastTimestamp) >= refreshInterval

    if (forceRefresh || shouldRefresh) {
        runCatching {
            when (val result = refreshVia()) {
                is RequestResult.Success -> {
                    // don't save latest current time for id to timestamp table
                    // as only one record was refreshed
                    result.data
                }

                else -> throw IllegalStateException("Request error")
            }
        }.onSuccess {
            saveVia(it)
            emit(fetchVia())
        }.onFailure {
            Log.e("DAO", "Error while refreshing data \n${it.stackTraceToString()}")
        }
    }
}