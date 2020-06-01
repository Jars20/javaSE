花一些时间看SumMultithreaded.java代码。Math.sin对数组的每个元素的三角正弦值求和。
之所以这样做，是因为计算正弦值的速度很慢，它有助于弄清楚多线程计算此值的优势。

1. 修改MaxMultithreaded.java文件
将计算数组中最大值。参考SumMultithreaded代码。完成后，单元测试MaxValueTest应通过。

2. 修改ReverseHelloMultithreaded文件，
创建线程（我们将其称为线程1）。线程1创建另一个线程（线程2）；线程2创建线程3；依此类推，直到线程50。
每个线程都应打印 "Hello from Thread <num>!"。完成后，保证ReverseHelloTest应成功运行

3. 修改 SharedCounter.java 中的方法 increment. 
这个方法应该启动numThreads数量的线程，并且每个线程都应该向counter中增加numIncrementsPerThread的值。