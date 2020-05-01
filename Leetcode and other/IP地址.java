package leetcode;

import java.util.*;
/**
 * 每行有一个IP地址，IP地址的形式为a.b.c.d，其中a、b、c、d都是整数。
 *
可能有多组测试数据，对于每组数据，如果IP地址合法则输出"Yes!”，否则输出"No!”。

合法的IP地址为：
a、b、c、d都是0-255的整数。
示例1
输入
255.255.255.255
512.12.2.3
输出
Yes!
No!
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class IP地址 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String[] a = new String[n];
		int i;
		for (i = 0; i < n; i++) {
			String[] str = scan.next().split("\\.");
			int j;
			for (j = 0; j < 4; j++) {
				int temp = Integer.valueOf(str[j]);
				if (temp > 255 || temp < 0) {
					a[i] = "No!";
					j = 666666;
					break;
				}
			}
			if (j == 4)
				a[i] = "Yes!";
		}
		for (i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
	}
}