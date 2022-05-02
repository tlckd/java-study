package chapter04;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date(); // Date 생성되면서 현재 시간이 들어감, 특정시간 지정도 가능 
		System.out.println(now); 
		
		printDate01(now); 
		printDate02(now);
		
		
	}

	private static void printDate02(Date d) {
		//개별적으로 값들을 구해냄 년,월,일, 시간 같은거 따로 구해서 String을 만듬, 값을 뽑아보자 
		// 년도(+ 1900) 
		int year = d.getYear(); 
		
		// 월(0~11, +1) 0부터 시작해서 +1 해줘야함.. 
		int month =  d.getMonth();
		
		// 일
		int date = d.getDate();
		
		// 시 
		int hours = d.getHours();
		
		// 분 
		int minutes = d.getMinutes(); 
		
		// 초 
		int seconds = d.getSeconds();
		
		System.out.println(
			(year+1900) + "-" +
			(month+1) + "-" + 
			date + ":" + hours + ":" + minutes + ":" + seconds	
		);
		
		
	}

	public static void printDate01(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //데이터 포멧스트링으로 포맷객체 생성 
		String date = sdf.format(d); 
		
		System.out.println(date);
	}
	
}
