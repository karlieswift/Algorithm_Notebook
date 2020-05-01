package leetcode;

import java.util.Arrays;

/**
 * 

给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
思路：
f(n)代表最大值，对n进行分割，
f(n)=1*f(n-1) 也可以是2*f(n-2)  (n-1)*f(1),求最大的一个，这个用for循环做
至于f(n-1),f(n-2) f(n-3)......调用递归
示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
说明: 你可以假设 n 不小于 2 且不大于 58。
                                            
来源：力扣（LeetCode） 343. 整数拆分
链接：https://leetcode-cn.com/problems/integer-break

 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月27日
 * @version "13.0.1"
 */
public class 动态规划整数拆分求最大乘积 {
	public static void main(String[] args) {
		IntegerTest integerTest = new IntegerTest();
		System.out.println(integerTest.fun1(10));
		System.out.println(integerTest.fun2(10));
		System.out.println(integerTest.fun3(10));
	}

}

class IntegerTest {
	public int max3(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	/**
	 * 递归
	 * @Function @param n
	 * @Function @return
	 */
	public int fun1(int n) {
		// 结束条件
		if (n == 1)
			return 1;
		int res = -1;
		for (int i = 1; i <= n - 1; i++) {//从1-n-1都分割试试
			//分割成 i和n-i 或者i 与 fun1(n - i), fun1(n - i)继续往下分
			// i * fun1(n - i)代表分割了i继续分割f(n-i)
			// i * (n - i)代表分割i后，不进行分割，只分割2份，
			// 取两者最大值
			res = max3(res, i * (n - i), i * fun1(n - i));
		}
		return res;
	}

	/**
	 * 记忆化搜索
	 * @Function @param n
	 * @Function @return
	 */
	public int fun2(int n) {
		int[] meme = new int[n + 1];
		Arrays.fill(meme, -1);
		return fun2(n, meme);
	}

	private int fun2(int n, int[] meme) {
		meme[1] = 1;
		int res = -1;
		if (meme[n] == -1)
			for (int i = 1; i <= n - 1; i++) {
				// 分割成 i+n-i
				res = max3(res, i * (n - i), i * fun2(n - i, meme));
			}
		meme[n]=res;
		return res;
	}

	/**
	 * 动态规划
	 * @Function @param n
	 * @Function @return
	 */
	public int fun3(int n) {
		int[] meme = new int[n + 1];
		meme[1] = 1;
		for (int i = 1; i <= n - 1; i++) {
			// 分割成 i和n-i 或者i 与 fun1(n - i), fun1(n - i)继续往下分
			// i * fun1(n - i)代表分割了i继续分割f(n-i)
			// i * (n - i)代表分割i后，不进行分割，只分割2份，
			// 取两者最大值
			meme[n]= max3(meme[n], i * (n - i), i * fun3(n - i));
		}
		return meme[n];
	}
	
	
	
	
	
}