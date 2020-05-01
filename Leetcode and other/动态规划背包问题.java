package leetcode;

import java.math.MathContext;
import java.util.Arrays;

/**
 * 背包问题 1-递归 2-记忆化搜索 3-动态规划
 * 
 * 背包总容量, 如V=15 :param weight: 每个物品的容量数组表示, 如weight=[5,4,7,2,6] :param value:
 * 每个物品的价值数组表示, 如value=[12,3,10,3,6] :return: 返回最大的总价值
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月29日
 * @version "13.0.1"
 */
public class 动态规划背包问题 {
	public static void main(String[] args) {
		int[] weight = new int[] { 5, 4, 7, 2, 6 };// 每个物品的重量
		int[] value = new int[] { 12, 3, 10, 3, 6 };// 每个物品的价值
		int N = 5;
		int V = 15;// 背包总容量
		System.out.println(new Bag().bag1(weight, value, V));
		System.out.println(new Bag().bag2(weight, value, V));
		System.out.println(new Bag().bag3(weight, value, V));

	} 
}

class Bag {

	/**
	 * 递归求解
	 * 
	 * @Function @param w 每个物品的容量
	 * @Function @param v 每个物品的价值
	 * @Function @param index 第几个物品 1-index
	 * @Function @param c 背包总容量
	 * @Function @return 返回最大的总价值
	 */
	public int bag1(int[] w, int[] v, int c) {
		return bag1(w, v, w.length - 1, c);
	}

	private int bag1(int[] w, int[] v, int index, int c) {
		if (index < 0 || c < 0)
			return 0;
		// 第一种策略index不放进去，直接放index-1
		int res = bag1(w, v, index - 1, c);
		// 第二种策略放进index
		if (c > w[index]) {
			res = Math.max(res, v[index] + bag1(w, v, index - 1, c - w[index]));
		}
		return res;
	}

	/**
	 * 递归求解------记忆化搜索 记忆化搜索的记忆数组，看递归的变量有几个在变化，例如这里index与c都在变， 所以meme应该为二维数组，
	 * 
	 * @Function @param w 每个物品的容量
	 * @Function @param v 每个物品的价值
	 * @Function @param index 第几个物品 1-index
	 * @Function @param c 背包总容量
	 * @Function @return 返回最大的总价值
	 */
	public int bag2(int[] w, int[] v, int c) {
		int[][] meme = new int[w.length][c + 1];
		for (int i = 0; i < meme.length; i++)
			Arrays.fill(meme[i], -1);
		return bag2(w, v, w.length - 1, c, meme);

	}

	private int bag2(int[] w, int[] v, int index, int c, int[][] meme) {
		if (index < 0 || c < 0)
			return 0;
		// 如果已经计算过直接返回
		if (meme[index][c] != -1)
			return meme[index][c];

		// 第一种策略index不放进去，直接放index-1
		int res = bag2(w, v, index - 1, c, meme);
		// 第二种策略放进index
		if (c > w[index]) {
			meme[index][c] = Math.max(res, v[index] + bag2(w, v, index - 1, c - w[index], meme));
			res = meme[index][c];
		}
		return res;
	}  

	/**
	 * 动态规划
	 * 
	 * @Function @param w 每个物品的容量
	 * @Function @param v 每个物品的价值
	 * @Function @param index 第几个物品 1-index
	 * @Function @param c 背包总容量
	 * @Function @return 返回最大的总价值
	 */

	public int bag3(int[] w, int[] v, int c) {

		int[][] meme = new int[w.length][c + 1];

		int[][] path = new int[w.length][c + 1];

		// 更新第一行 就是动态规划的从低向上
		for (int j = 0; j <= c; j++) {
			if (j >= w[0]) {// 只放第一个包
				meme[0][j] = v[0];
			}
		}

		// 逐次更新meme[i][j] 表示0-i的背包放进容量j的最大值
		for (int i = 1; i < w.length; i++) {
			for (int j = 0; j <= c; j++) {
				meme[i][j] = meme[i - 1][j];// 不考虑低i个背包
				if (j >= w[i]) {
					meme[i][j] = Math.max(meme[i][j], v[i] + meme[i - 1][j - w[i]]);
					path[i][j] = 1;
				}
				System.out.print(meme[i][j] + " ");
			}
			System.out.println();
		}
      //输出选择的哪几个背包
		int i = path.length - 1;
		int j = path[0].length - 1;
		while (j > 0 && i > 0) {
			if (path[i][j] == 1) {
				System.out.println("第" + i + "个商品");
				j = j - w[i - 1];
			}
			i--;
		}

		return meme[w.length - 1][c];
	}

	
}
