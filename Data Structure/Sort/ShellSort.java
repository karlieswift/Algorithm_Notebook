package Sort;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 * 
 * 希尔排序：
 * 先取一个小于n的整数d1作为第一个增量，把文件的全部记录分成d1个组。所有距离为dl的倍数的记录放在同一个组中。
 * 先在各组内进行直接插人排序；然后，取第二个增量d2<d1重复上述的分组和排序，
 * 直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
 * 
 * 最好       平均          最坏     空间
 * O(N)  O(N^1.3) O(N^2) O(1) 不稳定
 */
public class ShellSort {

	public static void main(String[] args) {
		int arr[] = { 23, 1, 3, 4, 6, 7, 32, 21, 32, 12, 322 };
		System.out.print("初始序列:");
		show(arr);
		shellsort(arr);
		System.out.print("最终排序:");
		show(arr);
	}

	//
	public static void shellsort(int[] arr) {
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
			System.out.print("第" + (times++) + "次排序:");
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
