package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s1 = "123456";
		int i = Integer.parseInt(s1); 
		
		//cf1 반대로 
		String s2 =  String.valueOf(i);
		
		//cf2 반대로 
		String s3 = ""+i; 
		
		System.out.println(s1 + ":" + s2 + ":" + s3);
		
		char c = 'A';
		int a =Character.getNumericValue(c); //16진수 
		System.out.println(a);
		
		//2 진수 
		String s4 = Integer.toBinaryString(15); //15의 2진수 출력 
		System.out.println(s4);
		
		//16진수 
		String s5 = Integer.toHexString(15); //15의 16진수 출력 
		System.out.println(s5);
		
		
	}

}
