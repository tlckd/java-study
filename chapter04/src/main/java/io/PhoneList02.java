package io;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class PhoneList02 {
	public static void main(String[] args) {
		Scanner scanner = null;
		
		try {
		
		File file = new File("phone.txt");
		
		if(!file.exists()) {
			System.out.println("file not found");
			return;
		}
		
		System.out.println("========파일정보=======");
		
		System.out.println(file.getAbsolutePath()); //전체경로 
		System.out.println(file.length() + "bytes");//파일의 길이 
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified()))); //타임스탬프로 나옴 
		
		System.out.println("========전화번호=======");
		scanner = new Scanner(file); // 파일넣어줌 
		
		while(scanner.hasNextLine()) {
			String name =scanner.next();
			String phone1 = scanner.next();
			String phone2 = scanner.next();
			String phone3 = scanner.next();
			
			System.out.println(name +":" + phone1 + "-" + phone2 + "-" + phone3  );
		}
		
	}catch(FileNotFoundException e) {
		System.out.println("error: " + e);
	}finally {
		scanner.close();
	}
		
	}

}
