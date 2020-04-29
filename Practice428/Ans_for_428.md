### 以下程序的输出结果是
要加上注释说明程序运行结果的原因。题目先自己想答案，然后运行代码查看结果和自己想的是否一致，然后记录注释
#### 例. 
```
class A 
{ 
	public A(String s) 
	{ 
		System.out.print("A"); 
	} 
} 

public class B extends A 
{ 
    // 编译报错，因为类A中没有无参构造方法，子类构造方法中没有显式调用父类的构造方法
	public B(String s) 
	{ 
		System.out.print("B"); 
	} 
	public static void main(String[] args) 
	{ 
		new B("C"); 
		System.out.println(" "); 
	} 
} 
```

#### 1. 

```
class Base {
    public void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public void show() {
       System.out.println("Derived::show() called");
    }
}
  
public class Main {
    public static void main(String[] args) {
        Base b = new Derived();;
        b.show();       //覆盖，方法show为"Derived::show() called"
    }
}
```

#### 2.
```
class A
{
    int i = 10;
}
 
class B extends A
{
    int i = 20;
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new B();
 
        System.out.println(a.i);    //i为A类中的属性i，i==10
    }
}
```

#### 3.
```
class A
{
    {
        System.out.println(1);
    }
}
 
class B extends A
{
    {
        System.out.println(2);
    }
}
 
class C extends B
{
    {
        System.out.println(3);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();          //依照从父到子类继承顺序依次为类开辟空间，顺序为ABC,因此语句执行结果为1；2；3
    }
}
```

#### 4.
```
class A
{
    public A()
    {
        System.out.println("Class A Constructor");
    }
}
 
class B extends A
{
    public B()
    {
        System.out.println("Class B Constructor");
    }
}
 
class C extends B
{
    public C()
    {
        System.out.println("Class C Constructor");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C(); //与上一题一样，依照先new父类再new子类，执行结果为"Class A Constructor";"Class    B Constructor"；"Class C Constructor"
    }
}
```

#### 5. 

```
class X
{
    public X(int i)
    {
        System.out.println(1);
    }
}
 
class Y extends X
{
    public Y()
    {
        System.out.println(2);      //printout：1；2；
    }
}
```
#### 6. 
```
public class A
{
    public A()
    {
        System.out.println(1);
 
        super();
 
        System.out.println(2);          //编译错误，对super的调用应该是第一条语句
    }
}
```
#### 7. 
```
public class A
{
    public A(int i)
    {
 
    }
}
 
class B extends A           //// 编译报错，因为类A中没有无参构造方法，子类构造方法中没有显式调用父类的构造方法
{
 
}           
```
#### 8. 
```
public class A
{
    public A()
    {
        super();
 
        this(10);       //this需要放在第一条语句。与super冲突
    }
 
    public A(int i)
    {
        System.out.println(i);
    }
}
```

#### 9. 

```
class M
{
    int i;          
 
    public M(int i)
    {
        this.i = i--;           //3, i =27,this.i = 26;
    }
}
 
class N extends M
{
    public N(int i)             //1.　int i = 26;
    {
        super(++i);             //2. M(27)
 
        System.out.println(i);  //4. i = 27;printf;
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N(26);
    }
}
```
#### 10. 
```
class M
{
    int i = 51;
 
    public M(int j)
    {
        System.out.println(i);                  //1.printout 51
        this.i = j * 10;                        //2. i =260
    }
}
 
class N extends M
{
    public N(int j)
    {
        super(j);
 
        System.out.println(i);                  // 3. printout 260
 
        this.i = j * 20;                        //4. i =520
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N(26);
 
        System.out.println(n.i);                //5. printout 520
    }                                           //最终输出结果为 51；260；520；
}
```
#### 11. 
```
class X
{
    private int m = 48;                            
}
 
class Y extends X
{
    void methodOfY()
    {
        System.out.println(m);              //无法输出，因为private类型只能被自身类中读取，无法被子类使用
    }                                       //package只能被同包调用
                                            //protected 只能被子类调用或者被同包使用
}
```
#### 12. 
```
class X
{
    int m = 1111;
 
    {
        m = m++;
 
        System.out.println(m);
    }
}
 
class Y extends X
{
    {
        System.out.println(methodOfY());
    }
 
    int methodOfY()
    {
        return m-- + --m;
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        Y y = new Y();
    }                       //printout：1111（？？？）；2220；
}
```

#### 13. 
```
class A
{
	void A()
	{
		System.out.println(1);
	}
}

class B extends A
{
	void B()
	{
		A();
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		new B().B();            //printout：1；
	}
}
```
#### 14. 
```
class A
{
	int i = 1212;
}

class B extends A
{
	A a;

	public B(A a)
	{
		this.a = a;
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		A a = new A();

		B b = new B(a);

		System.out.println(a.i);            //printout：1212

		System.out.println(b.i);            //printout： 1212

		System.out.println(b.a.i);          //printout：1212

		b.a.i = 2121;

		System.out.println("--------");

		System.out.println(a.i);            //printout：1212（？？？） // printout：2121

		System.out.println(b.i);            //printout：1212
	}
}
```

#### 15. 

```
class A
{
	int methodOfA(int i)
	{
		i /= 10;

		return i;
	}
}

class B extends A
{
	int methodOfB(int i)
	{
		i *= 20;

		return methodOfA(i);
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		B b = new B();

		System.out.println(b.methodOfB(100));       //printout：200
	}
}
```

#### 16. 
```
class One
{
	int x = 2121;
}

class Two
{
	int x = 1212;
	
	{
		System.out.println(x);
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Two two = new Two();            //printout：1212；
	}
}
```
## 第二次练习

#### 1.
```
class Clidder  
{ 
    private final void flipper()  
    { 
        System.out.println("Clidder"); 
    } 
} 
  
public class Clidlet extends Clidder  //final不能被继承，编译错误
{ 
    public final void flipper()  
    { 
        System.out.println("Clidlet"); 
    } 
    public static void main(String[] args)  
    { 
        new Clidlet().flipper(); 
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
        s += "sub ";                    //private不会继承给子类
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
        System.out.println(s);  //printout：alpha subsub
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
        super.super.Print();        //super.super会语法错误
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
