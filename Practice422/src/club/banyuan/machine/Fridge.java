package club.banyuan.machine;
import club.banyuan.animal.Elephant;
import club.banyuan.animal.Lion;

public class Fridge {

    public int heightInCM;
    public Elephant store;
    public Lion store2;									//Elephant为一个类，store为一个对象
    


    public void store(Elephant elephant) {					// method 方法
        if(store==null&&store2==null){
        	store = elephant;
        }
    }

    public static boolean isempty(Elephant store,Lion store2){
     	if(store==null&&store2==null){
        	return true;
        }
        System.out.println("冰箱已经装满了！");
		return false;
     }
    	
    

    public void store(Lion lion,boolean isempty) {  //重载时，顺序、入参、数量必须有一个不一样
    	if(isempty == true){			// method 方法
        	store2 = lion;
    	}
    }
    


    public Elephant remove(Elephant store){
    	if(store!=null){
    		System.out.println(store.heightInCM);
    		return null;
    	}
    	return null;
    }


}

