package leetcode;

import java.util.Scanner;
/**
 * 
 * 三个数的最大值可分为2种
 * 第一种：三个最大正数相乘，（也包括全部是负数，最大的三个数相乘也是最大值）
 * 第二种：或者是最小的2个负数与一个最大正数乘积
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class 数组的三个数乘机最大值 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		// 找最大的三个值 存在arr[0] ,arr[1] , arr[2]
		for (int j = 0; j < 3; j++) {
			int max = j;
			for (int k = j + 1; k < n; k++) {
				if (arr[k] > arr[max]) {
					max = k;
				}
			}
			long temp = arr[max];
			arr[max] = arr[j];
			arr[j] = temp;
		}
		long a = arr[0] * arr[1] * arr[2];
		// 找最小的两个值存在 arr[1] , arr[2]
		for (int j = 1; j < 3; j++) {
			int min = j;
			for (int k = j + 1; k < n; k++) {
				if (arr[k] < arr[min]) {
					min = k;
				}
			}
			long temp = arr[min];
			arr[min] = arr[j];
			arr[j] = temp;
		}
		long b = arr[0] * arr[1] * arr[2];
		
		
		System.out.println(Math.max(a, b));
	}

}

/**
 * 4 3 4 1 2
 */