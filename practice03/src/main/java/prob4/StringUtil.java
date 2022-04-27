package prob4;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		// TODO Auto-generated method stub
		String concatStr = "";
		for(String a : strArr) {
			concatStr = concatStr +" "+a;
			
		}
		return concatStr;
	}
}
