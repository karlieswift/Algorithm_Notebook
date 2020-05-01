package leetcode;

import java.util.ArrayList;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *  给出数字到字母的映射如下（与电话按键相同）。
 * 注意 1 不对应任何字母。 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月26日
 * @version "13.0.1"
 */
public class 电话号码组合 {

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
	 * 进行递归回溯
	 * @Function @param digits[]传入的是数字字符
	 * @Function @param index 代表digits[]的下标，每次进行递归，大小为0-digits.length-1
	 *      index==digits.length结束
	 * @Function @param s 保存结果的字符串
	 * @Function @param list  保存s统一记录
	 * 
	 * 
	 * 以digits = { '2', '3' }分析
	 * index=0，c = digits[index] 得到letters的"abc"
	 * 对"abc"进行递归for循环"abc".length 3次。
	 *  过程：
	 *  1- index=0 digits[0]=2,letters[2]="abc",s=""-->s="a"  i=0
	 *  2- index=1  digits[1]=3,letters[3]="def" s="a"-->s="ad" i=0
	 *  3- index=2==length 输出s="ad" return 回溯
	 *  4-回溯到index=1 i=1 s="ae"
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