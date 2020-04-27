class StringBuffer{

	static String s = " ";
	/*
    接收字符串
	*/
	void append(String str){
		s = s + str;
	}
	/*
    接收字符
	*/
	void append(Char str){
		s = s + str;
	}
	/*
	将之前接收到的字符拼接到一起返回
	*/
	String toString(){
		return s;
	}
	/*
	清除之前的而输入内容
	*/
	void clear(){
		s = " ";
	}
	/*
	将之前的输入内容反转
	*/
	String reverse(){
		int length = s.length;
		String ns = new String(length);
		for(int i = 0 ;i < length-1; i++){
			ns += s.charAt(length - 1 - i);
		} 
		return ns; 
	}
	/*
	将指定位置的字符串反转
	from 从0起始
	to 不包含在内
	即[from,to)
	例如 abcdefg => reverse(1,3) => acbdefg
	*/
	String reverse(int from, int to){
		int len = to - from;
		String ts = new String(len);
		for(int i = from ;i < to ;i++){
			ts += s.charAt(i); 
		}
		return s.substring(0,from) + ts + s.substring(to);

	}
}