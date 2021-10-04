* ./mvnw compile exec:java

````
JMH version: 1.32
VM version: JDK 17, OpenJDK 64-Bit Server VM, 17+35-2724


Benchmark                                          Mode  Cnt          Score          Error  Units
CollectionsBenchmark.findInList_10                 avgt    5          8,514 ±        1,265  ns/op
CollectionsBenchmark.findInList_10_000             avgt    5       5838,579 ±      911,546  ns/op
CollectionsBenchmark.findInList_10_000_000         avgt    5   10376612,242 ±   887333,425  ns/op
CollectionsBenchmark.findInList_10_000_000_binary  avgt    5         29,414 ±       14,113  ns/op
CollectionsBenchmark.findInList_10_000_binary      avgt    5         19,261 ±       10,445  ns/op
CollectionsBenchmark.findInList_10_binary          avgt    5          6,188 ±        2,785  ns/op
CollectionsBenchmark.findInSet_10                  avgt    5          4,496 ±        1,720  ns/op
CollectionsBenchmark.findInSet_10_000              avgt    5          4,511 ±        1,695  ns/op
CollectionsBenchmark.findInSet_10_000_000          avgt    5          4,316 ±        2,079  ns/op
CollectionsBenchmark.sortList_10                   avgt    5        206,391 ±       65,982  ns/op
CollectionsBenchmark.sortList_10_000               avgt    5     109090,429 ±    11399,988  ns/op
CollectionsBenchmark.sortList_10_000_000           avgt    5  263861767,500 ± 25834786,164  ns/op
````

