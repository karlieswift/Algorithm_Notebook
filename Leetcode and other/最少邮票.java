package leetcode;
import java.util.*;
/**

����������Ʊ��Ҫ�����ѡȡ���ٵ���Ʊ�����ճ�һ����������ֵ��     �磬��1�֣�3�֣�3�֣�3�֣�4��������Ʊ��
Ҫ��ճ�10�֣���ʹ��3����Ʊ��3�֡�3�֡�4�ּ��ɡ�

��������:
    �ж������ݣ�����ÿ�����ݣ�������Ҫ��ճɵ���Ʊ��ֵM��M<100��Ȼ����һ����N��N��20����ʾ��N����Ʊ����������N����������
    �ֱ��ʾ��N����Ʊ����ֵ�������������С�


�������:
      ����ÿ�����ݣ��ܹ��ճ���ֵM��������Ʊ���������޽⣬���0��
ʾ��1
����
10
5
1 3 3 3 4
���
3
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class ������Ʊ {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int total = scan.nextInt();
		int number = scan.nextInt();
		int[] shuzu = new int[number];

		for (int i = 0; i < number; i++)
			shuzu[i] = scan.nextInt();
		for (int i = number - 1; i >= 0; i--) {
			total = total - shuzu[i];
			if (total == 0) {//ǡ�ý���
				System.out.println(number - i);
				break;
			}
			if (total < 0) {
				System.out.println(0);
				break;
			}
			if (i == 0 && total > 0) {
				System.out.println(0);
			}
		}
	}

}
