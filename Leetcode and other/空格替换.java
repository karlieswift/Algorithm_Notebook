package leetcode;

/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��11��
 * @version "13.0.1"
 * 
 *          ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20���� ���磬���ַ���ΪWe Are
 *          Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class �ո��滻 {

	public static void main(String[] args) {

		StringBuffer str = new StringBuffer("We Are Happy.");

		System.out.println(replaceSpace(str));
	}

	public static String replaceSpace(StringBuffer str) {

		int len = str.length();
		int tapcounts = 0;// �ո���
		char[] ch = str.toString().toCharArray();
		for (int i = 0; i < ch.length; i++) {// ����ո���
			if (ch[i] == ' ') {
				tapcounts++;
			}
		}
		char[] newch = new char[ch.length + 2 * tapcounts];// �������鳤��

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
		for (int i = newch_index; i >= 0; i--) {//��chʣ���һ�����ʸ���newch
			newch[i] = ch[i];
		}
		return new String(newch);
	}
}
