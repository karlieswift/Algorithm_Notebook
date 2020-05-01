package leetcode;

import java.util.*;

/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月29日
 * @version "13.0.1"
 */
public class 第几天 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入年月日例如 1236 2 15 ");
		while (scan.hasNext()) {
			int year = scan.nextInt();
			int month = scan.nextInt();
			int day = scan.nextInt();
			int total_day = 0;
			int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 其实最后一个月用不到
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				if (month > 2)// 当瑞年且月份为2月以上，才加1，统一计算
					total_day++;
			}
			for (int i = 0; i < month; i++) {
				total_day = total_day + months[i];
			}
			System.out.println(total_day + day);

		}
	}
}