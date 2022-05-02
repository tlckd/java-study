package chapter04;

public class MyClass {
	
	private static MyClass instance = null; // 애를 관리 하면 된다
	
	private MyClass() { //private로 생성자 만들어서 객체 못생성하게 만듬
		
	}

	public static MyClass getInstance() { //외부에서는 new안되고 이 메소드로만 객체를 얻을수있게! 
		if(instance==null) { //스프링은 컨테이너에서 관리함 컨테이너가 싱글톤 유지시켜줌 
			instance=new MyClass();
		}
		
		return instance;
	}
}
