package tv;

public class TV {
	//중복되지 않게 구현
	private int channe;  //0~255 rotation
	private int volume;  //0~100 rotation
	private boolean power;  
	
	
	public TV() {
		
	}
	
	public void status() {
		// TODO Auto-generated method stub
		System.out.println("TV[channe="+7+", volume="+ volume + ", power= " + (power ? "on" : "off" ) + "]" );
		 
	}
	
	public void volum(boolean up) {
		volum(volume + (up?1 :-1));
		
	}
	public void volum(int volum) {
		this.volume = volume;
	}
	
	
	
}
