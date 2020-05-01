package leetcode;

import java.util.Arrays;
/**
 * 解决方法
 * 1-递归暴力搜索 JumpFloor_1(int target) 
 * 2-递归记忆化搜索JumpFloor_2(int target) 
 * 3-动态规划JumpFloor_3(int target) 
 * 
 * 第一题：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n
 * 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 思路：
 * 递归公式：因为当跳到f(n)时，有两种可能跳到fn,从f(n-1)跳过来的，也或者从f(n-2)直接跳过的
 * 所以f(n)=f(n-1)+f(n-2),找到递推关系
 * 结束条件：当从台阶等于1 一种 台阶==2有两种
 * 
 * 
 * 第二题：JumpFloor_4(int target) 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：
   f(1)=1,f(2)=2, f(n) =f(n-1)+f(n-2)+...+f(2)+f(1) f(n-1)=f(n-2)+...+f(2)+f(1)
   f(n)=f(n-1)+f(n-1) =2*f(n-1) =2*[2*f(n-2)] =2^2*f(n-2) =2^3*f(n-3)
       =2^(n-1)*f(1) =2^(n-1)
       
       
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月27日
 * @version "13.0.1"
 */
public class 动态规划青蛙跳台阶 {
	public static void main(String[] args) {
		System.out.println(JumpFloor_1(6));
		System.out.println(JumpFloor_2(6));
		System.out.println(JumpFloor_3(6));
		System.out.println(JumpFloor_4(6));
	}

    //递归
	public static int JumpFloor_1(int target) { // 一次跳1个或者2个台阶
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;

		return JumpFloor_1(target - 1) + JumpFloor_1(target - 2);
	}

	// 记忆化搜索
	public static int JumpFloor_2(int n) {
		int[] meme = new int[n + 1];
		Arrays.fill(meme, -1);
		return JumpFloor_2(n, meme);
	}

	private static int JumpFloor_2(int target, int[] meme) { // 一次跳1个或者2个台阶
		meme[1] = 1;
		meme[2] = 2;
		if (meme[target] == -1) {//当已经计算过直接return
			meme[target] = JumpFloor_2(target - 1, meme) + JumpFloor_2(target - 2, meme);
		}

		return meme[target];

	}

	/**
	 * 动态规划
	 * @Function @param target
	 * @Function @return
	 */
	public static int JumpFloor_3(int target) { // 一次跳1个或者2个台阶
		int[] meme = new int[target + 1];
		meme[0] = 1;
		meme[1] = 1;
		for (int i = 2; i <= target; i++) {
			meme[i] = meme[i - 1] + meme[i - 2];
		}
		return meme[target];

	}
/**
 * 第二题
 * 一次可以跳 1——targetge 个台阶
 * @Function @param target
 * @Function @return
 */
	public static int JumpFloor_4(int target) { // 一次可以跳 1——targetge 个台阶
		/*
		 * f(1)=1,f(2)=2, f(n) =f(n-1)+f(n-2)+...+f(2)+f(1) f(n-1)=f(n-2)+...+f(2)+f(1)
		 * f(n)=f(n-1)+f(n-1) =2*f(n-1) =2*[2*f(n-2)] =2^2*f(n-2) =2^3*f(n-3)
		 * =2^(n-1)*f(1) =2^(n-1)
		 */
		return 1 << (target - 1);
	}

}
