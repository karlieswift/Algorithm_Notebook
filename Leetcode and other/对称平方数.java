package leetcode;

import java.util.*;

/**
 * ��ӡ���в�����n��n<256���ģ���ƽ�����жԳ����ʵ�������11*11=121��
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��29��
 * @version "13.0.1"
 */
public class �Գ�ƽ���� {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// int number=scan.nextInt();
		for (int i = 0; i < 256; i++) {
			String str = String.valueOf(i * i);
			StringBuffer str_1 = new StringBuffer(str);
			if (new String(str_1.reverse()).equals(str)) {
				System.out.println(str);
			}
		}

	}

}
