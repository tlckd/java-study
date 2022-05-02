package chapter04;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance(); // 캘린더는 추상 new 못함 getInstance로 객체 뽑아내야함
		//내가 new를 안하고 객체를 만들어주는 공장 메소드에게 받는거 팩토리 메소드, 팩토리 패턴
		
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 11); //+1 
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(2022, 4, 15); 
		cal.add(Calendar.DATE,100); 
		printDate(cal); //2022 04 15 로부터 100일째 되는날 출력.. 
		
	}

	private static void printDate(Calendar cal) {
		
		final String[] DAYS = {"일","월","화","수","목","금","토"};
		
		final int a = 10; 
	
		
		int year = cal.get(Calendar.YEAR); 
		int month = cal.get(Calendar.MONTH); // 0~11, +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 요일구하기 , 1에서부터 나옴 1~7 1(일)~7(토)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				(year) + "년 " +
				(month+1 < 10 ? "0" : "") +(month+1) + "월 "  +
				(date < 10 ? "0" : "") + date + " 일 "  + DAYS[day-1] + "요일 "+ hour + " 시간 " + minute + " 분 " + second + " 초 "	
			);
			
	}
}
