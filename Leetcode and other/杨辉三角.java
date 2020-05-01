package leetcode;

import java.util.Scanner;
/**
 输入杨辉三角的行数：6
直角三角形输出：
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
等边三角形输出：
                  1     
               1     1     
            1     2     1     
         1     3     3     1     
      1     4     6     4     1     
   1     5     10    10    5     1    
    
    
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class 杨辉三角 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("输入杨辉三角的行数：");
		int n = scan.nextInt();
		int[][] yanghui = new int[n][];
		for (int i = 0; i < yanghui.length; i++) {
			yanghui[i] = new int[i + 1];

		}
		for (int i = 0; i < yanghui.length; i++) {
			yanghui[i][0] = 1;
			yanghui[i][yanghui[i].length - 1] = 1;
			// 从i=2开始
			if (i > 1) {
				for (int j = 1; j < yanghui[i].length - 1; j++) {
					yanghui[i][j] = yanghui[i - 1][j] + yanghui[i - 1][j - 1];
				}

			}

		}
		//直角三角形输出
		System.out.println("直角三角形输出：");
		for (int i = 0; i < yanghui.length; i++) {
			for (int j = 0; j < yanghui[i].length; j++) {
				System.out.print(yanghui[i][j] + " ");
			}
			System.out.println();
 
		}
		//等边三角形输出
		System.out.println("等边三角形输出：");
		for (int i = 0; i < yanghui.length; i++) {
			for (int j = 0; j < yanghui.length - i; j++) {
				System.out.print("   ");
			}
			for (int j = 0; j < yanghui[i].length; j++) {
				System.out.printf("%-6d", yanghui[i][j]);
			}
			System.out.println();

		}

	}

}
