package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			
			// 기반 스트림 
			FileOutputStream fos = new FileOutputStream("test.txt");
			
			//보조 스트림 
			bos = new BufferedOutputStream(fos);
			
			
			//for(int i = 'a'; i< '='; i++) 
			for(int i = 97; i< 122; i++) { 
				bos.write(i);
				//bos.flush(); // 버퍼 비우기 
			   }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Can't Open:" +  e );
			} finally {
				// 보조스트림 한개만 닫으면 됨 
				try {
					if(bos != null) {
						bos.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
}
