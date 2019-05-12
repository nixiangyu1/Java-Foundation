/*
	实现库存管理案例:
		1.存储商品信息
			存储商品信息
			将商品类型的变量，存储到集合中
			
		2.查看库存清单
			将集合进行遍历，获取出集合中存储的Goods类型变量
			输出每一个Goods类型的属性
			计算求和:总库存,金额数
		 
		3.修改商品库存
			集合遍历，获取出集合中储存的Goods类型的变量
			变量调用Goods类的属性count,值进行修改(键盘输入)
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Shopp{
	public static void main(String args[]){
		//创建ArrayList集合，存储Goods类型
		ArrayList<Goods> array=new ArrayList<Goods>();
		//调用添加商品信息的方法
		addGoods(array);
		//进入死循环
		while(true){
			//调用选择功能的方法，获取用户输入的序号
			int number=chooseFunction();
			//对序号判断，如果=1 进入查看库存功能 =2进入修改库存功能 =3退出
			switch(number){
				case 1:
				//进入查看库存方法
				printStore(array);
				break;
				
				case 2:
				//进入修改库存功能
				update(array);
				break;
				
				case 3:
				return;
				
				default:
				 System.out.println("无此功能");
				 break;
			}
		}
		
	}
	
	/*
		定义方法，实现选择菜单，用户根据功能选择菜单
	*/
	public static int chooseFunction(){
		System.out.println("-------------库存管理------------");
		System.out.println("1.查看库存清单");
		System.out.println("2.修改商品库存数量");
		System.out.println("3.退出");
		System.out.println("请输入要执行的操作序号：");
		Scanner sc=new Scanner(System.in);
		int number =sc.nextInt();
		return number;
	}
	
	/*
		方法定义，修改库存
		键盘输入，将Goods的属性count，进行修改(键盘输入)
	*/
	public static void update(ArrayList<Goods> array){
		Scanner sc =new Scanner(System.in);
		//遍历集合，获取集合中的每个元素
		for(int i=0;i<array.size();i++){
			//集合方法get获取的是集合的元素,元素类型Goods
			Goods g = array.get(i);
			System.out.println("请输入"+g.brand+"库存数");
			//Goods属性，count进行修改
			g.count=sc.nextInt();
			
		}
	}
	
	
	/*
		定义方法，查看库存清单，遍历集合
	*/
	public static void printStore(ArrayList<Goods> array){
		//输出表头
		System.out.println("--------------商品库存清单-----------------");
		System.out.println("品牌型号    尺寸    价格   库存数");
		
		int totalCount=0;
		double totalMoney=0;
		//遍历集合
		for(int i=0;i<array.size();i++){
			//get(索引)获取出集合中的元素，存储的是Goods类，获取的是Goods类型
			Goods g=array.get(i);
			
			System.out.println(g.brand+" "+g.size+" "+g.price+" "+g.count);
			totalCount=totalCount+g.count;
			totalMoney=totalMoney+g.count*g.price;
		}
		System.out.println("总库存数:"+totalCount);
		System.out.println("商品库存总金额数:"+totalMoney);
		
	}
	
	
	/*
		定义方法，将商品的信息存储到集合中
		集合是所有方法的共享数据，参数传递
	*/
	
	public static void addGoods(ArrayList<Goods> array){
		//创建出商品类型的变量
		Goods g1=new Goods();
		Goods g2=new Goods();
		
		
		g1.size=13.3;
		g1.brand="Macbook";
		g1.price=9999.9;
		g1.count=3;
		
		g2.size=15.6;
		g2.brand="Thinkpad";
		g2.price=7999.9;
		g2.count=1;
		
		array.add(g1);
		array.add(g2);
	}
}