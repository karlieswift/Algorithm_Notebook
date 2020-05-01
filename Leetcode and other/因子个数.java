package leetcode;

import java.util.*;

/**
 * ���Ӹ��� ˼·�� һ��������n,����1�뱾�������������ӣ���ô����һ����sqrt(n)���߳ɶԳ���
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class ���Ӹ��� {
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
 * �Ż����ݣ�
 * һ��������n,����1�뱾�������������ӣ���ô����һ����sqrt(n)���߳ɶԳ���
 * @Function @param number
 * @Function @return
 */
	public static int fuction_2(int number) {
		int total = 0;
		int i;
		for (i = 1; i * i < number; i++) {
			if (number % i == 0)
				// һ��������n,����1�뱾�������������ӣ���ô����һ����sqrt(n)���߳ɶԳ���
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
