### 目的
熟悉jar打包的相关命令行操作

### 练习
dist下的main.jar 中缺少了club/banyuan/animal/Dog.class和META-INF/MANIFEST.MF。
请编译src下的Dog.java生成Dog.class。
1. 将Dog.class打包成Dog.jar，放置到lib路径下，使用java运行main.jar中club.banyuan.Main类中的main方法
2. 将Dog.class添加到main.jar中，使用java -jar main.jar 运行程序(需要增加META-INF/MANIFEST.MF到jar包中，指定Main-Class)。

程序成功运行后输出
<pre>
训练狗狗小强
小强: 汪汪
狗狗小强和猫咪汤姆一起玩
汤姆: 喵..
</pre>

