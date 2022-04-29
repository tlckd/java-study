package prob5;

public class MyStack {
	private int top=-1;
	private String[] buffer;
	
	public MyStack(int size) {
		buffer = new String[size];
	}
	
	public void push(String item) {
		
		if(top<buffer.length-1) {
		buffer[top] =item;
		top++;
		}else {
			
			buffer = new String[buffer.length*2];
			
		}
	}
	
	public String pop() throws MyStackException{
		return null;
		
	}
	
	public boolean isEmpty() {
		return false;
	}
	
}