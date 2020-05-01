package Sort;

import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @Description: �����㷨���ܲ���
 * @author  karlieswift
 * @date 2020��5��1��
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

		System.out.println(str + "����ʱ�䣺" + (end - first) + " ");
	}
}

class BubbleSort {
	// �Ż�
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

	// ���Ż�
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
		// ����iΪ���ֵ���±�
		int max = i;
		int c1 = i * 2 + 1;// ��ڵ��±�
		int c2 = i * 2 + 2;// �ҽڵ��±�
		if (c1 < length && tree[max] < tree[c1]) {
			max = c1;
		}
		if (c2 < length && tree[max] < tree[c2]) {
			max = c2;
		}
		// ��max������i��ʱ��˵��3�ߵ����ֵ����ԭ����tree[i]
		// �򽻻�tree[i]��tree[max]
		if (max != i) {
			int temp = tree[i];
			tree[i] = tree[max];
			tree[max] = temp;
			heapify(tree, length, max);// ���µݹ�
		}

	}

	// ����
	private void bulid_heap(int[] tree) {
		int last_node = tree.length - 1;
		int parent_node = (last_node - 1) / 2;
		for (int i = parent_node; i >= 0; i--) {
			heapify(tree, tree.length, i);
		}
	}

	public void heap_sort(int tree[]) {
		bulid_heap(tree);
		// һ��ѭ������һ�ζ�����ÿ�ν����ĸ������ֵ���������һ���ڵ�
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
			int temp = arr[i]; // Ŀǰ��Ԫ�� һ���ƶ�Ԫ��ʱ�ᱻ���ǣ�������temp��¼
			int insert_index = i - 1; // �Ӹ�Ԫ�ص�ǰһ����ʼ�Ƚ�
			while (insert_index >= 0 && arr[insert_index] > temp) {
				arr[insert_index + 1] = arr[insert_index]; // �ƶ�
				insert_index--;
			}
			// �ҵ���һ����tempС��Ԫ�أ�����Ϊinsert_index��
			// ���Բ��뵽insert_index+1��λ��
			arr[insert_index + 1] = temp;

		}
	}

}

class MergeSort {

	// �鲢����
	public void mergesort(int[] arr) {
		int[] temp = new int[arr.length];
		mergesort(arr, temp, 0, arr.length - 1);
	}

	private void mergesort(int[] arr, int[] temp, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(arr, temp, left, mid);// �ݹ����
			mergesort(arr, temp, mid + 1, right);// �ݹ��ұ�
			merge(arr, temp, left, mid, right);// �ϲ�����
		}

	}

	// ����ϲ�
	private void merge(int[] arr, int[] temp, int left, int mid, int right) {
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

	// ÿ��ȡ����Сֵ�ŵ���ǰ��
	public void selectsort(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			int min_index = j;
			int min = arr[j];
			for (int i = j; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
					min_index = i; // ��¼��Сֵ��λ��
				}
			}
			// ����
			int temp = arr[j];
			arr[j] = arr[min_index];
			arr[min_index] = temp;
		}
	}
}

class ShellSort {

	public void shellsort(int[] arr) {
		int times = 1; // ��¼�������
		// ��һ��forѭ���ǽ������Ϊ��������
		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) { // gap������
			// ͨ����һ��forѭ���õ���gap���з��飬�����forѭ���ǶԵõ������������
			for (int i = gap; i < arr.length; i++) { // ��gap��ʼ

				int j = i;
				int temp = arr[j];
				// whileѭ���Ƕ�����һ���������������
				while (j - gap >= 0 && temp < arr[j - gap]) { // temp<arr[j-gap]����;temp>arr[j-gap]����
					arr[j] = arr[j - gap]; // �����ƶ�Ԫ��
					j = j - gap;
				}
				arr[j] = temp;// �����滻
			}

		}

	}

}

class RadixSort {

	public void radixSort(int[] arr) {
		// ����һ����ά����
		int bucket[][] = new int[10][arr.length];
		// ÿ��Ͱ��Ԫ�صĸ���
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
			for (int j = 0; j < arr.length; j++) {// �ռ�ÿ��Ͱ���Ԫ��
				if (bucketelementcounts[j] != 0) {// bucketelementcounts[j]=��j��Ͱ�м���Ԫ��
					for (int k = 0; k < bucketelementcounts[j]; k++) {
						arr[index++] = bucket[j][k];// �ռ���j��Ͱ�ĵ�k��Ԫ��
					}
					bucketelementcounts[j] = 0;
				}
			}
		}

	}
}
*/
