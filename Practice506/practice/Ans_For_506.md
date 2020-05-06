### 以下程序的输出结果是
#### 1.
```
class Base {
    final public void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public void show() {
       System.out.println("Derived::show() called");
    }
}
  
class Main {
    public static void main(String[] args) {
        Base b = new Derived();;
        b.show();
    }
}
```
>编译错误， 父类final无法重写
#### 2.
```
class Base {
    public static void show() {
       System.out.println("Base::show() called");
    }
}
  
class Derived extends Base {
    public static void show() {
       System.out.println("Derived::show() called");
    }
}
  
class Main {
    public static void main(String[] args) {
        Base b = new Derived();
        b.show();
    }
}
```
>printout:"Base::show() called"

#### 3.
```
class Base {
    public void Print() {
        System.out.println("Base");
    }         
}
 
class Derived extends Base {    
    public void Print() {
        System.out.println("Derived");
    }
}
 
class Main{
    public static void DoPrint( Base o ) {
        o.Print();   
    }
    public static void main(String[] args) {
        Base x = new Base();
        Base y = new Derived();
        Derived z = new Derived();
        DoPrint(x);
        DoPrint(y);
        DoPrint(z);
    }
}
```
>printout:Base;Derived(???);Derived;

#### 4.

```
class Base {
    public void foo() { System.out.println("Base"); }
}
  
class Derived extends Base {
    private void foo() { System.out.println("Derived"); } 
}
  
public class Main {
    public static void main(String args[]) {
        Base b = new Derived();
        b.foo();
    }
} 
```
>public ->private非法，编译报错

#### 5.
```

public class NewClass { 
	public static class superclass { 
		static void print() 
		{ 
			System.out.println("print in superclass."); 
		} 
	} 
	public static class subclass extends superclass { 
		static void print() 
		{ 
			System.out.println("print in subclass."); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		superclass A = new superclass(); 
		superclass B = new subclass(); 
		A.print(); 
		B.print(); 
	} 
}  编译报错，class包含class
```
>
#### 6.
```

public class NewClass { 
	public static class superclass { 
		void print() 
		{ 
			System.out.println("print in superclass."); 
		} 
	} 

	public static class subclass extends superclass { 
		@Override
		void print() 
		{ 
			System.out.println("print in subclass."); 
		} 
	} 

	public static void main(String[] args) 
	{ 
		superclass A = new superclass(); 
		superclass B = new subclass(); 
		A.print(); 
		B.print(); 
	} 
} 
```
>编译报错，class包含class

#### 7.
```
class ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassOne");
    } 
} 
class ClassTwo extends ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassTwo");
    } 
} 
  
public class Test 
{ 
    public static void main(String[] args) 
    { 
        ClassOne obj = new ClassTwo();
        obj.getData(); 
    } 
} 
```
>protected可以被重写。除了final、private、static无法被重写，其他被重写的均调用子类的属性或者方法
>printout:Inside ClassTwo;

#### 8.
```
class Test 
{ 
    void myMethod() 
    { 
        System.out.println("Test");
    } 
} 
class Derived extends Test
{ 
    void myMethod() 
    { 
        System.out.println("Derived");
    } 
      
    public static void main(String[] args) 
    { 
        Derived object = new Test(); 
        object.myMethod(); 
    } 
} 
```
>在子类自身调用子类时，显示不兼容的类型，Test无法转化为Derived

#### 9.
```
class ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassOne");
    } 
} 
class ClassTwo extends ClassOne
{ 
    protected void getData() 
    { 
        System.out.println("Inside ClassTwo");
    } 
      
    protected void getValue() 
    { 
        System.out.println("ClassTwo");
    } 
} 
  
public class Test 
{ 
    public static void main(String[] args) 
    { 
        ClassOne obj = new ClassTwo();
        obj.getValue(); 
    } 
} 
```
>编译错误。ClassOne中没有子类中的getValue方法。