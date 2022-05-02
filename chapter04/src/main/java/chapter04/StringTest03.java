package chapter04;

public class StringTest03 {
	public static void main(String[] args) {
		//String method 들..
		String s1 = "aBcABCabcAbc";
		System.out.println(s1.length());
		System.out.println(s1.charAt(2)); 
		System.out.println(s1.indexOf("abc")); 
		System.out.println(s1.indexOf("abc",7));//abc를 7번째부터 검색 
		System.out.println(s1.substring(3)); //3번째에서 끊음 
		System.out.println(s1.substring(3,5)); // 마지막번째꺼 5-1 4번째 인덱스 까지 ㅇㅇ 
		
		String s2 = " ab cd ";
		String s3 = " efg,hij,klm,nop,qrs";
		
		String s4 = s2.concat(s3); // 연결 
		System.out.println(s4);
		
		//trim 
		System.out.println("---" + s2.trim() +"---");
		System.out.println("---" + s2.replaceAll(" ", "") +"---"); //다없앨려면 replaceAll
		
		//스플릿 구분자로 짤라서 배열로 만들어줌  
		String[] tokens = s3.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		
		//해당하는 분리자가 없으면 그냥 통쨰로 한칸에 넣음 스플릿은 null 리턴안함
		String[] tokens2 = s3.split(" ");
		for(String s : tokens2) {
			System.out.println(s);
		}
		
		// +:  String concat(연결) 연산자
		//String s5 = "Hello" + "World" + "Java" + "1.8"; 


		String s5 = new StringBuffer("Hello").append("World").append("Java").append(1.8).toString();
		
		System.out.println(s5);
		
		
		String s6 = "";
		for(int i=0; i<100000;i++) {
			//s6 = s6 + i; 
			//s6 = new StringBuffer(s6).append(i).toString(); 
			
		}
		
		StringBuffer sb6 = new StringBuffer();
		for(int i=0; i<100000;i++) {
			sb6.append(i);
			
		}
		
		String s7 = sb6.toString();
		System.out.println(s7.length());
		
	}
}
