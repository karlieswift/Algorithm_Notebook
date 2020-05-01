package Sort;

import java.util.Arrays;

/**
ԭʼ���ݣ�                     [12, 9, 33, 2, 311, 0, 7, 6]
��1�κϲ����±�0����>1[9, 12, 33, 2, 311, 0, 7, 6]
��2�κϲ����±�2����>3[9, 12, 2, 33, 311, 0, 7, 6]
��3�κϲ����±�0����>3[2, 9, 12, 33, 311, 0, 7, 6]
��4�κϲ����±�4����>5[2, 9, 12, 33, 0, 311, 7, 6]
��5�κϲ����±�6����>7[2, 9, 12, 33, 0, 311, 6, 7]
��6�κϲ����±�4����>7[2, 9, 12, 33, 0, 6, 7, 311]
��7�κϲ����±�0����>7[0, 2, 6, 7, 9, 12, 33, 311]
�鲢��������             [0, 2, 6, 7, 9, 12, 33, 311]
*/
/**
 * �鲢����
 * ���                ƽ��                       �     �ռ�
 * O(N*logN)  O(N*logN)   O(N*logN) O(1) �ȶ�
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��6��
 * @version "13.0.1"
 */
public class MergeSort {

	static int times = 1;

	public static void main(String[] args) {
		int arr[] = new int[] { 12, 9, 33, 2, 311, 0, 7, 6 };
		System.out.println("ԭʼ���ݣ�                     " + Arrays.toString(arr));
		int[] temp = new int[arr.length];
		mergesort(arr, temp, 0, arr.length - 1);
		System.out.println("�鲢��������             " + Arrays.toString(arr));
	}

	// �鲢����
	public static void mergesort(int[] arr, int[] temp, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(arr, temp, left, mid);// �ݹ����
			mergesort(arr, temp, mid + 1, right);// �ݹ��ұ�
			merge(arr, temp, left, mid, right);// �ϲ�����
		}

	}

	// ����ϲ�
	public static void merge(int[] arr, int[] temp, int left, int mid, int right) {
		// ��ΪҪ���������飬��Ҫ����2���±�i,j
		int i = left;// ��ߵ����鿪ʼλ��
		int j = mid + 1;// �ұߵ����鿪ʼλ��
		int t = 0;// ������ʱ����temp���±�
		// ��2���������Сֵ�ӵ�temp������
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		// ��ʣ�µ�����һ���Լ���temp
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		// ����ʱ����temp�Ż�arr���飬������ÿ�ζཫ�������鸴�ƣ�
		// �������Ҫ�ϲ�����������������һ�κϲ��ͺϲ�2�����飬
		// Ҳ���Ǹ���2������,��2���Ǻϲ�2��,,�������Ǻϲ�4��
		int templeft = left;
		t = 0;
		System.out.print("��" + (times++) + "�κϲ����±�" + templeft + "����>" + right);
		while (templeft <= right) {
			arr[templeft++] = temp[t++];
		}
		System.out.println(Arrays.toString(arr));

	}

}
