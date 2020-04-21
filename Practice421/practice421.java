class practice421{
	public static void main(String[] args) {
 		int a=0;
 		int b=5;
		System.out.printf("%d*%d=%d\n",a,b,multiply(a,b));
		long c =3456789;
		convert(c);

	}
	static int multiply(int n1, int n2) {
		if (n1==0 || n2==0){
			return 0;
		}
		int mul=0;
		for(int i=0; i<n2; i++){
			 mul+=n1;
		}
		return mul;
	}



	static void convert(long minute){
		int year,day;
		int min =(int)minute;
		int tday = min/1440;
		day	= tday%365; 
		year = tday/365;
		System.out.printf("%d分钟是%d年%d天\n",min,year,day);
	}
}