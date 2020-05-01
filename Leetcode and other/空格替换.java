package leetcode;

/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月11日
 * @version "13.0.1"
 * 
 *          请实现一个函数，将一个字符串中的每个空格替换成“%20”。 例如，当字符串为We Are
 *          Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 空格替换 {

	public static void main(String[] args) {

		StringBuffer str = new StringBuffer("We Are Happy.");

		System.out.println(replaceSpace(str));
	}

	public static String replaceSpace(StringBuffer str) {

		int len = str.length();
		int tapcounts = 0;// 空格数
		char[] ch = str.toString().toCharArray();
		for (int i = 0; i < ch.length; i++) {// 计算空格数
			if (ch[i] == ' ') {
				tapcounts++;
			}
		}
		char[] newch = new char[ch.length + 2 * tapcounts];// 最后的数组长度

		int ch_index = ch.length - 1;
		int newch_index = newch.length - 1;
		while (ch_index != newch_index) {
			if (ch[ch_index] != ' ') {
				newch[newch_index--] = ch[ch_index--];
				// continue;
			} else {
				newch[newch_index] = '0';
				newch[newch_index - 1] = '2';
				newch[newch_index - 2] = '%';
				ch_index--;
				newch_index = newch_index - 3;
			}
		}
		for (int i = newch_index; i >= 0; i--) {//把ch剩余的一个单词付给newch
			newch[i] = ch[i];
		}
		return new String(newch);
	}
}
