package Sort;

import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @Description: 排序算法性能测试
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 */
/*
public class SortTest {
	public static void main(String[] args) {

		Random random = new Random();
		long first, end;

		int length = 10;
		int arr1[] = new int[length];
		int arr2[] = new int[length];
		int arr3[] = new int[length];
		int arr4[] = new int[length];
		int arr5[] = new int[length];
		int arr6[] = new int[length];
		int arr7[] = new int[length];
		int arr8[] = new int[length];

		for (int i = 0; i < length; i++) {
			int n = random.nextInt(100);
			arr1[i] = n;
			arr2[i] = n;
			arr3[i] = n;
			arr4[i] = n;
			arr5[i] = n;
			arr6[i] = n;
			arr7[i] = n;
			arr8[i] = n;
		}

		first = System.currentTimeMillis();
		BubbleSort bubbleSort = new BubbleSort();
		first = System.currentTimeMillis();
		bubbleSort.bubblesort_1(arr1);
		end = System.currentTimeMillis();
		times("BubbleSort", first, end);
		System.out.println(Arrays.toString(arr1));

		first = System.currentTimeMillis();
		HeapSort heapSort = new HeapSort();
		first = System.currentTimeMillis();
		heapSort.heap_sort(arr2);
		end = System.currentTimeMillis();
		times("HeapSort", first, end);
		System.out.println(Arrays.toString(arr2));

		first = System.currentTimeMillis();
		InsertSort insertSort = new InsertSort();
		first = System.currentTimeMillis();
		insertSort.insertsort(arr3);
		end = System.currentTimeMillis();
		times("InsertSort", first, end);
		System.out.println(Arrays.toString(arr3));

		first = System.currentTimeMillis();
		MergeSort mergeSort = new MergeSort();
		first = System.currentTimeMillis();
		mergeSort.mergesort(arr4);
		end = System.currentTimeMillis();
		times("MergeSort", first, end);
		System.out.println(Arrays.toString(arr4));

		first = System.currentTimeMillis();
		QuickSort quickSort = new QuickSort();
		first = System.currentTimeMillis();
		quickSort.quickSort(arr5);
		end = System.currentTimeMillis();
		times("QuickSort", first, end);
		System.out.println(Arrays.toString(arr5));

		first = System.currentTimeMillis();
		SelectSort selectSort = new SelectSort();
		first = System.currentTimeMillis();
		selectSort.selectsort(arr6);
		end = System.currentTimeMillis();
		times("SelectSort", first, end);
		System.out.println(Arrays.toString(arr6));

		first = System.currentTimeMillis();
		ShellSort shellSort = new ShellSort();
		first = System.currentTimeMillis();
		shellSort.shellsort(arr7);
		end = System.currentTimeMillis();
		times("ShellSort", first, end);
		System.out.println(Arrays.toString(arr7));

		first = System.currentTimeMillis();
		RadixSort radixSort = new RadixSort();
		first = System.currentTimeMillis();
		radixSort.radixSort(arr8);
		end = System.currentTimeMillis();
		times("RadixSort", first, end);
		System.out.println(Arrays.toString(arr8));

	}

	public static void times(String str, long first, long end) {

		System.out.println(str + "排序时间：" + (end - first) + " ");
	}
}

class BubbleSort {
	// 优化
	public void bubblesort_1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}

			if (flag == false)
				break;
		}
	}

	// 非优化
	public void bubblesort_2(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// boolean flag=false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					// flag=true;
				}
			}

			// if(flag==false) break;

		}
	}

}

class HeapSort {

	private void heapify(int tree[], int length, int i) {
		if (i >= length) {
			return;
		}
		// 假设i为最大值的下标
		int max = i;
		int c1 = i * 2 + 1;// 左节点下标
		int c2 = i * 2 + 2;// 右节点下标
		if (c1 < length && tree[max] < tree[c1]) {
			max = c1;
		}
		if (c2 < length && tree[max] < tree[c2]) {
			max = c2;
		}
		// 当max不等于i的时候，说明3者的最大值不是原来的tree[i]
		// 则交换tree[i]与tree[max]
		if (max != i) {
			int temp = tree[i];
			tree[i] = tree[max];
			tree[max] = temp;
			heapify(tree, length, max);// 往下递归
		}

	}

	// 建堆
	private void bulid_heap(int[] tree) {
		int last_node = tree.length - 1;
		int parent_node = (last_node - 1) / 2;
		for (int i = parent_node; i >= 0; i--) {
			heapify(tree, tree.length, i);
		}
	}

	public void heap_sort(int tree[]) {
		bulid_heap(tree);
		// 一次循环代表一次堆排序，每次将树的根即最大值交换到最后一个节点
		for (int i = tree.length - 1; i >= 0; i--) {
			int temp = tree[0];
			tree[0] = tree[i];
			tree[i] = temp;
			heapify(tree, i, 0);
		}
	}
}

class InsertSort {

	public void insertsort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i]; // 目前的元素 一会移动元素时会被覆盖，所以用temp记录
			int insert_index = i - 1; // 从该元素的前一个开始比较
			while (insert_index >= 0 && arr[insert_index] > temp) {
				arr[insert_index + 1] = arr[insert_index]; // 移动
				insert_index--;
			}
			// 找到第一个比temp小的元素，所以为insert_index，
			// 所以插入到insert_index+1的位置
			arr[insert_index + 1] = temp;

		}
	}

}

class MergeSort {

	// 归并排序
	public void mergesort(int[] arr) {
		int[] temp = new int[arr.length];
		mergesort(arr, temp, 0, arr.length - 1);
	}

	private void mergesort(int[] arr, int[] temp, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(arr, temp, left, mid);// 递归左边
			mergesort(arr, temp, mid + 1, right);// 递归右边
			merge(arr, temp, left, mid, right);// 合并排序
		}

	}

	// 数组合并
	private void merge(int[] arr, int[] temp, int left, int mid, int right) {
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

		while (templeft <= right) {
			arr[templeft++] = temp[t++];
		}

	}

}

class QuickSort {

	public void quickSort(int arr[]) {
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int arr[], int left, int right) {
		int pivot;
		if (left < right) {
			pivot = partition(arr, left, right);
			quickSort(arr, left, pivot - 1);
			quickSort(arr, pivot + 1, right);
		}

	}

	private int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= pivot) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] <= pivot) {
				left++;
			}
			arr[right] = arr[left];
			arr[left] = pivot;
		}

		return left;
	}
}

class SelectSort {

	// 每次取出最小值放到最前边
	public void selectsort(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			int min_index = j;
			int min = arr[j];
			for (int i = j; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
					min_index = i; // 记录最小值的位置
				}
			}
			// 交换
			int temp = arr[j];
			arr[j] = arr[min_index];
			arr[min_index] = temp;
		}
	}
}

class ShellSort {

	public void shellsort(int[] arr) {
		int times = 1; // 记录排序次数
		// 第一个for循环是将数组分为几次排序
		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) { // gap代表步长
			// 通过第一个for循环得到的gap进行分组，下面的for循环是对得到的组进行排序
			for (int i = gap; i < arr.length; i++) { // 从gap开始

				int j = i;
				int temp = arr[j];
				// while循环是对其中一个组进行组内排序
				while (j - gap >= 0 && temp < arr[j - gap]) { // temp<arr[j-gap]升序;temp>arr[j-gap]降序
					arr[j] = arr[j - gap]; // 组内移动元素
					j = j - gap;
				}
				arr[j] = temp;// 插入替换
			}

		}

	}

}

class RadixSort {

	public void radixSort(int[] arr) {
		// 定义一个二维数组
		int bucket[][] = new int[10][arr.length];
		// 每个桶的元素的个数
		int[] bucketelementcounts = new int[arr.length];
		int maxvalue = arr[0];
		for (int h = 1; h < arr.length; h++) {
			if (maxvalue < arr[h])
				maxvalue = arr[h];
		}
		int length = ("" + maxvalue).length();

		for (int w = 1, p = 0; p < length; p++, w *= 10) {

			int index = 0;
			for (int i = 0; i < arr.length; i++) {
				int number = arr[i] / w % 10;
				bucket[number][bucketelementcounts[number]] = arr[i];
				bucketelementcounts[number]++;
			}
			for (int j = 0; j < arr.length; j++) {// 收集每个桶里的元素
				if (bucketelementcounts[j] != 0) {// bucketelementcounts[j]=第j个桶有几个元素
					for (int k = 0; k < bucketelementcounts[j]; k++) {
						arr[index++] = bucket[j][k];// 收集第j个桶的第k个元素
					}
					bucketelementcounts[j] = 0;
				}
			}
		}

	}
}
*/
