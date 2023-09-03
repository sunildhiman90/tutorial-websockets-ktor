package com.example

import io.ktor.websocket.*
import java.util.concurrent.atomic.*


// Note that we are using AtomicInteger as a thread-safe data structure for the counter.
// This ensures that two users will never receive the same ID for their username –
// even when their two Connection objects are created simultaneously on separate threads.
class Connection(val session: DefaultWebSocketSession) {
    companion object {
        val lastId = AtomicInteger(0)
    }
    val name = "user${lastId.getAndIncrement()}"
}