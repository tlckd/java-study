package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		
		
		try {
			//기반스트림
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");
			
			//보조스트림
			br = new BufferedReader(fr);
			
			String line=null;
			int index=0;
			
				while((line=br.readLine()) !=null) {
					System.out.print(index);
					System.out.print(":");
					System.out.println(line);
					System.out.println("\n");
					index++;
				}

			
		} catch (Exception e) {
			System.out.println("Can't Open:" + e);
		}finally {
			try {
				if(br!=null) { // br null이될 위험이 있기때문 
				br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

}
