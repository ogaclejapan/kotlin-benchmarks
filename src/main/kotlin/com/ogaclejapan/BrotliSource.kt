package com.ogaclejapan

import okio.*
import org.brotli.dec.BrotliInputStream
import java.io.InputStream

class BrotliSource(inputStream: InputStream) : Source {

    private val source = BrotliInputStream(inputStream).source()

    override fun close() {
        source.close()
    }

    override fun read(sink: Buffer, byteCount: Long): Long {
        return source.read(sink, byteCount)
    }

    override fun timeout(): Timeout {
        return source.timeout()
    }
}
