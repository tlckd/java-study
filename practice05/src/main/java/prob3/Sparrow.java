package prob3;

public class Sparrow extends Bird {

	private String name;
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("참새("+name+")가 날라다닙니다.");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("참새("+name+")가 소리내어 웁니다.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String toname= "참새의 이름은 " + name + " 입니다."; 
		return toname ;
	}
	
	
	
}
