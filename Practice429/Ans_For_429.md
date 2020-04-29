### 编程练习
使用java类描述一个学生类和其子类(小学生类、 中学生类， 高中生类)。
* 学生都具备名字成员和对应的get和set方法，get和set方法不能够被子类重写。
学生具备一个传入String名字的构造方法。
* 都具备学习的方法。调用学习的方法
* 编写一个main方法测试编写的类，依次创建小学生、中学生、高中生对象，分别调用学习的方法。


### 以下程序的输出结果是

#### 1.
```
class Clidder  
{ 
    private final void flipper()  
    { 
        System.out.println("Clidder"); 
    } 
} 
  
public class Clidlet extends Clidder  
{ 
    public final void flipper()  
    { 
        System.out.println("Clidlet"); 
    } 
    public static void main(String[] args)  
    { 
        new Clidlet().flipper();                //flipper为private类型，只能在自己类中调用
    } 
} 
```

#### 2.
```
class Alpha  
{ 
    static String s = " "; 
    protected Alpha()  
    { 
        s += "alpha "; 
    } 
} 
class SubAlpha extends Alpha  
{ 
    private SubAlpha()  
    { 
        s += "sub "; 
    } 
} 
  
public class SubSubAlpha extends Alpha  
{ 
    private SubSubAlpha()  
    { 
        s += "subsub "; 
    } 
    public static void main(String[] args)  
    { 
        new SubSubAlpha(); 
        System.out.println(s);      //printout：alpha subsub
    } 
} 
```
#### 3.
```
class Grandparent  
{ 
    public void Print()  
    {                           
        System.out.println("Grandparent's Print()");          
    }  
} 
  
class Parent extends Grandparent  
{ 
    public void Print()  
    { 
        System.out.println("Parent's Print()");  
    }  
} 
  
class Child extends Parent  
{ 
    public void Print()    
    { 
        super.super.Print();                    //super.super编译错误
        System.out.println("Child's Print()");  
    }  
} 
  
public class Main  
{ 
    public static void main(String[] args)  
    { 
        Child c = new Child(); 
        c.Print();  
    } 
} 
```
#### 4.
```
final class Complex {
 
    private final double re;
    private final double im;
 
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
 
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
 
class Main {
  public static void main(String args[])
  {
       Complex c = new Complex(10, 15);
       System.out.println("Complex number is " + c);
  }                                 //printout:Complex number is (10.0 + 15.0i)
}
```
#### 5.
```
class A
{
    String s = "Class A";
}
 
class B extends A
{
    String s = "Class B";
 
    {
        System.out.println(super.s);
    }
}
 
class C extends B
{
    String s = "Class C";
 
    {
        System.out.println(super.s);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();                      //printout:Class A;
                                            //printout:Class B;
 
        System.out.println(c.s);            //printout:Class C;
    }
}
```
#### 6.
```
class A
{
    static
    {
        System.out.println("THIRD");
    }
}
 
class B extends A
{
    static
    {
        System.out.println("SECOND");
    }
}
 
class C extends B
{
    static
    {
        System.out.println("FIRST");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();                      //printout: THIRD;SECOND;FIRST
    }
}
```
#### 7.
```
class X
{
    static void staticMethod()
    {
        System.out.println("Class X");
    }
}
 
class Y extends X
{
    static void staticMethod()
    {
        System.out.println("Class Y");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        Y.staticMethod();               //printout:CLASS Y;
    }
}
```
#### 8.

```
class M
{
    static
    {
        System.out.println('A');
    }
 
    {
        System.out.println('B');
    }
 
    public M()
    {
        System.out.println('C');
    }
}
 
class N extends M
{
    static
    {
        System.out.println('D');
    }
 
    {
        System.out.println('E');
    }
 
    public N()
    {
        System.out.println('F');
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N();
    }                           //printout:A;B;C;D;E;F;(?)
                                //printout:A;D;B;C;E;F;
}
```
#### 9.

```
class A
{
	static String s = "AAA";

	static
	{
		s = s + "BBB";
	}

	{
		s = "AAABBB";
	}
}

class B extends A
{
	static
	{
		s = s + "BBBAAA";
	}

	{
		System.out.println(s);
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		B b = new B();                  //printout:AAABBB;
	}
}
```
#### 10.
```
class X
{
	int i = 101010;

	public X()
	{
		i = i++ + i-- - i;
	}

	static int staticMethod(int i)
	{
		return --i;
	}
}

class Y extends X
{
	public Y()
	{
		System.out.println(staticMethod(i));    //printout: 101009
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Y y = new Y();
	}
}
```
#### 11.
```
class ClassOne
{
     static int i, j = 191919;          //????:int i ; int j = 191919;
 
     {
        --i;           
     }
 
     {
        j++;           
     }
}
 
public class ClassTwo extends ClassOne
{
    static
    {
        i++;
    }
 
    static
    {
        --j;
    }
 
    public static void main(String[] args)
    {
        System.out.println(i);             //printout: 1;
 
        System.out.println(j);             //printout: 191918;
    }
}
```
#### 12.
```
class A
{
	int[] a = new int[5];

	{
		a[0] = 10;
	}
}

public class MainClass extends A
{
	{
		a = new int[5];
	}

	{
		System.out.println(a[0]);
	}

	public static void main(String[] args)
	{
		MainClass main = new MainClass();           //printout: 0;
	}
}
```
#### 13.
```
class A
{
	static int i;

	static
	{
		i++;
	}

	{
		++i;
	}
}

class B extends A
{
	static
	{
		--i;
	}

	{
		i--;
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		System.out.println(new B().i);          //printout: 0;
	}
}
```
#### 14.
```
public class MainClass
{
	public MainClass(int i, int j)
	{
		System.out.println(method(i, j));
	}
	
	int method(int i, int j)
	{
		return i++ + ++j;
	}
	
	public static void main(String[] args) 
	{
		MainClass main = new MainClass(10, 20);            //printout:  31;
	}
}
```
#### 15.
```
class X
{
	static
	{
		Y.methodOfY();
	}
}

class Y extends X
{
	static void methodOfY()
	{
		System.out.println("Hi....");
	}                                                   //编译错误（？？？？）
                                                        //printout:Hi...;Hi...;
}

public class MainClass
{
	public static void main(String[] args)
	{
		Y.methodOfY();
	}
}
```
#### 16.
```
class ClassOne
{
	static int i = 111;
	
	int j = 222;
	
	{
		i = i++ - ++j;
	}
}

class ClassTwo extends ClassOne
{
	{
		j = i-- + --j;                  //printout: 110;
	}
}
```
