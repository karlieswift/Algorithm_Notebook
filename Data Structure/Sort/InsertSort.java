package Sort;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 * 
 * 直接插入排序
 * 最好       平均          最坏     空间
 * O(N)  O(N^2)   O(N^2) O(1)  稳定
 */
public class InsertSort {

	public static void main(String[] args) {
		int arr[]= {12,3,60,61,7,32,21,32,12,322};
		System.out.print("初始序列:");
		show(arr);
		insertsort(arr);
		System.out.print("最终排序:");
		show(arr);
	}
	
	public static void insertsort(int []arr) {
		for(int i=1;i<arr.length;i++) {
			int temp=arr[i];  //目前的元素 一会移动元素时会被覆盖，所以用temp记录
			int insert_index=i-1; //从该元素的前一个开始比较
			while(insert_index>=0 && arr[insert_index]>temp) {
				arr[insert_index+1]=arr[insert_index];  //移动
				insert_index--;
			}
			//找到第一个比temp小的元素，所以为insert_index，
			//所以插入到insert_index+1的位置
			arr[insert_index+1]=temp;  
			
			System.out.print("第"+(i)+"次排序:");
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

