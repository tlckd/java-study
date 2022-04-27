package chapter03;

import java.util.Arrays;

public class ArrayUtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[] a1 = {10,20,30,40};
		

		double[] d1 = ArrayUtil.intToDouble(new int[]{10,20,30,40});
		
		/*
		for(double d : d1) {
			System.out.print(d +" ");
		}*/
		
		//System.out.println(Arrays.toString(d1));
		
		int [] a1 = ArrayUtil.doubleToInt(new Double[]{10.1,20.2,30.3,40.4});
		int [] a2 = ArrayUtil.concat(new int[] {1,2,3}, new int[] {4,5,6});
		
		for(double d : d1) {
			System.out.print(d +" ");
		}
		System.out.println("");
		
		for(double d : a1) {
			System.out.print(d +" ");
		}
		System.out.println("");
		
		
		 for(double d : a2) { 
			 System.out.print(d +" "); 
		}
		 
		//이거 2개 구현하는게 과제 + 연습문제 3번
	}

}
