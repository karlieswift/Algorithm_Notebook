package leetcode;

import java.util.*;
/**
 * ÿ����һ��IP��ַ��IP��ַ����ʽΪa.b.c.d������a��b��c��d����������
 *
�����ж���������ݣ�����ÿ�����ݣ����IP��ַ�Ϸ������"Yes!�����������"No!����

�Ϸ���IP��ַΪ��
a��b��c��d����0-255��������
ʾ��1
����
255.255.255.255
512.12.2.3
���
Yes!
No!
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class IP��ַ {
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