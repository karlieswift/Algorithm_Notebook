package leetcode;
import java.util.Arrays;


/**
 * n-queens  �ݹ����
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class Nqueen {
	public static void main(String[] args) {
		
		new Queen().nqueen(8);

	}
}
 

class Queen  {
	static int count = 0;
	/**
	 * 
	 * 
	 * 00 01 02
	 * 10 11 12
	 * 20 21 22
	 * col[]������û�лʺ�
	 * d1[]�������Խ���û�лʺ�  �Խ��߾����±������ͬ
	 * d2[]�������Խ���û�лʺ� �Խ��߾����±������ͬ
	 * 
	 * @Function @param n
	 */
	public void nqueen(int n) {
		boolean[] col = new boolean[n];
		boolean[] d1 = new boolean[2 * n - 1];
		boolean[] d2 = new boolean[2 * n - 1];
		int arr[] = new int[n];// arr[i]=j �����i�д���ǵ�j���ʺ�
		nqueen(n, 0, col, d1, d2, arr);
	}

	/**
	 * 
	 * @Function @param n n��queen
	 * @Function @param index index=0�ӵ�һ�п�ʼ
	 * 
	 * 
	 */
	private void nqueen(int n, int index, boolean[] col, boolean[] d1, boolean[] d2, int[] arr) {
		if (n == index) {
			count++;
			System.out.println(n + "�ʺ�����ĵ�" + count + "�ַ���" + Arrays.toString(arr));
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (j == arr[i]) {
						System.out.print(1 + " ");
					} else {
						System.out.print(0 + " ");
					}

				}
				System.out.println();
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!col[i] && !d1[index + i] && !d2[index - i + n - 1]) {
				arr[index] = i;
				col[i] = true;
				d1[index + i] = true;
				d2[index - i + n - 1] = true;
				nqueen(n, index + 1, col, d1, d2, arr);
				col[i] = false;
				d1[index + i] = false;
				d2[index - i + n - 1] = false;
			}
		}
	}
}
