package Sreach;
/**
 * BST
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 */
public class BinarySearch {

	public static void main(String[] args) {
		int []arr= {1,12,6,6,6,6,6,6,6,6,6,6,9,11,66,66,666,6666};
		int index_1=BinarySearch_1(arr, 0, arr.length-1, 1);
		System.out.println(index_1);
		int index_2=BinarySearch_2(arr, 0, arr.length-1, 1);
		System.out.println(index_2);
		int n=counts(arr, 0, arr.length-1, 6);
		System.out.println(n);
	}

	//递归二分查找
	public static int BinarySearch_1(int []arr,int left,int right,int data) {
		if(right<left)
			return -1;
		int mid=(left+right)/2;
		if(arr[mid]<data) {
			return BinarySearch_1(arr,mid+1,right,data);
		}else if(arr[mid]>data) {
			return BinarySearch_1(arr,left,mid-1,data);
		}else {
			return mid;
		}
	}
	
	//非递归二分查找
	public static int BinarySearch_2(int []arr,int left,int right,int data) {
		while(left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==data) {
				return mid;
			}
			else if(arr[mid]<data){
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}	
		return -1;
		}
	
	//查找一个数出现的次数
	public static int counts(int []arr,int left,int right,int data) {
		
		while(left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==data) {
				int n=1;
				int index=mid+1;
				while(index<arr.length && arr[index]==data) {
					n++;
					index++;
				}
				index=mid-1;
				while(index>=0 && arr[index]==data) {
					n++;
					index--;
				}
				return n;
			}
			else if(arr[mid]<data){
				left=mid+1;
			}
			else {
				right=mid-1;
			}
		}	
		return 0;
		}
}
