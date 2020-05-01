package leetcode;

import java.util.Scanner;
/**
 *
 *
 *
 *散列算法：
 *
 *
 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、
 以及实际被输入的文字，请你列出肯定坏掉的那些键。
输入格式：
输入在 2 行中分别给出应该输入的文字、以及实际被输入的文字。每段文字是不超过 80 个字符的串，
由字母 A-Z（包括大、小写）、数字 0-9、以及下划线 _（代表空格）组成。题目保证 2 个字符串均非空。
输出格式：
按照发现顺序，在一行中输出坏掉的键。其中英文字母只输出大写，每个坏键只输出一次。题目保证至少有 1 个坏键。
 输入样例：
7_This_is_a_test
_hs_s_a_es   
输出样例：
7TI
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月25日
 * @version "13.0.1"
 */
public class 旧键盘 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] ch1 = scan.next().toCharArray();
		char[] ch2 = scan.next().toCharArray();
		boolean[] flag = new boolean[128];
		for (int i = 0; i < ch1.length; i++) {
			int j;
			for (j = 0; j < ch2.length; j++) {
				if (ch1[i] > 'a' && ch1[i] < 'z')
					ch1[i] = (char) (ch1[i] - 'a' + 'A');//小写字母转大写字母
				if (ch2[j] > 'a' && ch2[j] < 'z')
					ch2[j] = (char) (ch2[j] - 'a' + 'A');//小写字母转大写字母
				if (ch1[i] == ch2[j]) {
					break;
				}
			}
			//例子 如果一个键盘7坏了，那么ch2找到最后也找不到，那就打印7，接下来再看_是不是
			//定义boolean[] flag  目的是不让坏的键盘再次输入,flag=true说明已经输出，不用再次输出
			if (j == ch2.length && flag[ch1[i]] == false) {
				System.out.print(ch1[i]);
				flag[ch1[i]] = true;
			}
		}
	}
}
