1. 操作：[QUIT]，退出程序
2. 操作: [UOP N]，其中N是整数，UOP是一元运算符（"-"）。程序通过显示给定整数的整数或者负数作为输出值
3. 操作: [N1 BOP N2], 其中N1和N2是整数，而BOP是二进制运算符（仅支持"+"和"-"）。程序根据运算符计算两个参数的运行结果并输出。运算符和操作数之间需要使用空格分隔

以下是与用户进行交互的示例。同时显示了用户的输入和程序的响应。
```
4 + 2
The result is : 6 
Input was: 4 + 2 

42+7
Illegal input : Illegal Argument
Input was : 42+7 

4 / 2
The result is : 2
Input was: 4 / 2

foo + 2
Illegal input : Illegal Argument
Input was : foo + 2

42 ˆ 3
Illegal input : Illegal Operator
Input was: 42 ˆ 3

32 ˆ baz 
Illegal input : Illegal Argument
Input was : 32 ^ baz

foobar ˆ 3
Illegal input : Illegal Argument
Input was : foobar ˆ 3

4 / 0
Tried to divide by zero 
Input was: 4 / 0

−4
Illegal input : Illegal Argument
Input was: −4

− 4
The result is : −4
Input was: − 4

1 + 2 + 3
Illegal input : Illegal Token Length
Input was: 1 + 2 + 3

45+ 2
Illegal input : Illegal Operator
Input was: 45+ 2

45 +2
Illegal input : Illegal Operator
Input was: 45 +2

QUIT
Quitting
Thanks!

```

 应用依赖的异常类都是Exception的子类，仅需要提供构造方法不需要为异常类添加额外的功能。使用try / catch / finally块可以检查特定的异常。
 通过创建新的Exception类型，我们使程序可以通过异常类传递更详细的错误信息。
 请构造了以下类：
 1. QuitException：当用户输入"quit"结束程序时抛出（不区分大小写）。 
 2. DivideByZeroException：当程序尝试除以0时抛出。
 3. ​​IllegalInputException：当输入与我们期望的格式不匹配时抛出。此异常有一个String变量exceptionType和该变量的get和set方法。
 通过IllegalInputException构造函数设置exceptionType，并提供有关发生哪种输入错误的更多详细信息。
 要提供的有效字符串为：
 （a）“Illegal Token Length”：当运算符数量小于1或大于3时。
 （b）“Illegal Argument”：当操作数与预期的操作符类型不匹配时。例如，在输入"1 + a"时，"a"是非法操作数，因为它不是整数。 
 （c）“Illegal Operator”：程序不支持的运算符。该程序仅接受"+-*/"运算符。因此，"1 ^ 2"将产生此错误。
 
 
 实现步骤
 1.完成QuitException类的实现。 
 2.完成DivideByZeroException类的实现。
 3.完成IllegalInputException类的实现。 
 4.完成Calculator类的实现。 