class Fraction{
	static int a,b;				//a表示分子，b表示分母
	double fra = 0.0;			
	double toDouble(){
		fra = (float) a / b;
		return fra;
	}
	static int find_greatest_common_factor(int a,int b){
		int max;
		max=(a<b?a:b);
		for (int i =max;i>0;i--){
			if (a%i==0&&b%i==0){
				return i;
			}
		}
		return max;

	}
	Fraction plus(Fraction r){		
		int tempb = b * r.b;				
		int tempa = a * r.b + b * r.a;
		int f = find_greatest_common_factor(tempa,tempb);
		int newa = tempa/f;
		int newb = tempb/f;						//newa为新分数的分子，newb为新分母
		Fraction newr = new Fraction();
		newr.a = newa;
		newr.b = newb;
		return newr;
	}
	Fraction multiply(Fraction r){
		int tempb = b * r.b;
		int tempa = a * r.a;
		int f = find_greatest_common_factor(tempa,tempb);
		int newa = tempa/f;
		int newb = tempb/f;						//newa为新分数的分子，newb为新分母
		Fraction newr = new Fraction();
		newr.a = newa;
		newr.b = newb;
		return newr;
	}
	static void print(){
		int finala = a /find_greatest_common_factor(a,b);
		int finalb = b /find_greatest_common_factor(a,b);
		if (finala==1&&finalb==1) {
			System.out.println(1);
		}
		else
			System.out.printf("%d / %d\n",finala,finalb);

	}
	public static void main(String[] args) {
		// Fraction newfra1 = new Fraction();
		// newfra1.a = 2;
		// newfra1.b = 3;
		// Fraction newfra2 = new Fraction();
		// newfra2.a = 2;
		// newfra2.b = 3;
		// newfra1.plus(newfra2);
		// print();
		// newfra1.multiply(newfra2);
		// print();
	}
}