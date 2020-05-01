package Sort;

/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 * 
 * 
 * 冒泡排序: 
 * 原理：比较两个相邻的元素，将值大的元素交换至右端。
 *          
 * 最好       平均       最坏     空间
 * O(N)  O(N^2) O(N^2) O(1) 稳定
 * 
 *          1、冒泡排序是一种用时间换空间的排序方法，n小时好
 *          2、最坏情况是把顺序的排列变成逆序，或者把逆序的数列变成顺序，最差时间复杂度O(N^2)只是表示其操作次数的数量级
 *          3、最好的情况是数据本来就有序，复杂度为O(n)
 * 
 */
public class BubbleSort {

	public static void main(String[] args) {
		int arr_1[] = { 23, 1, 3, 4, 6, 7 };
		System.out.println("优化:");
		System.out.print("初始序列:");
		show(arr_1);
		bubblesort_1(arr_1);
		System.out.print("最终排序:");
		show(arr_1);
		System.out.println();

		System.out.println("非优化:");
		int arr_2[] = { 23, 1, 3, 4, 6, 7 };
		System.out.print("初始序列:");
		show(arr_2);
		bubblesort_2(arr_2);
		System.out.print("最终排序:");
		show(arr_2);
	}

	// 优化
	public static void bubblesort_1(int[] arr) {
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

			System.out.print("第" + (i + 1) + "次排序:");
			show(arr);
		}
	}

	// 非优化
	public static void bubblesort_2(int[] arr) {
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

			System.out.print("第" + (i + 1) + "次排序:");
			show(arr);
		}
	}

	public static void show(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
