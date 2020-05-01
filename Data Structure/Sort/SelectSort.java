package Sort;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 * 直接选择排序：
 * 最好       平均       最坏     空间
 * O(N)  O(N^2) O(N^2) O(1) 不稳定
 */
public class SelectSort {

	public static void main(String[] args) {
		int arr[]= {23,1,3,4,6,7,32,21,32,12,322};
		System.out.print("初始序列:");
		show(arr);
		selectsort(arr);
		System.out.print("最终排序:");
		show(arr);
	}
	//每次取出最小值放到最前边
	public static void selectsort(int []arr) {
		for(int j=0;j<arr.length;j++) {
			int min_index=j;
			int min=arr[j];
			for(int i=j;i<arr.length;i++) {
				if(min>arr[i]) {
					min=arr[i];
					min_index=i;  //记录最小值的位置
				}
			}
			//交换
			int temp=arr[j];
			arr[j]=arr[min_index];
			arr[min_index]=temp;
			System.out.print("第"+(j+1)+"次排序:");
			show(arr);

		}
	}
	
	public static void show(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

