#  异常
1.  不同于语法错误的编译不通过，运行时产生的，为了帮助我们找到程序中的问题
2. 	异常的根类是java.lang.Throwable,其下有两个子Ansa类：java.lang.Error（错误：不能处理，只能事先避免）与java.lang.Exception（编译期（写代码）异常：使用不当导致，可避免的）。平常所说的异常是Exception
3. 	RuntimeException（运行期异常）是Exception的一个子类，程序运行期抛出的异常