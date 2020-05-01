package leetcode;
import java.util.*;
/**

有若干张邮票，要求从中选取最少的邮票张数凑成一个给定的总值。     如，有1分，3分，3分，3分，4分五张邮票，
要求凑成10分，则使用3张邮票：3分、3分、4分即可。

输入描述:
    有多组数据，对于每组数据，首先是要求凑成的邮票总值M，M<100。然后是一个数N，N〈20，表示有N张邮票。接下来是N个正整数，
    分别表示这N张邮票的面值，且以升序排列。


输出描述:
      对于每组数据，能够凑成总值M的最少邮票张数。若无解，输出0。
示例1
输入
10
5
1 3 3 3 4
输出
3
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class 最少邮票 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int total = scan.nextInt();
		int number = scan.nextInt();
		int[] shuzu = new int[number];

		for (int i = 0; i < number; i++)
			shuzu[i] = scan.nextInt();
		for (int i = number - 1; i >= 0; i--) {
			total = total - shuzu[i];
			if (total == 0) {//恰好结束
				System.out.println(number - i);
				break;
			}
			if (total < 0) {
				System.out.println(0);
				break;
			}
			if (i == 0 && total > 0) {
				System.out.println(0);
			}
		}
	}

}
