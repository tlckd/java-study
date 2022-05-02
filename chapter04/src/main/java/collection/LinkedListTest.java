package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();//이부분만 링크드 리스트로 
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		//순회1 
		for(int i=0;i<list.size();i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		//삭제 
		list.remove(2);
		
		
		System.out.println("---------------------------");
		
		//순회2 한번 돌고나면 다시 못씀
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("---------------------------");
		
		
		//순회3 
		for(String s : list) {
			System.out.println(s);
		}
		
	}

}
