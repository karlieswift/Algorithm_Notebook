package leetcode;

import java.util.Scanner;
/**
 * 
 * �����������ֵ�ɷ�Ϊ2��
 * ��һ�֣��������������ˣ���Ҳ����ȫ���Ǹ������������������Ҳ�����ֵ��
 * �ڶ��֣���������С��2��������һ����������˻�
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class ������������˻����ֵ {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		// ����������ֵ ����arr[0] ,arr[1] , arr[2]
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
		// ����С������ֵ���� arr[1] , arr[2]
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