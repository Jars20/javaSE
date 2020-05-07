//类与对象的关系
// 抽象来说：类与对象的关系就如模具和铸件的关系，类的实例化的结果就是对象，而对对象的抽象就是类，类描述了一组有相同特性（属性）和相同行为的对象。

// 具体在Java编程中，类通过使用关键字class完成。
//class 类名称 {
//          属性 (变量) ;
//          行为 (方法) ;
// 			}
//对象通过实例化类完成，有以下两种方式：
//格式一：声明并实例化对象
// 类名称 对象名称 = new 类名称 () ;

//格式二：先声明对象，然后实例化对象
// 类名称 对象名称 = null ;
// 对象名称 = new 类名称 () ;

package club.banyuan.main;
import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;
import club.banyuan.machine.Fridge;

public class Main{

	public static Lion createLion(int heightInCM){
		Lion l = new Lion();
		l.heightInCM = heightInCM;
		return l;
	}


	public static void main(String[] args) {
		Elephant elephant = new Elephant();
		elephant.heightInCM = 300;
	
		Lion lion = createLion(400);
		
		Fridge fridge = new Fridge();
		fridge.heightInCM = 500;

		fridge.store(elephant);
		fridge.store(lion,Fridge.isempty(fridge.store,fridge.store2));		

		System.out.println(fridge.store.heightInCM);
		fridge.store=fridge.remove(fridge.store);

	}
}
