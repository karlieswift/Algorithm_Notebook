package leetcode;
import java.util.*;
/**

����n������������ȡ�������ֱ���Ϊ���Ӻͷ�ĸ�������������������м�����������ϡ�

��������:
ÿ�����n��n<=600����n����ͬ����������������1��С�ڵ���1000��


�������:
ÿ���������������ϵĸ�����
ʾ��1
����
7
3 5 7 9 11 13 15
3 
2 4 5
���
17 
2
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class �������� {

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
