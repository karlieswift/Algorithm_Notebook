package leetcode;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 用例:
{1,2,4,6,3,5}

对应输出应该为:

[1, 3, 5, 2, 4, 6]
 
 程序结果
[1, 2, 4, 6, 3, 5]
--------------------
[1, 2, 4, 3, 5, 6]
[1, 2, 3, 5, 4, 6]
[1, 3, 5, 2, 4, 6]
[1, 3, 5, 2, 4, 6]
--------------------
[1, 3, 5, 2, 4, 6]

 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月27日
 * @version "13.0.1"
 */
public class 调整数组顺序使奇数位于偶数前面 {
	public static void main(String[] args) {
		int arr[]= {1,2,4,6,3,5};
		System.out.println(Arrays.toString(arr));
		System.out.println("--------------------");
		reOrderArray(arr);
		System.out.println("--------------------");
		System.out.println(Arrays.toString(arr));
	}
	 
	public static void reOrderArray(int[] arr) {
		int temp;
		 
		for(int i=0;i<arr.length;i++) {//类似于冒泡排序，交换
			boolean flag=true;
			for(int j=0;j<arr.length-1;j++) {//这里从0开始,因为只交换相邻的2个，
				if(arr[j]%2==0 && arr[j+1]%2==1) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=false;
				}
			}
			System.out.println(Arrays.toString(arr));
			if(flag==true) {
				break;
			}
		}		
	}
}
