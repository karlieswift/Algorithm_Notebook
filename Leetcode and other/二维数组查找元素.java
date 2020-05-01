package leetcode;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序， 
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 
 * 思路：
 * 从矩阵的右上角开始找
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月11日
 * @version "13.0.1"
 */
public class 二维数组查找元素 {
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
			if (array[row][columns] == target) {//从矩阵的右上角开始找
				System.out.println(row + " " + columns);
				return true;
			}
			if (array[row][columns] > target) {//说明在0-colums-1之间向左找
				columns--;
			} else {//向下找
				row++;
			}
		}
		return false;
	}
}
