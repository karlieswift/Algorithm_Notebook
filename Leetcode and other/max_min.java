package leetcode;
import java.util.*;
/**


����N����N<=10000�����֣������N�������е����ֵ����Сֵ��ÿ�����ֵľ���ֵ������1000000��

��������:
��������������������ÿ�����������һ������N��ͷ������ȥһ�и���N��������


�������:
�����������������Ϊ����N�����е����ֵ����Сֵ��
ʾ��1
����
5
1 2 3 4 5
3
3 7 8
���
5 1
8 3
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class max_min {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int min, max;
		int number = scan.nextInt();
		int temp = scan.nextInt();
		min = max = temp;
		for (int i = 1; i < number; i++) {
			temp = scan.nextInt();
			if (min > temp)
				min = temp;
			if (max <= temp)
				max = temp;
		}
		System.out.println(max + " " + min);
	}

}
