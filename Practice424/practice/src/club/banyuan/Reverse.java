class Reverse{

  	private static String reverseString(String str) {
    char[] chars = str.toCharArray();
    char[] reversedChars = new char[chars.length];
    for (int i = 0; i < chars.length; i++) {
      	reversedChars[chars.length - 1 - i] = chars[i];
    }
    	return new String(reversedChars);
  	}

	// static String reverse(String a ){
	// 	int i = 0;
	// 	while(i<a.length()){
	// 		int j = i;
	// 		while(a.charAt(j) != ' '   ){
	// 			j++;
	// 		}
	// 		for(int l = i;l<(i+j-1)/2;l++){
	// 			// str = str.substring(0, count) + str.charAt(i) + str.substring(count+1);
	// 			char temp = a.charAt(l);
	// 			a.charAt(l) = a.charAt(j-1-l);
	// 			a.charAt(j-1-l) = a.charAt(l); 
	// 		}
	// 		i++;
	// 	}
	// 	return a;
	// }

	public static void main(String[] args) {
	 	StringBuffer stringBuffer = new StringBuffer();
    	String target = "To be or not to be";//初始化String的方法1
    	String[] words = target.split(" ");
    	for (int i = 0; i < words.length; i++) {
      		stringBuffer.append(reverseString(words[i]));
      		stringBuffer.append(" ");
    	}
    	System.out.println(stringBuffer.toString());
  	}
	// 	String a = new String("To be or not to be"); //初始化String的方法2
	// 	String b = new String();
	// 	b = reverse(a);
	// 	System.out.println(a); 
	// }
}