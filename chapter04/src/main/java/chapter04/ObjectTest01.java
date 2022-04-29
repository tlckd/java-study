package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p = new Point(10, 10);
		
		//Class klass = p.getClass();
		
		System.out.println(p.getClass().getName()); //reflection, getClass는 오브젝트에 있다.
		System.out.println(p.hashCode()); // address 기반의 해싱값 
										  // address x , reference x 
	
		System.out.println(p.toString()); // getClass 한번 부른후 @ 친후 hashCode()를 더함   getClass + @ + hashCode
		System.out.println(p);
	
		
		
	}

}
