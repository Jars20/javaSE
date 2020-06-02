# 线程池
## 线程池的shutdown和interrupt

# interrupt
如何停止一个线程：需要等到线程运行结束。  
1. 抛出运行时异常  
2. 运行到return代码，如果是循环判断条件，需要保证条件变量是violiate
3. 可以使用unterrupt方法进行中断判断，通过中断标识为true推出循环


如何中断线程：
在外部调用interrupt方法，线程池的shutdown方法。  
会将内部的中断标识符修改为true，另外线程内部阻塞方法（抛出InterruptException异常），
catch后标识符被重制为false，如果需要此标识符退出循环判断，需要Thread.currentThread.interrupt（）


如何获取线程的异常：  
run方法不允许抛出checkedException，只允许抛出uncheckedException。  
如果需要，则需要使用Future对象的get方法来捕获。


线程安全：
1. synchronized关键字，修饰实例方法，相当于对当前对象加锁，当访问此方法时候，需要先获得实例的锁，否则需要别人释放锁。  
修饰static方法，相对于类对象加锁。  
修饰代码块，需要指定加锁的对象，也可以是类的对象（.class）  
2. 使用Lock加锁，这种方式相对比较灵活。可以通过tryLock的方式尝试获取锁。
需要手动释放获取到的锁，必须要lock.unlock  
3. 另外可以使用线程安全的工具类。实现线程安全同步。


# callable-runnable

# Future<>接口