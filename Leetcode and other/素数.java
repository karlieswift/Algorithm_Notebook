package leetcode;

import java.util.*;

/**
 * 是素数且各位是1
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class 素数 {

	public static void main(String[] args) {
		fun1(100);
		System.out.println();
		fun2(100);
	}
/**
 * 是素数且个位是1
 * @Function @param n
 */
	public static void fun1(int n) {
		int number = n;
		int i, j = 2;
		while (j <= number) {
			for (i = 2; i * i <= j; i++) {
				if (j % i == 0)
					break;
				if ((i + 1) * (i + 1) > j && j % 10 == 1) {
					System.out.print(j);
					System.out.print(" ");
				}
			}
			j++;
		}

	}
	/**
	 * 打印素数
	 * @Function @param n
	 */
	public static void fun2(int n) {
		int number = n;
		int i, j = 2;
		while (j <= number) {
			for (i = 2; i * i <= j; i++) {
				if(j%i==0)break;
			}
				
			if(i*i>j)System.out.print(j+" ");
			j++;
		}
		
	}
}