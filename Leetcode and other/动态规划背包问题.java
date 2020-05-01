package leetcode;

import java.math.MathContext;
import java.util.Arrays;

/**
 * �������� 1-�ݹ� 2-���仯���� 3-��̬�滮
 * 
 * ����������, ��V=15 :param weight: ÿ����Ʒ�����������ʾ, ��weight=[5,4,7,2,6] :param value:
 * ÿ����Ʒ�ļ�ֵ�����ʾ, ��value=[12,3,10,3,6] :return: ���������ܼ�ֵ
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��29��
 * @version "13.0.1"
 */
public class ��̬�滮�������� {
	public static void main(String[] args) {
		int[] weight = new int[] { 5, 4, 7, 2, 6 };// ÿ����Ʒ������
		int[] value = new int[] { 12, 3, 10, 3, 6 };// ÿ����Ʒ�ļ�ֵ
		int N = 5;
		int V = 15;// ����������
		System.out.println(new Bag().bag1(weight, value, V));
		System.out.println(new Bag().bag2(weight, value, V));
		System.out.println(new Bag().bag3(weight, value, V));

	} 
}

class Bag {

	/**
	 * �ݹ����
	 * 
	 * @Function @param w ÿ����Ʒ������
	 * @Function @param v ÿ����Ʒ�ļ�ֵ
	 * @Function @param index �ڼ�����Ʒ 1-index
	 * @Function @param c ����������
	 * @Function @return ���������ܼ�ֵ
	 */
	public int bag1(int[] w, int[] v, int c) {
		return bag1(w, v, w.length - 1, c);
	}

	private int bag1(int[] w, int[] v, int index, int c) {
		if (index < 0 || c < 0)
			return 0;
		// ��һ�ֲ���index���Ž�ȥ��ֱ�ӷ�index-1
		int res = bag1(w, v, index - 1, c);
		// �ڶ��ֲ��ԷŽ�index
		if (c > w[index]) {
			res = Math.max(res, v[index] + bag1(w, v, index - 1, c - w[index]));
		}
		return res;
	}

	/**
	 * �ݹ����------���仯���� ���仯�����ļ������飬���ݹ�ı����м����ڱ仯����������index��c���ڱ䣬 ����memeӦ��Ϊ��ά���飬
	 * 
	 * @Function @param w ÿ����Ʒ������
	 * @Function @param v ÿ����Ʒ�ļ�ֵ
	 * @Function @param index �ڼ�����Ʒ 1-index
	 * @Function @param c ����������
	 * @Function @return ���������ܼ�ֵ
	 */
	public int bag2(int[] w, int[] v, int c) {
		int[][] meme = new int[w.length][c + 1];
		for (int i = 0; i < meme.length; i++)
			Arrays.fill(meme[i], -1);
		return bag2(w, v, w.length - 1, c, meme);

	}

	private int bag2(int[] w, int[] v, int index, int c, int[][] meme) {
		if (index < 0 || c < 0)
			return 0;
		// ����Ѿ������ֱ�ӷ���
		if (meme[index][c] != -1)
			return meme[index][c];

		// ��һ�ֲ���index���Ž�ȥ��ֱ�ӷ�index-1
		int res = bag2(w, v, index - 1, c, meme);
		// �ڶ��ֲ��ԷŽ�index
		if (c > w[index]) {
			meme[index][c] = Math.max(res, v[index] + bag2(w, v, index - 1, c - w[index], meme));
			res = meme[index][c];
		}
		return res;
	}  

	/**
	 * ��̬�滮
	 * 
	 * @Function @param w ÿ����Ʒ������
	 * @Function @param v ÿ����Ʒ�ļ�ֵ
	 * @Function @param index �ڼ�����Ʒ 1-index
	 * @Function @param c ����������
	 * @Function @return ���������ܼ�ֵ
	 */

	public int bag3(int[] w, int[] v, int c) {

		int[][] meme = new int[w.length][c + 1];

		int[][] path = new int[w.length][c + 1];

		// ���µ�һ�� ���Ƕ�̬�滮�Ĵӵ�����
		for (int j = 0; j <= c; j++) {
			if (j >= w[0]) {// ֻ�ŵ�һ����
				meme[0][j] = v[0];
			}
		}

		// ��θ���meme[i][j] ��ʾ0-i�ı����Ž�����j�����ֵ
		for (int i = 1; i < w.length; i++) {
			for (int j = 0; j <= c; j++) {
				meme[i][j] = meme[i - 1][j];// �����ǵ�i������
				if (j >= w[i]) {
					meme[i][j] = Math.max(meme[i][j], v[i] + meme[i - 1][j - w[i]]);
					path[i][j] = 1;
				}
				System.out.print(meme[i][j] + " ");
			}
			System.out.println();
		}
      //���ѡ����ļ�������
		int i = path.length - 1;
		int j = path[0].length - 1;
		while (j > 0 && i > 0) {
			if (path[i][j] == 1) {
				System.out.println("��" + i + "����Ʒ");
				j = j - w[i - 1];
			}
			i--;
		}

		return meme[w.length - 1][c];
	}

	
}
