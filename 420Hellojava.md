# 练习 
1. 抄写一份Hello.java放到当前路径下，编译运行Hello.java，请记录打开终端开始到程序运行期间所有输入的终端命令
>所有指令：1.javac编译.Java文件生成.class
        2.java调用虚拟机（JVM）读取.class
2. 将编译生成的Hello.class文件删除，编辑Hello.java将class后面的名称修改为test，然后编译Hello.java文件
* 生成的class文件名是什么
>Hello.class
* 请尝试使用java运行编译后的文件，应该输入什么命令
>
java Hello
3. 保持上一题的状态，编辑Hello.java将class后面的名称修改为Test，然后编译Hello.java
是否生成新的class文件
>会生成Test.class
* 请尝试使用java运行编译后的文件，应该输入什么命令
>java Test
* 将test.class 重命名为test1.class后尝试运行，是否可以运行成功，如果不成功记录错误
>错误: 找不到或无法加载主类 Test1.class
原因: java.lang.ClassNotFoundException: Test1.class
* 将test.class 重命名为TEST.class尝试运行，是否可以运行成功，如果不成功记录错误
>可以运行
4. 仿照Hello.java写一个HelloWorld.java, 其中class声明为HelloWorld，向屏幕输出Hello World!

>class HelloWorld{

	public static void main (String[] args){

		System.out.println("Hello World!");
	}
}

# 总结
javac 根据指定的文件名来编译文件，生成的class文件命名和文件内部定义的名称一致，生成class文件之前先到路径位置查找是否有相同名字的class文件，查找的时候不区分大小写，如果有这个文件，就把编译后的内容进行覆盖，如果没有这个文件则创建和class同名的文件。

java程序根据后面传入的类名来搜索对应名字的class文件，搜索的时候不区分文件的大小写。如果找不到文件，则会出现java.lang.ClassNotFoundException错误。如果找到了文件，但是文件内部定义的class名称大小写和传入的不匹配，则会出现java.lang.NoClassDefFoundError。注意一个是类没有找到，一个是类没有定义。