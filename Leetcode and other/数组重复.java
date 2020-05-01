package leetcode;
/**
 * 散列方法
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月11日
 * @version "13.0.1"
 * 
 *          在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 *          也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *          例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 
 * 
 * 
 * 
 */
public class 数组重复 {

	public static void main(String[] args) {
		int []numbers={2,3,1,1,5,5,3};
		fun(numbers,numbers.length);
	}
	public static void fun(int []numbers,int n) {
		int arr[]=new int[n];
		for(int i=0;i<numbers.length;i++) {
			arr[numbers[i]]++;
		}
		for(int j=0;j<arr.length;j++) {
			if(arr[j]>1) {
				System.out.print(j+" ");
			}
		}
		
		 
	}
}