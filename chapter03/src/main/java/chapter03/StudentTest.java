package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		//자식의 모든 생성자에서 
		// 부모의 특정 생성자를 명시(explicity)하지 않으면 
		// 암시적(implicity)으로 부모의 기본 생성자가 
		//자식 생성자 코드 앞에 호출된다.
		// super();
		
		Student s1 = new Student();
		s1.setGrade(1);
		
		Person p1 =s1; // upcasting(암시적) 자식을 부모로 캐스팅 (Person)s1 이렇게 안빠꿔줘도 된다는 의미 
		p1.setName("둘리");
		
		Student s2 = (Student)p1; // 부모에서 자식으로 downcasting(명시적으로 해줘야함, Explicity)
		s2.setMajor("cs");
		
	}

}
