package com.example.coctailcard.data.db

typealias Timestamp = Long

fun now(): Timestamp = System.currentTimeMillis()
fun nowSeconds(): Timestamp = now() / 1000L