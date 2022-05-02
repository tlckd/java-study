package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		Map<String,Integer> m = new HashMap<>();
		
		String k1 ="one";
		
		m.put(k1,1); // auto boxing
		m.put("two",2);
		m.put("three",3);
		
		int i = m.get("one"); //auto unboxing 
		int j = m.get(new String("one")); 
		
		System.out.println(i + ":" + j);
		
		m.put("three", 33333); 
		m.get("three"); 
	
		//순회
		Set<String> s = m.keySet(); 
		for(String key : s) {
			System.out.println(m.get(key));
		}
		
	}

}
