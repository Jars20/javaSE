public class GetFortune{
	static public int getRandom(){
		int i = (int)((Math.random())*99);
		return i;
	}
	public static void main(String[] args) {
		String a = new String() ;
		int i = getRandom();
		if(i<4&&i>=0){
			a = "大吉";
		}
		else if(i<15&&i>=5){
			a = "中吉";
		}
		else if(i<30&&i>=15){
			a = "小吉";
		}
		else if(i<60&&i>=30){
			a = "吉";
		}
		else if(i<80&&i>=60){
			a = "末吉";
		}
		else if(i<95&&i>=80){
			a = "凶";
		}
		else if(i<100&&i>=95){
			a = "大凶";
		}
		System.out.println(a);
	}
}