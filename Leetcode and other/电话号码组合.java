package leetcode;

import java.util.ArrayList;

/**
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 *  �������ֵ���ĸ��ӳ�����£���绰������ͬ����
 * ע�� 1 ����Ӧ�κ���ĸ�� ���룺"23"
 * �����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��26��
 * @version "13.0.1"
 */
public class �绰������� {

	public static void main(String[] args) throws Exception {
		char[] digits = { '2', '3' };
		new PhoneNumber().phonenumber(digits);

	}

}

class PhoneNumber {

	String[] letter_map = { " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public void phonenumber(char[] digits) {
		ArrayList<String> list = new ArrayList<String>();
		String s = "";
		phonenumber(digits, 0, s, list);
		System.out.println(list);
	}

	/**
	 * ���еݹ����
	 * @Function @param digits[]������������ַ�
	 * @Function @param index ����digits[]���±꣬ÿ�ν��еݹ飬��СΪ0-digits.length-1
	 *      index==digits.length����
	 * @Function @param s ���������ַ���
	 * @Function @param list  ����sͳһ��¼
	 * 
	 * 
	 * ��digits = { '2', '3' }����
	 * index=0��c = digits[index] �õ�letters��"abc"
	 * ��"abc"���еݹ�forѭ��"abc".length 3�Ρ�
	 *  ���̣�
	 *  1- index=0 digits[0]=2,letters[2]="abc",s=""-->s="a"  i=0
	 *  2- index=1  digits[1]=3,letters[3]="def" s="a"-->s="ad" i=0
	 *  3- index=2==length ���s="ad" return ����
	 *  4-���ݵ�index=1 i=1 s="ae"
	 *  .....
	 */
	private void phonenumber(char[] digits, int index, String s, ArrayList<String> list) {
		if (index == digits.length) {//
			// System.out.println(s);
			list.add(s);
			return;
		}
		char c = digits[index];
		String letters = letter_map[c - '0'];
		for (int i = 0; i < letters.length(); i++) {
			phonenumber(digits, index + 1, s + letters.charAt(i), list);
		}
	}
}