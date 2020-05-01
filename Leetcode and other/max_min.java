package leetcode;
import java.util.*;
/**


输入N个（N<=10000）数字，求出这N个数字中的最大值和最小值。每个数字的绝对值不大于1000000。

输入描述:
输入包括多组测试用例，每组测试用例由一个整数N开头，接下去一行给出N个整数。


输出描述:
输出包括两个整数，为给定N个数中的最大值与最小值。
示例1
输入
5
1 2 3 4 5
3
3 7 8
输出
5 1
8 3
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class max_min {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int min, max;
		int number = scan.nextInt();
		int temp = scan.nextInt();
		min = max = temp;
		for (int i = 1; i < number; i++) {
			temp = scan.nextInt();
			if (min > temp)
				min = temp;
			if (max <= temp)
				max = temp;
		}
		System.out.println(max + " " + min);
	}

}
