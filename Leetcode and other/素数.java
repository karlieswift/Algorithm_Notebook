package leetcode;

import java.util.*;

/**
 * �������Ҹ�λ��1
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class ���� {

	public static void main(String[] args) {
		fun1(100);
		System.out.println();
		fun2(100);
	}
/**
 * �������Ҹ�λ��1
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
	 * ��ӡ����
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