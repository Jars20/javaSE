class MathOperation{


	public static void main(String[] args) {
		float a = 2.4E9F;
		int b = 0;
		b = (int)a;

		System.out.println(a);
		System.out.println(b);//输出为2147483647，为int的最大表示范围21亿





		boolean c = false;
		int d = 1;
		int e = 2;
		int f = -3;
		System.out.println("c d e f");
		System.out.printf(" "+c+"%d"+"%d"+"%d\n",d,e,f);
		c =( d++>0 || e++>0 || f++<0 );
		System.out.printf(" "+c+"%d"+"%d"+"%d\n",d,e,f);//f值未变，短路



		int i=1;
		int j=0;
		int k=2;
		int l=0;
		int m=0;
		l=i|j|k;
		m=(i|j)|k;
		System.out.println(l);
		System.out.println(m);//m=l,不会短路



	}
}