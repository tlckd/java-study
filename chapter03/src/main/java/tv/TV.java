package tv;

public class TV {
	//중복되지 않게 구현
	private int channe;  //0~255 rotation
	private int volume;  //0~100 rotation
	private boolean power;  
	
	public TV() {
		this(7,20,false);

	}
	public TV(int channe, int volume, boolean power) {
		this.channe=channe;
		this.volume=volume;
		this.power=power;
	}
	
	public void status() {
		// TODO Auto-generated method stub
		System.out.println("TV[channe="+channe+", volume="+ volume + ", power= " + (power ? "on" : "off" ) + "]" );
		 
	}
	
	public void volume(boolean up) {
		volume(volume + (up?1 :-1));		
	}
	
	public void volume(int volume) {		
		if(volume>100) {
			this.volume=volume%100;
		}else if(volume<0) {
			this.volume=100;
		}else{
		this.volume = volume;
		}
		
	}

	
	public void power(boolean on) {
		this.power=on;		
	}

	
	public void channel(boolean up) {
		channel(channe + (up?1 :-1));
	}
	
	public void channel(int channe) {
		if(channe>255) {
			this.channe=0;
		}else if(channe<0) {
			this.channe=100;
		}else{
		this.channe = channe;
		}
	}
	
	

	
	
	
	
}
