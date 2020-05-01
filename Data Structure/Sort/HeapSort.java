package Sort;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 * 
 * 
 * 最好                平均                     最坏         空间
 * O(N*logN)  O(N*logN)   O(N*logN) O(1) 不稳定
 * 
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] tree = { 3, 6, 2, 1, 8, 11 };
		heap_sort(tree);
		for (int i = 0; i < tree.length; i++) {
			System.out.print(tree[i] + " ");
		}
	}

	public static void heapify(int tree[], int length, int i) {
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
	public static void bulid_heap(int[] tree) {
		int last_node = tree.length - 1;
		int parent_node = (last_node - 1) / 2;
		for (int i = parent_node; i >= 0; i--) {
			heapify(tree, tree.length, i);
		}
	}

	public static void heap_sort(int tree[]) {
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
