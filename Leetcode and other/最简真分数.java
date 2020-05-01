package leetcode;
import java.util.*;
/**

给出n个正整数，任取两个数分别作为分子和分母组成最简真分数，编程求共有几个这样的组合。

输入描述:
每组包含n（n<=600）和n个不同的整数，整数大于1且小于等于1000。


输出描述:
每行输出最简真分数组合的个数。
示例1
输入
7
3 5 7 9 11 13 15
3 
2 4 5
输出
17 
2
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class 最简真分数 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int counts = 0;
		int n = scan.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		Arrays.sort(a);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				if (1 == gcd(a[i], a[j]))
					counts++;
		System.out.println(counts);
	}

	public static int gcd(int a, int b) {
		while (a != 0) {
			int temp = b % a;
			b = a;
			a = temp;
		}
		return b;
	}
}
