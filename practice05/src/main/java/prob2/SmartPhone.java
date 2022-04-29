package prob2;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		
		if("음악".equals(function)) {
			playMusic();
			return;
		}
		if("앱".equals(function)) {
			playApp();
			return;
		}
		
		super.execute(function); //음악아니면 부모에게..
	}

	@Override
	protected void playMusic() {
		// TODO Auto-generated method stub
		System.out.println("다운로드해서 음악재생");;
	}
	
	protected void playApp() {
		System.out.println("앱실행");
	}

}
