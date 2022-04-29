package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args){
		FileInputStream fis=null; 
		try {
		fis =new FileInputStream("hello.txt"); //FileInputStream 바이트 단위로 읽음 
		int data = fis.read(); // 한바이트 읽음 
		System.out.println((char)data);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("error:  " + e);
			e.printStackTrace();
		} // 기본적으로 같은 폴더 기준으로 찾음 
		catch(IOException e) {
			System.out.println("error: " + e);
		}finally { // 자원종료 
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
