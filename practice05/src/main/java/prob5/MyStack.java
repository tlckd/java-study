package prob5;

public class MyStack {
	private int top=0;
	private String[] buffer;
	private String[] temp;
	private boolean emptycheck=false;;
	
	public MyStack(int size) {
		buffer = new String[size];
	}
	
	public void push(String item) {
		
		if(top<buffer.length) {
			
		pushitem(item);
		
		}else {
			temp = new String[buffer.length];
			
			for(int i=0;i<temp.length;i++) {;
				temp[i]=buffer[i];
			}
			
			buffer = new String[buffer.length*2];
			
			for(int i=0;i<temp.length;i++) {
				buffer[i]=temp[i];
			}

			pushitem(item);

		}
		
	}
	
	public String pop() throws MyStackException{
		
		if(top==1) {
		emptycheck=true;
		}
		if(top==0) {
		throw new MyStackException();
		}
		
		String s = buffer[top-1];
		top--;
		return s;
	}
		
	
	public boolean isEmpty() {
		
		return emptycheck;
	}
	
	public void pushitem(String item){
		
		buffer[top] =item;
		top++;
		
	}
	
}