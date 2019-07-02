package com.ogaclejapan

import okio.GzipSource
import okio.buffer
import okio.source
import org.openjdk.jmh.annotations.*
import java.io.File
import java.nio.charset.Charset
import java.util.concurrent.TimeUnit

@Fork(3)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
open class DecompressBenchmark {

    @Benchmark
    fun testSmallPlain(): String {
        val target = File("./data/sample_repos_small.json")
        target.source().buffer().use {
            return it.readString(Charset.forName("UTF-8"))
        }
    }

    @Benchmark
    fun testMediumPlain(): String {
        val target = File("./data/sample_repos_medium.json")
        target.source().buffer().use {
            return it.readString(Charset.forName("UTF-8"))
        }
    }

    @Benchmark
    fun testLargePlain(): String {
        val target = File("./data/sample_repos_large.json")
        target.source().buffer().use {
            return it.readString(Charset.forName("UTF-8"))
        }
    }

    @Benchmark
    fun testSmallGzip(): String {
        val target = File("./data/sample_repos_small.json.gz")
        GzipSource(target.source()).buffer().use {
            return it.readString(Charset.forName("UTF-8"))
        }
    }

    @Benchmark
    fun testMediumGzip(): String {
        val target = File("./data/sample_repos_medium.json.gz")
        GzipSource(target.source()).buffer().use {
            return it.readString(Charset.forName("UTF-8"))
        }
    }

    @Benchmark
    fun testLargeGzip(): String {
        val target = File("./data/sample_repos_large.json.gz")
        GzipSource(target.source()).buffer().use {
            return it.readString(Charset.forName("UTF-8"))
        }
    }

    @Benchmark
    fun testSmallBrotli(): String {
        val target = File("./data/sample_repos_small.json.br")
        BrotliSource(target.inputStream()).buffer().use {
            return it.readString(Charset.forName("UTF-8"))
        }
    }

    @Benchmark
    fun testMediumBrotli(): String {
        val target = File("./data/sample_repos_medium.json.br")
        BrotliSource(target.inputStream()).buffer().use {
            return it.readString(Charset.forName("UTF-8"))
        }
    }

    @Benchmark
    fun testLargeBrotli(): String {
        val target = File("./data/sample_repos_large.json.br")
        BrotliSource(target.inputStream()).buffer().use {
            return it.readString(Charset.forName("UTF-8"))
        }
    }
}
