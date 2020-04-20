class Practice{
	public static void main(String[] args) {
		int t_7 = 0;
		long t_30 = 0;

		double b = 0.1;
		// int a = b;

		int[] array = new int [100];
		int c = array.length; //可行，所以是int型
		// array.length = 200;无法改变，为final


		System.out.println(t_30);
		System.out.println(t_7);
		// System.out.println(a); error，但b可执行输出，因此0.1不是整形，为浮点型
		System.out.println(b);
		System.out.println(c);
		System.out.println(array.length);


		String [][] twodimen = {{"你","我","他"},{"金","木","水","火","土"},{"天","地"}};
		System.out.println(twodimen[0][0]+twodimen[0][1]+twodimen[0][2]+"\n"+twodimen[1][0]+twodimen[1][1]+twodimen[1][2]+twodimen[1][3]+twodimen[1][4]+"\n"+twodimen[2][0]+twodimen[2][1]);








				
			}		


}		
		