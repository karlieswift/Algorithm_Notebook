package leetcode;

import java.util.*;
/**
 * ������
 taylor swoft and karlie kloss
 Taylor Swoft And Karlie Kloss
 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class ����ĸ��д {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			String str = scan.nextLine();
			char[] ch = str.toCharArray();
			ch[0] = String.valueOf(ch[0]).toUpperCase().charAt(0);
			for (int i = 1; i < str.length() - 1; i++) {
				if (ch[i] == ' ') {
					ch[i + 1] = String.valueOf(ch[i + 1]).toUpperCase().charAt(0);
				}
			}
			System.out.println(ch);
		}
	}
}
