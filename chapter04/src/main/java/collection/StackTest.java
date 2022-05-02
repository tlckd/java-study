package collection;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		
		s.push("둘리"); // 삽입 
		s.push("마이콜");
		s.push("도우너");
		
		while(!s.isEmpty()) {
			String str =s.pop(); // 뺴내기 
			System.out.println(str); // 스택이라 들어간 순서의 반대로 나옴 
		}
		
		//비어있는 경우 예외 발생 
		//s.pop();
		//없는거를 pop 하면 에러가 나옴 
		
		s.push("둘리"); // 삽입 
		s.push("마이콜");
		s.push("도우너");
		
		System.out.println(s.pop());
		System.out.println(s.peek()); // 뺴내진 않고 맨위에 뭐가 있는지 확인하는거 피크 
		System.out.println(s.pop());
	
	}

}
