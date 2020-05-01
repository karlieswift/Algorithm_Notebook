package Sort;

import java.util.Arrays;

/**
原始数据：                     [12, 9, 33, 2, 311, 0, 7, 6]
第1次合并的下标0——>1[9, 12, 33, 2, 311, 0, 7, 6]
第2次合并的下标2——>3[9, 12, 2, 33, 311, 0, 7, 6]
第3次合并的下标0——>3[2, 9, 12, 33, 311, 0, 7, 6]
第4次合并的下标4——>5[2, 9, 12, 33, 0, 311, 7, 6]
第5次合并的下标6——>7[2, 9, 12, 33, 0, 311, 6, 7]
第6次合并的下标4——>7[2, 9, 12, 33, 0, 6, 7, 311]
第7次合并的下标0——>7[0, 2, 6, 7, 9, 12, 33, 311]
归并排序结果：             [0, 2, 6, 7, 9, 12, 33, 311]
*/
/**
 * 归并排序
 * 最好                平均                       最坏     空间
 * O(N*logN)  O(N*logN)   O(N*logN) O(1) 稳定
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月6日
 * @version "13.0.1"
 */
public class MergeSort {

	static int times = 1;

	public static void main(String[] args) {
		int arr[] = new int[] { 12, 9, 33, 2, 311, 0, 7, 6 };
		System.out.println("原始数据：                     " + Arrays.toString(arr));
		int[] temp = new int[arr.length];
		mergesort(arr, temp, 0, arr.length - 1);
		System.out.println("归并排序结果：             " + Arrays.toString(arr));
	}

	// 归并排序
	public static void mergesort(int[] arr, int[] temp, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(arr, temp, left, mid);// 递归左边
			mergesort(arr, temp, mid + 1, right);// 递归右边
			merge(arr, temp, left, mid, right);// 合并排序
		}

	}

	// 数组合并
	public static void merge(int[] arr, int[] temp, int left, int mid, int right) {
		// 因为要合两个数组，需要定义2个下标i,j
		int i = left;// 左边的数组开始位置
		int j = mid + 1;// 右边的数组开始位置
		int t = 0;// 定义临时数组temp的下标
		// 将2个数组的最小值加到temp数组里
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		// 将剩下的数组一次性加入temp
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		// 将临时数组temp放回arr数组，并不是每次多将所有数组复制，
		// 而是这次要合并的数组个数，例如第一次合并就合并2个数组，
		// 也就是复制2个数组,第2次是合并2次,,第三次是合并4次
		int templeft = left;
		t = 0;
		System.out.print("第" + (times++) + "次合并的下标" + templeft + "——>" + right);
		while (templeft <= right) {
			arr[templeft++] = temp[t++];
		}
		System.out.println(Arrays.toString(arr));

	}

}
