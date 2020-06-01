这段代码提供了一个简单的移动电话模拟。电话一次只能接一个电话。当一个呼叫正在进行时，不应该接受其他呼叫。相反，打电话的人应该收到电话不可用的提示(例如:对方繁忙)。

CellularPhone - 一个电话的模拟器(没有用户界面)。可以被告知电话已经开始，电话已经结束，并且可以在屏幕上显示一个信息字符串
PhoneCallGenerator - 生成对特定电话的呼叫。
Driver - 程序入口。
当程序正确工作时，模拟器应该显示电话等待，处理来自Jerry和Tom的电话，以及由于占线信号而掉线的电话。
注意，CellularPhone类的startCall方法，当方法正确工作时，如果调用被接受，它将返回true;如果调用已经在进行中，它将返回false(因此当前调用被丢弃)。
输出的一个示例部分如下所示(注意，由于程序是并发的，所以每次运行时输出结果都会略有差异)。
确保使用Lock对象而不是同步方法。
```
<Phone>: Waiting...
<Jerry>: Call (1) begins
    <Jerry>: Call (1) ends
<Jerry>: Call (2) begins
<Tom>: Busy, call (1) dropped
<Tom>: Busy, call (2) dropped
   <Jerry>: Call (2) ends
<Phone>: Waiting...
<Jerry>: Call (3) begins
   <Jerry>: Call (3) ends
```


需要Driver类中创建至少MessageGenerator(就像phonecallgenerator一样)。
要使用MessageGenerator，需要将以下方法添加到CellularPhone类:

将消息输出到控制台
* public void addMessage( String newMessage )

打印出手机收到的所有信息。
* private void displayMessages()


```
<Phone>: Waiting...
<Jerry>: Call (1) begins
<Tom>: Busy, call (1) dropped
<Jerry>: Call (1) ends
<Phone>: Message: Mother 1
<Phone>: Message: Mother 2
<Phone>: Message: Mother 3
<Phone>: Message: Father 1
<Phone>: Message: Brother 1
<Phone>: Message: Sister 1
<Phone>: Message: Father 2
<Phone>: Message: Brother 2
<Phone>: Message: Father 3
<Phone>: Message: Brother 3
<Phone>: Message: Mother 4
<Phone>: Message: Sister 2
<Phone>: Message: Brother 4
<Phone>: Message: Mother 5
<Phone>: Message: Father 4
<Phone>: Message: Brother 5
<Phone>: Waiting...
<Jerry>: Call (2) begins
<Jerry>: Call (2) ends
<Jerry>: Call (3) begins
<Tom>: Busy, call (2) dropped
<Tom>: Busy, call (3) dropped
<Jerry>: Call (3) ends
```