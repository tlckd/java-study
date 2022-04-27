package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		System.out.println("상품을 3개 입력하세요..");
		// 상품 입력
		for(int i=0; i< COUNT_GOODS;i++){
			String line = scanner.nextLine();
			//System.out.println(line);
			String[] datas =line.split(" ");
			
			goods[i]=new Goods(datas[0], Integer.parseInt(datas[1]), Integer.parseInt(datas[2]));
			
			
//			String name = datas[0];
//			int price = Integer.parseInt(datas[1]);
//			int count = Integer.parseInt(datas[2]);
//			
		
		}
		
		// 상품 출
		for(int i=0; i<COUNT_GOODS;i++) {
			goods[i].showGoods();
		}
		// 자원정리
		scanner.close();
	}
}
