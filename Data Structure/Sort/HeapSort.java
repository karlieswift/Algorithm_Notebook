package Sort;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��5��1��
 * @version "13.0.1"
 * 
 * 
 * ���                ƽ��                     �         �ռ�
 * O(N*logN)  O(N*logN)   O(N*logN) O(1) ���ȶ�
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
	public static void bulid_heap(int[] tree) {
		int last_node = tree.length - 1;
		int parent_node = (last_node - 1) / 2;
		for (int i = parent_node; i >= 0; i--) {
			heapify(tree, tree.length, i);
		}
	}

	public static void heap_sort(int tree[]) {
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
