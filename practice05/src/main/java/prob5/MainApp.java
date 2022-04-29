package prob5;

public class MainApp {

	public static void main(String[] args) {
		try {
			MyStack stack = new MyStack(3);
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");
			
			while (stack.isEmpty() == false) { //top 0일떄 -1 내려가는거 처리 
				String s = stack.pop();
				System.out.println( s );
			}

			System.out.println("======================================");

			stack = new MyStack(3);
			stack.push("Hello");

			System.out.println(stack.pop()); // -1상태에서 pop 들어오면 exception을 내라.. 
			System.out.println(stack.pop());
			
		} catch (MyStackException ex) { // exception 처리 
			System.out.println(ex);
		}

	}

}
