package chapter03;

import java.util.ArrayList;

public class ArrayUtil {

	public static double[] intToDouble(int[] a) {
		// TODO Auto-generated method stub
		double[] result = new double[a.length];
		
		for(int i=0; i< a.length; i++) {
			result[i]=a[i];
		}
		return result;
		
	}

	public static int[] doubleToInt(Double[] ds) {
		// TODO Auto-generated method stub
		
		int[] result = new int[ds.length];
		
		for(int i=0; i< ds.length; i++) {
			result[i]=ds[i].intValue();
		}
		
		return result;
	}

	public static int[] concat(int[] is1, int[] is2) {
		// TODO Auto-generated method stub
		int[] result = new int[is1.length + is2.length];
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		

		for(int a : is1) {
			list.add(a);
		}
		for(int a : is2) {
			list.add(a);
		}
		
		for(int i=0; i< list.size();i++) {
			result[i]=list.get(i);
		}
		
		return result;
	}

}
