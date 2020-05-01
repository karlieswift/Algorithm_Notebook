package leetcode;

import java.util.*;

/**
 * 因子个数 思路： 一个正整数n,除了1与本身还有其他的因子，那么因子一定在sqrt(n)两边成对出现
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class 因子个数 {
	public static int fuction_1(int number) {
		int total = 0;
		int i = 1;
		while (i <= number) {
			if (number % i == 0) {
				System.out.print(i + " ");
				total++;
			}
			i++;
		}
		System.out.println();
		return total;
	}
/**
 * 优化依据：
 * 一个正整数n,除了1与本身还有其他的因子，那么因子一定在sqrt(n)两边成对出现
 * @Function @param number
 * @Function @return
 */
	public static int fuction_2(int number) {
		int total = 0;
		int i;
		for (i = 1; i * i < number; i++) {
			if (number % i == 0)
				// 一个正整数n,除了1与本身还有其他的因子，那么因子一定在sqrt(n)两边成对出现
				total = total + 2;
		}
		if (i * i == number)
			total++;
		return total;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int number = scan.nextInt();
			int[] a = new int[number];
			for (int i = 0; i < number; i++) {
				int temp = scan.nextInt();
				a[i] = fuction_1(temp);
			}
			for (int i = 0; i < number; i++)
				System.out.println(a[i]);
		}
	}
}
