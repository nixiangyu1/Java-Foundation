/*
      实现商品库存清单案例
	    步骤：
		1.实现表头，是固定数据，直接写输出语句
		2.表格中间，商品数据，采用变量的形式 定义变量，找对数据结构
		   输出所有变量
		3.表格尾巴，一部分是固定数据，另一部分商品数据需要运算
*/
public class Shop{
	public static void main(String args[]){
		//输出表头固定数据
		System.out.println("--------------商品库存清单-----------------");
		System.out.println("品牌型号    尺寸    价格   库存数");
		//定义表格中的数据变量
		//品牌型号，string 尺寸double   价格 double 库存数   int
		String macBrand="MacBookAir";
		double macSize=13.3;
		double macPrice=6988.8;
		int macCount=5;
		
		String thinkBrand="ThinkPadT450";
		double thinkSize=14.0;
		double thinkPrice=5999.9;
		int thinkCount=10;
		
		
		String asusBrand="ASUS-FL5800";
		double asusSize=15.6;
		double asusPrice=4999.5;
		int  asusCount=18;
		
		//对商品信息变量进行打印，变量之间加入一定的字符串空格
	     System.out.println(macBrand+"   "+macSize+"   "+macPrice+"   "+macCount);
	     System.out.println(thinkBrand+" "+thinkSize+"   "+thinkPrice+"   "+thinkCount);
	     System.out.println(asusBrand+"  "+asusSize+"   "+asusPrice+"   "+asusCount);
		
		//计算总库存数，素有商品数求和
		int totalCount=macCount+thinkCount+asusCount;
		//计算所有商品的金额数，每个商品价格*商品数量
		double totalMoney=macCount*macPrice+thinkCount*thinkPrice+asusPrice*asusCount;
		
		//输出库存数
		System.out.println("总库存数："+totalCount);
		//输出库存商品总金额数
		System.out.println("商品库存总金额："+totalMoney);
		
	}
}