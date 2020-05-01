package leetcode;
/**
 
 
��ӡ���½���� 
1  2  3  
8  9  4  
7  6  5  
--------------------------------------
3  3  3  3  3  3  3  
3  2  2  2  2  2  3  
3  2  1  1  1  2  3  
3  2  1  0  1  2  3  
3  2  1  1  1  2  3  
3  2  2  2  2  2  3  
3  3  3  3  3  3  3


 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class ������ {

	public static void main(String[] args) {
		fun1(3);
		System.out.println("--------------------------------------");
		fun2(3);

	}

	public static void fun1(int n) {
		int[][] arr = new int[n][n];
		int number = 1;
		int min_column = 0;
		int max_column = n - 1;
		int min_row = 0;
		int max_row = n - 1;

		while (min_row <= max_row) {
			// ��һ�� row���䣬column++
			for (int i = min_column; i <= max_column; i++) {
				arr[min_row][i] = number++;
			}
			min_row++;
			// �в��䣬row++
			for (int i = min_row; i <= max_row; i++) {
				arr[i][max_column] = number++;
			}
			max_column--;
			// �в��䣬column--
			for (int i = max_column; i >= min_column; i--) {
				arr[max_row][i] = number++;
			}
			max_row--;
			// �в��䣬row--
			for (int i = max_row; i >= min_row; i--) {
				arr[i][min_column] = number++;
			}
			min_column++;
		}
		showarr(arr);
	}

	public static void fun2(int n) {
		int[][] arr = new int[2 * n + 1][2 * n + 1];
		int min_column = 0;
		int max_column = 2 * n;
		int min_row = 0;
		int max_row = 2 * n;

		while (min_row <= max_row) {
			// ��һ�� row���䣬column++
			for (int i = min_column; i <= max_column; i++) {
				arr[min_row][i] = n;
			}
			min_row++;
			// �в��䣬row++
			for (int i = min_row; i <= max_row; i++) {
				arr[i][max_column] = n;
			}
			max_column--;
			// �в��䣬column--
			for (int i = max_column; i >= min_column; i--) {
				arr[max_row][i] = n;
			}
			max_row--;
			// �в��䣬row--
			for (int i = max_row; i >= min_row; i--) {
				arr[i][min_column] = n;
			}
			min_column++;
			n--;
		}
		showarr(arr);
	}

	public static void showarr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++)
				System.out.printf("%-3d", arr[i][j]);

			System.out.println();
		}
	}

}
