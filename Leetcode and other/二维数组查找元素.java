package leetcode;

/**
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������ 
 * ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 * 
 * 
 * ˼·��
 * �Ӿ�������Ͻǿ�ʼ��
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��11��
 * @version "13.0.1"
 */
public class ��ά�������Ԫ�� {
	public static void main(String[] args) {

//		int[][]array= {
//				{1,2,8,9},
//				{2,4,9,12},
//				{4,7,10,13},
//				{6,8,11,15}};
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 }, };
		System.out.println(Find(4, array));
	}

	public static boolean Find(int target, int[][] array) {

		int row = 0;
		int rows = array.length - 1;
		int columns = array[0].length - 1;

		while (row <= rows && columns >= 0) {
			if (array[row][columns] == target) {//�Ӿ�������Ͻǿ�ʼ��
				System.out.println(row + " " + columns);
				return true;
			}
			if (array[row][columns] > target) {//˵����0-colums-1֮��������
				columns--;
			} else {//������
				row++;
			}
		}
		return false;
	}
}
