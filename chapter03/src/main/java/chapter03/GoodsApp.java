package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		
		goods.setName("nikon");
		goods.setPrice(400000);
		goods.setCountSold(50);
		goods.setCountStock(30);
		
		goods.showInfo();
		
		
		Goods goods2 = new Goods("tv",10000,10,10);
		goods2.showInfo();
		
		Goods goods3 = new Goods();
		
		
		
		System.out.println("Goods Count :" + Goods.countOfGoods);
		
		//discount price 구하기 
		goods.setPrice(2000);
		int discountPrice = goods.calcDiscountPrice(0.5);
		System.out.println("Goods Discount Price: " + discountPrice);
	}

}
