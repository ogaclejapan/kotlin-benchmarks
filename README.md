jmh-kotlin 
[![official JetBrains project](https://jb.gg/badges/official.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub)
==========

A set of JMH benchmarks for various Kotlin language constructions and standard library functions.

Build:
```
mvn clean package
```

Note: need clean package every time, otherwise removed benchmarks will be hanging around.

Run:
```
java -jar target/benchmarks.jar DecompressBenchmark
...
Benchmark                             Mode  Cnt   Score   Error  Units
DecompressBenchmark.testLargeBrotli   avgt   30  14.688 ± 0.070  ms/op
DecompressBenchmark.testLargeGzip     avgt   30  12.830 ± 0.074  ms/op
DecompressBenchmark.testLargePlain    avgt   30   8.456 ± 0.057  ms/op
DecompressBenchmark.testMediumBrotli  avgt   30   4.718 ± 0.023  ms/op
DecompressBenchmark.testMediumGzip    avgt   30   3.836 ± 0.020  ms/op
DecompressBenchmark.testMediumPlain   avgt   30   2.495 ± 0.061  ms/op
DecompressBenchmark.testSmallBrotli   avgt   30   0.385 ± 0.004  ms/op
DecompressBenchmark.testSmallGzip     avgt   30   0.239 ± 0.002  ms/op
DecompressBenchmark.testSmallPlain    avgt   30   0.113 ± 0.002  ms/op
```

Also see commands.txt for more pre-configured commands.

Data:
```
ls -hl data
4.9M sample_repos_large.json
190K sample_repos_large.json.br
314K sample_repos_large.json.gz
1.6M sample_repos_medium.json
 65K sample_repos_medium.json.br
105K sample_repos_medium.json.gz
146K sample_repos_small.json
7.9K sample_repos_small.json.br
 11K sample_repos_small.json.gz
```
