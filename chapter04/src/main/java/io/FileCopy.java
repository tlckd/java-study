package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream("참새.jpg");
			os = new FileOutputStream("참새_copy.jpg");//목적지
			
			int data = -1;
			
			while((data = is.read()) != -1) {
				os.write(data);
			}
			
		}catch(Exception e) {
			System.out.println("file not found" + e);	
		}finally {
			
			try {
				if( is != null) {
					is.close();
				}
				if( os != null) {
					os.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
	}
}
