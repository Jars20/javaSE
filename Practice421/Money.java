class Money{
	public static void main(String[] args) {
		int x ;
		int y ;
		int count=0;
		for (x=1;x<100;x++){
			for (y=1;y<50;y++){
				    int z=(100-x-y);
					if (x+2*y+5*z==150&&z>0){
						System.out.printf("%d,%d,%d\n",x,y,z);
						count++;
					}
			}
		}
		System.out.printf("共有%d种不同的方法\n",count);
	}
}

