/* 测试对象属性的改变
*/
class num{
	int i;
}


class Test1{
	int i = 1;
	void add(int a){
		i++;
		System.out.printf("1:%d\n",i);
	}
	void exe(){
		System.out.printf("2:%d\n",i);
	}
}
class Main{
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.add(t.i);
		t.exe();
		System.out.printf("3:%d\n",t.i);
	}
	
}