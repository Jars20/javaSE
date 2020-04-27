class Rand{
	public static int randomInt(int from, int to){
        int n=from+(int)(Math.random()*(to-from+1));
        return n;
	}
	public static void main(String[] args) {
		System.out.println(Rand.randomInt(-10,5));
	}
}