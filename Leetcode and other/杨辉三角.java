package leetcode;

import java.util.Scanner;
/**
 ����������ǵ�������6
ֱ�������������
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
�ȱ������������
                  1     
               1     1     
            1     2     1     
         1     3     3     1     
      1     4     6     4     1     
   1     5     10    10    5     1    
    
    
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class ������� {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("����������ǵ�������");
		int n = scan.nextInt();
		int[][] yanghui = new int[n][];
		for (int i = 0; i < yanghui.length; i++) {
			yanghui[i] = new int[i + 1];

		}
		for (int i = 0; i < yanghui.length; i++) {
			yanghui[i][0] = 1;
			yanghui[i][yanghui[i].length - 1] = 1;
			// ��i=2��ʼ
			if (i > 1) {
				for (int j = 1; j < yanghui[i].length - 1; j++) {
					yanghui[i][j] = yanghui[i - 1][j] + yanghui[i - 1][j - 1];
				}

			}

		}
		//ֱ�����������
		System.out.println("ֱ�������������");
		for (int i = 0; i < yanghui.length; i++) {
			for (int j = 0; j < yanghui[i].length; j++) {
				System.out.print(yanghui[i][j] + " ");
			}
			System.out.println();
 
		}
		//�ȱ����������
		System.out.println("�ȱ������������");
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
