package cn.itcast.demo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 实现模拟斗地主的功能
 * 1.组合牌
 * 2.洗牌
 * 3.发牌
 * 4.看牌
 * 
 */
public class DouDiZhu {

	public static void main(String[] args) {
		// 1.组合牌
		// 创建Map集合，键是编号，值是牌
		HashMap<Integer, String> pooker = new HashMap<Integer, String>();
		// 创建List集合，存储编号
		ArrayList<Integer> pookerNumber = new ArrayList<Integer>();
		// 定义出13个点数的数组
		String[] numbers = { "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3" };
		String[] colours = { "♠", "♣", "♥", "♦" };
		int index = 2;
		pookerNumber.add(0);
		pooker.put(0, "大王 ");
		pookerNumber.add(1);
		pooker.put(1, "小王");
		for (String number : numbers) {
			for (String colour : colours) {
				pookerNumber.add(index);
				pooker.put(index, colour + number);
				index++;
			}
		}
		// System.out.println(pooker);

		// 洗牌，将牌的编号打乱给
		Collections.shuffle(pookerNumber);
		// System.out.println(pookerNumber);

		// 发牌,将牌的编号一一发给玩家集合,底牌集合
		ArrayList<Integer> player1 = new ArrayList<Integer>();
		ArrayList<Integer> player2 = new ArrayList<Integer>();
		ArrayList<Integer> player3 = new ArrayList<Integer>();
		ArrayList<Integer> bottom = new ArrayList<Integer>();
		for (int i = 0; i < pookerNumber.size(); i++) {
			if (i < 3) {
				bottom.add(pookerNumber.get(i));
			} else if (i % 3 == 0) {
				player1.add(pookerNumber.get(i));
			} else if (i % 3 == 1) {
				player2.add(pookerNumber.get(i));

			} else {
				player3.add(pookerNumber.get(i));
			}

		}
		Collections.sort(player1);
		Collections.sort(player2);
		Collections.sort(player3);
		Collections.sort(player1);
		look("player1",player1,pooker);
		look("player2",player2,pooker);
		look("player3",player3,pooker);
		look("底牌",bottom,pooker);

	}

	// 看牌，将玩家集合中的元素当作key，去pooker集合中找键
	public static void look(String name,ArrayList<Integer> player, HashMap<Integer, String> pooker) {
			System.out.print(name+" ");
			for(Integer key:player) {
				String value = pooker.get(key);
				System.out.print(value+" ");
				
			}
			System.out.println();
	}
}
