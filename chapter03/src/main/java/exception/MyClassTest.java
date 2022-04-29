package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass myClass =new MyClass();
		
		try {
			myClass.danger();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.println("error" + e );
			e.printStackTrace();
		}

	}

}
