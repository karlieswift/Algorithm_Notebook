package leetcode;

import java.util.Scanner;
/**
 *
 *
 *
 *ɢ���㷨��
 *
 *
 �ɼ����ϻ��˼���������������һ�����ֵ�ʱ�򣬶�Ӧ���ַ��Ͳ�����֡����ڸ���Ӧ�������һ�����֡�
 �Լ�ʵ�ʱ���������֣������г��϶���������Щ����
�����ʽ��
������ 2 ���зֱ����Ӧ����������֡��Լ�ʵ�ʱ���������֡�ÿ�������ǲ����� 80 ���ַ��Ĵ���
����ĸ A-Z��������Сд�������� 0-9���Լ��»��� _������ո���ɡ���Ŀ��֤ 2 ���ַ������ǿա�
�����ʽ��
���շ���˳����һ������������ļ�������Ӣ����ĸֻ�����д��ÿ������ֻ���һ�Ρ���Ŀ��֤������ 1 ��������
 ����������
7_This_is_a_test
_hs_s_a_es   
���������
7TI
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��25��
 * @version "13.0.1"
 */
public class �ɼ��� {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] ch1 = scan.next().toCharArray();
		char[] ch2 = scan.next().toCharArray();
		boolean[] flag = new boolean[128];
		for (int i = 0; i < ch1.length; i++) {
			int j;
			for (j = 0; j < ch2.length; j++) {
				if (ch1[i] > 'a' && ch1[i] < 'z')
					ch1[i] = (char) (ch1[i] - 'a' + 'A');//Сд��ĸת��д��ĸ
				if (ch2[j] > 'a' && ch2[j] < 'z')
					ch2[j] = (char) (ch2[j] - 'a' + 'A');//Сд��ĸת��д��ĸ
				if (ch1[i] == ch2[j]) {
					break;
				}
			}
			//���� ���һ������7���ˣ���ôch2�ҵ����Ҳ�Ҳ������Ǿʹ�ӡ7���������ٿ�_�ǲ���
			//����boolean[] flag  Ŀ���ǲ��û��ļ����ٴ�����,flag=true˵���Ѿ�����������ٴ����
			if (j == ch2.length && flag[ch1[i]] == false) {
				System.out.print(ch1[i]);
				flag[ch1[i]] = true;
			}
		}
	}
}
