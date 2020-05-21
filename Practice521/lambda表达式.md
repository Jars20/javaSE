# 前置知识

* 类和接口
* 匿名内部类

# 课程结构

lambda 是java 8开始引入的特性。首先我们将介绍lambda相关概念和引入lambda用来解决什么问题。然后我们将介绍lambda的语法和定义方式，lambda语法和之前java和c语法有很大的差异，因此我们逐一列举了所有出现的场景，初学的时候，可以先熟悉语法模式进行套用，熟悉语法后，可以编写复杂的接收lambda表达式的方法。最后介绍lambda捕获外部变量的规则，这部分内容主要是为了加强理解和保证知识结构的完整，不作为重点。最后介绍lambda中引用其他方法的语法，同样需要先熟悉语法套路，通过不断的编写代码来熟悉相关语法。

# 学习目标

- 理解java lambda的实现方式
- 学会定义和使用lambda表达式
- 掌握一些内置的函数式接口的使用

# lambda

lambda 是希腊字母`λ`，最早是由数学家引入用于表示带参数变量的表达式，之后逐渐被编程语言引入

有些应用场景需要向一个对象中传递一个方法（动作），在合适的时候由对象调用这个方法(回调)，在c语言中可以使用函数指针传递函数，早期java中需要将这个方法实现在一个类中，然后实例化一个对象传入，或者创建一个匿名内部类传入。

Java 8开始可以使用lambda来简化这样的代码的写法。通过引入Lambda，最直观的一个改进是不用再写大量的匿名内部类，代码的可读性会更好，集合操作也得到了极大的改善，处理集合时，Java程序员可以告别for,while,if这些语句，一些集合的过滤、查询等操作都可以并行化

## java lambda表达式

Java中lambda表达式是一种语法结构。用来定义一个不属于任何类的方法。方法可以像对象一样传递并按需被调用。这种方式有别于面向对象，是函数式编程的一种思维模式。java根据自己的语言特性提供了传递方法的支持。Java lambda表达式通常用于实现回调以及在集合操作时指定操作方式。

## 函数式接口

只有一个抽象方法的接口，被称作是函数式接口（functional interface）。java中方法必须定义在类的内部，为了实现方法传递，需要使用匿名内部类包裹方法进行传递。因此在java 8之后，只有一个抽象方法的接口，被赋予另一层意义，就是可以使用lambda表达式表示这样的一个接口对象，表达式实现了这个接口中的唯一的抽象方法。

# Lambda的数据类型

函数式编程通常用于实现事件监听器，监听器的方法当事件被触发的时候调用。Java中的事件监听器通常被定义为具有单个方法的Java接口。以下是自定义的函数式接口示例

```
public interface MessageListener {

    void onMessage(String Message);

}
```

这个Java接口中只包含一个需要子类重写的抽象方法，只要收到信息，都将调用该方法。

在引入lambda以前，必须定义实现此接口的类才能处理消息。比如一个名为`MessageOwner`的类可以注册监听器，如下

```
public class MessageOwner {

    public void addMessageListener(MessageListener listener) { ... }

}
```

在引入lambda之前，可以使用匿名内部类的实现添加监听器，如下

```
MessageOwner messageOwner = new MessageOwner();

messageOwner.addMessageListener(new MessageListener() {

    public void onMessage(String Message) {
        // 处理收到的消息
    }
});
```

首先MessageOwner创建一个实例。然后，将MessageListener接口的匿名实现添加到MessageOwner实例上

可以使用Java lambda表达式完成上述功能，如下

```
MessageOwner messageOwner = new MessageOwner();

messageOwner.addMessageListener(
    message -> System.out.println("收到消息:" + message)
);
```

lambda表达式是这一部分

```
message -> System.out.println("收到消息:" + message)
```

lambda表达式与`addMessageListener(MessageListener listener)`方法参数的数据类型匹配。可以把lambda表达式理解为函数式接口的匿名内部类的简化的实现。

Java lambda表达式只能匹配函数式接口数据类型。在上面的示例中，lambda表达式用作参数，其中参数类型为 MessageListener接口。该接口只有一个抽象方法。因此，lambda表达式的数据类型能够成功匹配。

编译器通过以下几点确定Java lambda表达式与函数式接口数据类型是否匹配

- 接口是否只有一个抽象方法？
- lambda表达式的参数是否与抽象方法的参数匹配？
- lambda表达式的返回类型是否与抽象方法的返回类型匹配？

如果对这三个问题的答案都为“是”，则lambda表达式成功匹配函数式接口。

## Lambda表达式的类型推断

如果单纯看如下的lambda表达式，是无法确定到底实现了哪个函数式接口的

```
message -> System.out.println("收到消息:" + message)
```

编译器通常可以从周围的代码中推断出表达式的数据类型。例如，可以从方法的方法声明`addMessageListener(MessageListener listener)`推断参数的接口类型。这称为类型推断。编译器通过在其他地方（这个例子是从接口定义处）寻找类型的信息来推断方法调用时传入的lambda表达式数据类型。 在lambda表达式中，通常也可以推断出参数的数据类型。编译器可以从`void onMessage(String Message);`方法声明中推断`message`的参数数据类型。

# Lambda表达式语法

lambda使用 `->` 连接参数和方法体。通常有以下几种定义方式

```
( ) -> {
    语句
    return 返回值;
};
(数据类型 参数1,数据类型 参数2 ) -> {
    语句
    return 返回值;
};
// 省略参数类型
(参数1,参数2 ) -> {
    语句
    return 返回值;
};
// 只有一个参数的时候，省略括号
参数 -> {
    语句
    return 返回值;
};
// 如果只有一句话，可以省略大括号, return 关键字也可以省略。
参数 -> 语句;
```

## Lambda参数

由于Java lambda表达式实际上只是方法，因此lambda表达式可以像方法一样接受参数。`->`前的部分指定了lambda表达式需要的参数。这些参数必须与函数式接口抽象方法的参数数量和数据类型匹配。

### 零参数

如果lambda表达式实现的方法不带参数，则可以这样编写lambda表达式：

```
() -> System.out.println("无参数的lambda");
```

请注意，括号之间没有内容并且不能省略。表示lambda不带任何参数。

### 一个参数

如果Java lambda表达式方法使用一个参数，则可以这样编写lambda表达式：

```
 (param) -> System.out.println("一个参数: " + param);
```

请注意，参数在括号内列出。

当lambda表达式采用单个参数时，您也可以省略括号，如下所示：

```
 param -> System.out.println("一个参数: " + param);
```

### 多个参数

如果lambda表达式与之匹配的方法带有多个参数，则需要在括号内列出这些参数。如下

```
(p1, p2) -> System.out.println("多个参数: " + p1 + ", " + p2);
```

仅当方法采用单个参数时，才可以省略括号。

### 参数类型

如果编译器无法从lambda匹配的接口方法推断参数类型，则需要为lambda表达式指定参数类型。这种情况较少出现，如果编译器报错提示需要增加参数类型说明，则按照如下方式定义参数

```
(Car car) -> System.out.println("汽车名字: " + car.getName());
```

参数的类型（Car）car写在参数名称本身的前面，就像在其他方法中声明参数或对接口进行匿名实现时一样。

## Lambda方法体

lambda表达式的方法体在`->`的右侧指定,如下

```
(oldState, newState) -> System.out.println("State changed")
```

如果lambda表达式需要包含多行，则可以将lambda方法体括在`{}`，如下

```
(oldState, newState) -> {
    System.out.println("Old state: " + oldState);
    System.out.println("New state: " + newState);
  }
```

可以从lambda表达式返回值，就像从方法中返回值一样。只需要增加`return`语句，如下所示：

```
(param) -> {
    System.out.println("param: " + param);
    return "return value";
  }
```

如果lambda表达式方法体中只有一条`return`语句。如下：

```
（a1，a2）-> {return a1> a2; }
```

可以将`return`省略，编译器会自动推断出表达式的值作为返回值

```
 （a1，a2）-> a1> a2;
```

## Lambda作为对象

lambda表达式本质上是一个对象。可以将lambda表达式保存到变量中并将其传递，就像处理其他任何对象一样。如下：

```
public interface MyComparator {

    public boolean compare(int a1, int a2);

}
MyComparator myComparator = (a1, a2) -> return a1 > a2;

boolean result = myComparator.compare(2, 5);
```

lambda表达式如何分配给变量后，可以通过变量直接调用方法的方式，使用表达式中定义的方法。

## 带有默认或静态方法的函数式接口

从Java 8开始，Java接口可以同时包含默认方法和静态方法。默认方法和静态方法都要直接在接口声明中定义实现。即使接口包含默认方法和静态方法，只要该接口仅包含单个未实现（抽象）的方法，它仍然是功能性接口。

可以使用lambda表达式实现以下接口：

```
import java.io.IOException;
import java.io.OutputStream;

public interface MyInterface {

    void printIt(String text);

    default public void printUtf8To(String text, OutputStream outputStream){
        try {
            outputStream.write(text.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Error writing String as UTF-8 to OutputStream", e);
        }
    }

    static void printItToSystemOut(String text){
        System.out.println(text);
    }
}
```

即使此接口包含3种方法，也可以通过lambda表达式实现，因为只有一种方法没有实现。以下是使用lambda实现接口的示例

```
MyInterface myInterface = (String text) -> {
    System.out.print(text);
};
```

# Lambda表达式与匿名内部类

即使lambda表达式接近匿名内部类实现，也有一些值得注意的区别。

主要区别在于，匿名内部类可以具有状态（成员变量），而lambda表达式则不能。看一下这个界面：

```
public interface MyEventConsumer {
    public void consume(Object event);
}
```

可以使用匿名内部类来实现此接口，如下

```
MyEventConsumer consumer = new MyEventConsumer() {
    public void consume(Object event){
        System.out.println(event.toString() + " consumed");
    }
};
```

此匿名MyEventConsumer实现可以具有自己的内部状态。看一下这个重新设计：

```
MyEventConsumer myEventConsumer = new MyEventConsumer() {
    private int eventCount = 0;
    public void consume(Object event) {
        System.out.println(event.toString() + " consumed " + this.eventCount++ + " times.");
    }
};
```

请注意，匿名MyEventConsumer实现现在具有名为eventCount的成员变量。Lambda表达式不能包含此类成员。因此，lambda表达式是无状态的。（有状态指的是方法调用一次后可以记录上一次调用时的一些数据，会对下次调用产生影响。无状态表示方法每次调用都是独立的，只要入参一样，结果一定是一致的）

# 变量捕获

lambda表达式能够访问在lambda方法体外部声明的变量。被称作变量捕获

Java lambda可以捕获以下类型的变量：

- 局部变量
- 实例变量
- 静态变量

## 局部变量捕获

lambda可以捕获在lambda主体外部声明的局部变量的值。为了说明这一点，首先看一下这个单一方法接口：

```
public interface MyFactory {
    public String create(char[] chars);
}
```

现在，看一下实现MyFactory接口的以下lambda表达式：

```
MyFactory myFactory = (chars) -> {
    return new String(chars);
};
```

现在，lambda表达式仅引用传递给它的参数值（chars）。可以如以下的方式使用外部定义的局部变量

```
String myString = "Test";

MyFactory myFactory = (chars) -> {
    return myString + ":" + new String(chars);
};
```

lambda方法体中引用了myString。必须保证被引用的变量是"Effective final"的，这意味着在赋值之后它不会改变其值。如果出现了第二次修改myString值的语句，则编译报错

## 成员变量捕获

Lambda表达式还可以捕获创建Lambda的对象中的成员变量。这是显示示例：

```
public class EventConsumerImpl {

    private String name = "MyConsumer";

    public void attach(MyEventProducer eventProducer){
        eventProducer.listen(e -> {
            System.out.println(this.name);
        });
    }
}
```

注意this.name在lambda方法体内部的使用。这捕获了调用`attach`方法的`EventConsumerImpl`对象中name变量。如果`EventConsumerImpl`的name变量值被修改了，修改的值将反映在lambda内部，反之也是一样。

这里需要注意的是，lambda表达式内部的this并非指代lambda定义的对象，因为lambda中不能定义成员变量，因此这里的this始终指代定义了lambda的对象

这里的示例仅仅为了说明成员变量的捕获，实际开发中应该尽量避免将lambda变为有状态的使用方式。

## 静态变量捕获

lambda表达式还可以捕获静态变量。因为只要具备方位静态变量的访问权限，程序中的任何地方都可以访问静态变量。

这是一个示例类，它创建一个lambda，该lambda从lambda主体内部引用一个静态变量：

```
public class EventConsumerImpl {
    private static String someStaticVar = "Some text";

    public void attach(MyEventProducer eventProducer){
        eventProducer.listen(e -> {
            System.out.println(someStaticVar);
        });
    }
}
```

lambda捕获到静态变量后，它的值也可以更改。

该示例也仅仅为了展示lambda可以访问静态变量，避免在实际应用中出现类似的使用。

# Lambda的方法引用

如果lambda表达式代码块中调用另一个方法，java中提供了一种方法调用的简写方法。首先，这是一个示例单功能接口：

```
public interface MyPrinter{
    public void print(String s);
}
```

以下是创建实现MyPrinter接口的Java lambda实例的示例：

```
MyPrinter myPrinter = (s) -> { System.out.println(s); };
```

因为lambda主体仅包含一个语句，所以我们实际上可以省略{ } 括号。另外，由于lambda方法只有一个参数，因此我们可以省略( ) 该参数周围的括号。这是生成的lambda声明的外观：

```
MyPrinter myPrinter = s -> System.out.println(s);
```

由于lambda主体所做的一切都是将字符串参数转发给System.out.println()方法，因此我们可以将上述lambda声明替换为方法引用。以下是lambda方法参考的外观：

```
MyPrinter myPrinter = System.out::println;
```

注意双冒号`::`。这些向Java编译器发出信号，这是方法参考。引用的方法是双冒号之后的内容。拥有引用方法的任何类或对象都在双冒号之前。

您可以引用以下类型的方法：

静态方法 参数对象的实例方法 实例方法 建设者 以下各节介绍了每种类型的方法引用。

## 引用静态方法

最容易引用的方法是静态方法。首先是单个功能接口的示例：

```
public interface Finder {
    public int find(String s1, String s2);
}
```

这是一个静态方法，我们要创建一个方法引用：

```
public class MyClass{
    public static int doFind(String s1, String s2){
        return s1.lastIndexOf(s2);
    }
}
```

最后是引用静态方法的Java lambda表达式：

```
Finder finder = MyClass::doFind;
```

由于Finder.find()和MyClass.doFind()方法的参数匹配，因此可以创建实现Finder.find()和引用该MyClass.doFind()方法的lambda表达式。

## 引用参数方法

您还可以将参数之一的方法引用到lambda。如下是一个函数式接口：

```
public interface Finder {
    public int find(String s1, String s2);
}
```

该接口旨在表示能够搜索s1的出现的组件s2。这是一个调用String.indexOf()搜索的Java lambda表达式的示例：

```
Finder finder = String::indexOf;
```

Java编译器将使用第一个参数调用`indexOf`方法，传入使用第二个参数作为方法参数，等价于以下代码

```
Finder finder = (s1, s2) -> s1.indexOf(s2);
```

## 引用实例方法

还可以从lambda定义中引用实例方法。首先，让我们看一个方法接口定义：

```
public interface Deserializer {
    public int deserialize(String v1);
}
```

此接口表示一个组件，该组件能够将a“反序列化” String为 int。

现在来看这个StringConverter课：

```
public class StringConverter {
    public int convertToInt(String v1){
        return Integer.valueOf(v1);
    }
}
```

该convertToInt()方法具有相同的签名deserialize()的方法 Deserializer deserialize()方法。因此，我们可以从Java lambda表达式创建一个实例 StringConverter并引用其convertToInt()方法，如下所示：

```
StringConverter stringConverter = new StringConverter();

Deserializer des = stringConverter::convertToInt;
```

两行中的第二行创建的lambda表达式引用在第一行中创建convertToInt的StringConverter实例的方法。

## 构造方法引用

最后，可以引用一个类的构造函数。为此，您可以编写类名，后跟::new，如下所示：

```
MyClass::new
```

要了解如何将构造函数用作lambda表达式，请查看以下接口定义：

```
public interface Factory {
    public String create(char[] val);
}
```

create()此接口 的方法与String 类中构造函数之一的签名匹配。因此，此构造函数可用作lambda。这是一个看起来的例子：

```
Factory factory = String::new;
```

这等效于此Java lambda表达式：

```
Factory factory = chars -> new String(chars);
```