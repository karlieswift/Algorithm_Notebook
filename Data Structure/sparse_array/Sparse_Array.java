package sparse_array;

/**
 * 
 * 稀释数组与矩阵相互转化
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 */
public class Sparse_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[6][3] = 2;
		System.out.println("原始数组：");
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1.length; j++) {
				System.out.print(chessArr1[i][j] + " ");
			}
			System.out.println();
		}
		int sum = 0; // 定义非零的个数
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1.length; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}

		int counts = 0; // 记录第几个非零的数字
		int sparseArr1[][] = new int[sum + 1][3]; // 初始化稀疏数组

		// 稀疏数组总共有三列，矩阵非零个数行+1；
		// 其中第一行[0][0]代表矩阵的行，[0][1]代表矩阵的列，[0][2]代表总共几个非零值
		sparseArr1[0][0] = chessArr1.length;
		sparseArr1[0][1] = chessArr1.length;
		sparseArr1[0][2] = sum;

		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1.length; j++) {
				if (chessArr1[i][j] != 0) {
					counts++;
					sparseArr1[counts][0] = i;
					sparseArr1[counts][1] = j;
					sparseArr1[counts][2] = chessArr1[i][j];
				}
			}
		}
		System.out.println("稀疏数组：");
		for (int i = 0; i < counts + 1; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(sparseArr1[i][j] + " ");
			}
			System.out.println();
		}

		// 稀疏数组转矩阵

		int chessArr2[][] = new int[sparseArr1[0][0]][sparseArr1[0][1]];
		for (int i = 1; i < sparseArr1.length; i++) {
			for (int j = 0; j < sparseArr1.length; j++) {
				chessArr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
			}
		}

		System.out.println("稀疏数组：");
		for (int i = 0; i < chessArr2.length; i++) {
			for (int j = 0; j < chessArr2.length; j++) {
				System.out.print(chessArr2[i][j] + " ");
			}
			System.out.println();
		}

	}

}
