这段代码提供了一个简单的移动电话模拟。电话一次只能接一个电话。当一个呼叫正在进行时，不应该接受其他呼叫。打电话的人等到上一个电话挂断后才能接入电话

CellularPhone - 一个电话的模拟器(没有用户界面)。可以被告知电话已经开始，电话已经结束，并且可以在屏幕上显示一个信息字符串
PhoneCallGenerator - 生成对特定电话的呼叫。
Driver - 程序入口。
当程序正确工作时，模拟器应该显示电话等待，处理来自Jerry和Tom的电话，
输出的一个示例部分如下所示(注意，由于程序是并发的，所以每次运行时输出结果都会略有差异)。
```
<Phone>: Waiting...
<Jerry>: Call (1) begins
    <Jerry>: Call (1) ends
<Jerry>: Call (2) begins
   <Jerry>: Call (2) ends
<Jerry>: Call (3) begins
   <Jerry>: Call (3) ends
```