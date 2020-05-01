package Sort;

import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��5��1��
 * @version "13.0.1"
 * ���ŵ�����¿ռ临�Ӷ�Ϊ��O(logn)  ��ÿһ�ζ�ƽ����������
 * ��������¿ռ临�Ӷ�Ϊ��O( n )      ���˻�Ϊð���������� 
 * ���                      ƽ��            �              �ռ�
 * O(N*logN)  O(N*logN)   O(N^2) O(logN)-O(n)  ���ȶ� 
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
