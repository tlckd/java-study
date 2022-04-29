package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1==s2); 
		System.out.println(s1.equals(s2)); 
		System.out.println(s1.hashCode() + ":" + s2.hashCode());//String에서 오버라이드한거
		System.out.println(System.identityHashCode(s1) + ":" +System.identityHashCode(s2));//원래 오브젝트 해시코드 주소기반 해시값 
		
		System.out.println("==============================");
		
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3==s4); 
		System.out.println(s3.equals(s4)); 
		System.out.println(s3.hashCode() + ":" + s4.hashCode());//String에서 오버라이드한거
		System.out.println(System.identityHashCode(s3) + ":" +System.identityHashCode(s4));//원래 오브젝트 해시코드 주소기반 해시값 
		
		
	}

}
