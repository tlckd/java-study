package prob05;

public class MyBase extends Base {// mybase만 건들여서 문제풀기 

	public void service(String state){
		
		if("오후".equals(state)) {
			noon();
			return;
		}
		super.service(state);
		
//		if( state.equals( "낮" ) ) {
//			day();
//		} else if (state.equals( "밤" )) {
//			night();
//		}else {
//			noon();
//		}
	}
	
	public void day(){
		System.out.println("낮에는 열심히 일하자!");
	}
	
	public void night(){
		System.out.println("night");
	}
	
	public void noon() {
		System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
	}
	
	
}
