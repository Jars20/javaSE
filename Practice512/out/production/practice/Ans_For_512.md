### 写出以下程序的输出结果
> Question: 6,12，17,20,26，28

#### 1. 以下代码能否通过编译，为什么
```
class Outer{
 public static void main(String[] args){
  new Inner(); 
 } 
 class Inner { 
  Inner() {} 
 }  
}
```
>错误。不能在static的main中引用动态的this
#### 2. 以下代码能否通过编译，为什么
```
static class Outer{
 public static void main(String[] args){
 //
 }
 private class Inner{
  Inner() {} 
 }
}
```
>错误。外部类不能static

#### 3.
```
class Outer {
 String s1 = "Java";
 String s2 = "2";

 public static void main(String[] args) { 
  Outer outer = new Outer();  
 }
 Outer() { 
  Inner inner = new Inner();  
 }
 class Inner {
  String s1 = "Certification";
  String s2 = "Exam";
        
  Inner() {
   System.out.println(Outer.this.s1);
   System.out.println(this.s1);
   System.out.println(s2);
  }
 }
}
```
>输出值：Java；Certification；Exam；               //因为this.s2指向内部类的s2
#### 4. 以下代码能否通过编译，为什么
```
class A
{
    class B
    {
        static void methodB()
        {
            System.out.println("Method B");
        }
    }
}
```
>错误。非static的内部类不得有static方法
#### 5.
```
class OuterInnerStatic {
 static String s1 = "Java"; 
 static String s2 = "2";
 public static void main(String[] args) { 
  Inner inner = new Inner();  
}

 static class Inner {
  String s1 = "Certification";
  String s2 = "Exam";
  Inner() {
   System.out.println(OuterInnerStatic.s1);
   System.out.println(this.s1);
   System.out.println(s2);
  }
 }
}

```
>输出：Java；Certification；Exam；

#### 6.
```
class X
{
    static int x = 3131;
     
    static class Y
    {
        static int y = x++;
         
        static class Z
        {
            static int z = y++;
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        System.out.println(X.x);
         
        System.out.println(X.Y.y);
         
        System.out.println(X.Y.Z.z);
    }
}
```
>输出：3131；3131；3131；（？？？）


#### 7. 在下面的示例中，如何访问"XYZ"类的"i"字段？
```
class ABC
{
    class XYZ
    {
        int i = 111;
    }
}
```
>ABC a = new ABC();  
>ABC.XYZ b= a.new XYZ();             //ABC.XYZ b = new ABC.new XYZ();
>b.i


#### 8. 运行以下程序时，它是否在控制台上打印“SUCCESS”？
```
class A
{
    {
        new B();
    }
     
    static class B
    {
        {
            new A().new C();
        }
    }
     
    class C
    {
        {
            System.out.println("SUCCESS");
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}
```
>运行报错。new A与new B递归调用陷入死循环

#### 9. 以下代码能否通过编译，为什么
```
class A
{
    String s = "AAA";
     
    void methodA()
    {
        System.out.println(s);
    }
     
    static class B
    {
        void methodB()
        {
            methodA();
        }
    }
}
```
>不能。静态内部类中调用了非静态的方法。

#### 10.
```
abstract class A
{
    {
        System.out.println(1);
    }
     
    static
    {
        System.out.println(2);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A() { };
    }
}
```
>输出：2；1；
#### 11.
```
class A
{
    static String s = "AAA";
     
    class B
    {
        String s = "BBB";
         
        void methodB()
        {
            System.out.println(s);
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();
         
        System.out.println(a.s);
         
        A.B b = a.new B();
         
        System.out.println(b.s);
         
        b.methodB();
    }
}
```
>输出：AAA；BBB；BBB；


#### 12. 以下代码能否通过编译，为什么
```
class A
{
    void methodOne()
    {
        class B
        {
            void methodTwo()
            {
                System.out.println("Method Two");
            }
        }
    }
     
    void methodThree()
    {
        new B().methodTwo();
    }
}
```
>（？？？）不能。方法{内部类{方法}}

#### 13
```
class X
{
    {
        System.out.println(1);
    }
     
    static
    {
        System.out.println(2);
    }
     
    public X()
    {
        new Y();
    }
     
    static class Y
    {
        {
            System.out.println(3);
        }
         
        static
        {
            System.out.println(4);
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        X x = new X();
         
        X.Y y = new X.Y();
    }
}
```
> 注意⚠️！当仅仅new X时，输出2143；  
>     当仅仅new X.Y时，输出43;(Y为静态的)； 
>     当new X后再次new X.Y时，由于Y为static，所以不会再次运行静态代码块。

#### 14. 以下代码能否通过编译，为什么
```
class A
{
    class B
    {
        {
            System.out.println(1);
        }
         
        static
        {
            System.out.println(2);
        }
    }
}
```
>编译报错。因为非静态的内部类B中不能有静态代码块

#### 15.
```
class ABC
{
    int i = 10101;
     
    {
        i--;
    }
     
    public ABC()
    {
        --i;
    }
     
    class XYZ
    {
        int i = this.i;
         
        {
            i++;
        }
         
        public XYZ() 
        {
            ++i;
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        ABC abc = new ABC();
         
        System.out.println(abc.i);
         
        ABC.XYZ xyz = abc.new XYZ();
         
        System.out.println(xyz.i);
         
        ABC.XYZ xyz1 = new ABC().new XYZ();
         
        System.out.println(xyz1.i);
    }
}
```
>输出：10099；2；2；因为在内部类中使用this调用时调用的是自己。要是想调用外部类的成员对象需要Outer.this来调用
#### 16.
```
class P
{
    String s = "PPP";
     
    {
        System.out.println(s);
    }
     
    String methodP()
    {
        class Q
        {
            String s = P.this.s+"QQQ";
             
            {
                System.out.println(s);
            }
        }
         
        return new Q().s+s;
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        P p = new P();                          //"PPP"
         
        System.out.println(p.methodP());        //"PPPQQQ";"PPPQQQPPP";
    }
}

```
>printout:PPP;QQQ;PPPQQQPPP

#### 17. 

```
class A
{
    void methodA1(int i)
    {
        System.out.println(i+++i);       //先i，执行i++，i=11，i+11=21
    }
     
    void methodA2(int i)
    {
        System.out.println(--i-i--);    //先--i，i=9，i-i = 0；
    }
}
 
class B
{
    A a = new A()
    {
        void methodA1(int i)            
        {
            System.out.println(++i+i++);            // 先++i，i=11，i+i=22；
        }
         
        void methodA2(int i)
        {
            System.out.println(i---i);              //先i--，temp = 10，i=9，temp - i = 1
        }
    };
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();
         
        a.methodA1(10);
         
        a.methodA2(10);
         
        B b = new B();
         
        b.a.methodA1(10);
         
        b.a.methodA2(10);
    }
}

```
>输出：21；0；22；1;(???)(☑️)

#### 18. 以下代码能否通过编译，为什么
```
class One
{
    void methodOne()
    {
        public class Two
        {
             
        }
    }
}
```
>（？？？）不可以编译，public访问权限修饰符错误。


#### 19.

```
class One
{
    {
        System.out.println("ONE");
    }
     
    class Two
    {
        {
            System.out.println("TWO");
        }
    }
     
    static
    {
        System.out.println("THREE");
    }
     
    static class Three
    {
        {
            System.out.println("FOUR");
        }
         
        static
        {
            System.out.println("FIVE");
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        One one = new One();            //THREE；ONE
         
        One.Two two = one.new Two();            //TWO
         
        One.Three three = new One.Three();              //FIVE,FOUR
    }
}
```
>printout:THREE;ONE;TWO;FIVE;FOUR

#### 20. 以下代码能否通过编译，为什么
```
class A
{
    class B extends A
    {
        class C extends B
        {
            class D extends C
            {
                 
            }
        }
    }
}
```
>可以编译（？）


#### 21.
```
abstract class X
{
    static String s1 = "STATIC";
     
    String s2 = "NON-STATIC";
     
    abstract void methodX(); 
     
    static abstract class Y
    {
        String s1 = "NON-STATIC";
         
        static String s2 = "STATIC";
         
        abstract void methodY();
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new X() 
        {   
            void methodX()
            {
                System.out.println(s1+" "+s2);
            }
        }.methodX();
         
        new X.Y() 
        {   
            void methodY() 
            {
                System.out.println(s1+" "+s2);
            }
        }.methodY();
    }
}
```
>STATIC NON-STATIC;
>NON-STATIC STATIC;


#### 22. 在下面的示例中，如何访问“内部类”的“i”字段？
```
class OuterClass
{
    static class InnerClass
    {
        int i;
    }
}
```
> OuterClass.InnerClass.i;

#### 23.
```
class X
{   
    static
    {
        class Y
        {   
            {
                System.out.println(1);
            }
        }
    }
     
    {
        class Y
        {
            {
                System.out.println(2);
            }
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new X();
    }
}
```
>注意⚠️//编译报错，static的构造方法中调用非静态的Y（❌）(???)
>答案：无输出，没有执行Y的构造方法

#### 24.
```
class A
{   
    abstract class B
    {
        abstract void method();
    }
     
    {
        new B()
        {
             
            @Override
            void method()
            {
                System.out.println("BBB");
            }
        }.method();
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}
```
>  执行B的method，输出：BBB

#### 25.
```
class X
{   
    void methodX()
    {
        class Y
        {
            static void methodY()
            {
                 
            }
        }
    }
}
```
>  编译报错。非静态内部类class Y 中不能有静态方法

#### 26. 如何在class A以外的其他类中实例化 class B
```
class A
{
    void methodA()
    {
        class B
        {
             
        }
    }
}
```
> 无法实例化，因为classb B为局部申请的类，随着方法运行的结束而结束，不能实例化

#### 27.
```
public class Outer 
{ 
	public static int temp1 = 1; 
	private static int temp2 = 2; 
	public int temp3 = 3; 
	private int temp4 = 4; 
	
	public static class Inner 
	{ 
		private static int temp5 = 5; 
		
		private static int getSum() 
		{ 
			return (temp1 + temp2 + temp3 + temp4 + temp5); 
		} 
	} 
	
	public static void main(String[] args) 
	{ 
		Outer.Inner obj = new Outer.Inner(); 
		System.out.println(obj.getSum()); 
	} 
	
} 

```
>编译报错，不能从静态方法中引用非静态变量temp3与temp4

#### 28.
```
public class Outer  
{ 
    private static int data = 10; 
    private static int LocalClass() 
    { 
        class Inner 
        { 
            public int data = 20; 
            private int getData() 
            { 
                return data; 
            } 
        }; 
        Inner inner = new Inner(); 
        return inner.getData(); 
    } 
      
    public static void main(String[] args) 
    { 
        System.out.println(data * LocalClass()); 
    } 
} 

```
>注意⚠️！！可以编译（？？？）                //静态方法中可以调用new匿名内部类
>输出：200

#### 29.
```
interface Anonymous 
{ 
	public int getValue(); 
} 
public class Outer 
{ 
	private int data = 15; 
	public static void main(String[] args) 
	{ 
		Anonymous inner = new Anonymous() 
				{ 
					int data = 5; 
					public int getValue() 
					{ 
						return data; 
					} 
					public int getData() 
					{ 
						return data; 
					} 
				}; 
		Outer outer = new Outer(); 
		System.out.println(inner.getValue() + inner.getData() + outer.data); 
	} 
} 

```
>编译报错。注意！！⚠️不能调用Anonymous中的没有声明的getData方法

#### 30.
```
public class Outer 
{ 
    private int data = 10; 
      
    class Inner 
    { 
        private int data = 20; 
        private int getData() 
        { 
            return data; 
        } 
        public void main(String[] args) 
        { 
            Inner inner = new Inner(); 
            System.out.println(inner.getData()); 
              
        } 
    } 
    private int getData() 
    { 
        return data; 
    } 
    public static void main(String[] args) 
    { 
        Outer outer = new Outer(); 
        Outer.Inner inner = outer.new Inner(); 
        System.out.printf("%d", outer.getData());       //10
        inner.main(args);                               //20
    } 
} 
```
>

#### 31.
```
interface OuterInterface 
{ 
    public void InnerMethod(); 
    public interface InnerInterface 
    { 
        public void InnerMethod(); 
    } 
} 
public class Outer implements OuterInterface.InnerInterface, OuterInterface 
{ 
    public void InnerMethod() 
    { 
        System.out.println(100); 
    } 
      
      
    public static void main(String[] args) 
    { 
        Outer obj = new Outer(); 
        obj.InnerMethod(); 
    } 
} 
```
>两个接口，重写后输出100
