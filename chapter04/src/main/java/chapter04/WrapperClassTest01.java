package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = new Integer(10); //deprecated 조만간 없앨거니깐 이렇게 쓰지말라는 의미
		Character c = new Character('c'); // 
		Boolean b = new Boolean(true); // 바로 생성하는거 추천안함, 그냥 값쓰듯이 쓰는게 더 좋다고함 
		
		// Auto Boxing 기본타입 쓰듯이 쓰면된다 
		Integer j1 = 10;
		Integer j2 = 10;
		
		//이것도 오토박싱 
		System.out.println(j1==j2);
		System.out.println(j1.equals(j2));
		
		//오토언박싱 Auto Unboxing
		//int m = j1 + 10;
		int m = j1.intValue() + 10;
		
		
	}

}
