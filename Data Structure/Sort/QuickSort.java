package Sort;

import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 * 最优的情况下空间复杂度为：O(logn)  ；每一次都平分数组的情况
 * 最差的情况下空间复杂度为：O( n )      ；退化为冒泡排序的情况 
 * 最好                      平均            最坏              空间
 * O(N*logN)  O(N*logN)   O(N^2) O(logN)-O(n)  不稳定 
 */
public class QuickSort {
	public static void main(String[] args) {

 	

		Random random=new Random(1);
		long first,end;
		 
		int arr[]=new int[20];
		for(int i=0;i<arr.length;i++) {
			arr[i]=random.nextInt(100);
		}
		System.out.println(Arrays.toString(arr));
	 quickSort(arr);
	
	 

	}

	public static void quickSort(int arr[]) {
		quickSort(arr,0,arr.length-1);
	}
	public static void quickSort(int arr[],int left,int right) {
		int pivot;
		if(left<right) {
			pivot=partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot+1, right);
		}
		
	}
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[left];
		
		while (left<right) {
			while (left < right && arr[right] >= pivot) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] <=pivot) {
				left++;
			}
			arr[right] = arr[left];
			arr[left] = pivot;
		}
		System.out.println(Arrays.toString(arr));
		return left;
	}
}
