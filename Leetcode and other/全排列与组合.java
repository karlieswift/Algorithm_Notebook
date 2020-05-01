package leetcode;

import java.util.*;

public class 全排列与组合 {
 
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		System.out.println("指定数组全排列方法一");
		new FullPermutation().fullPermutation(arr);
		System.out.println("指定1--n全排列");
		new GeneratePermutation().generatePermutation(3);
		int[] arr1 = { 1, 2, 3 };
		System.out.println("指定数组全排列");
		new GeneratePermutation1().generatePermutation1(arr1);
		int[] arr2 = { 1, 2, 3, 4 };
		System.out.println("指定数组组合");
		new GeneratePermutation2().generatePermutation2(arr2, 2);
		System.out.println("指定1-n组合");
		new GeneratePermutation3().generatePermutation3(4, 2);

	}
}

/**
 * 全排列方法一
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月26日
 * @version "13.0.1"
 */
class FullPermutation {
	private void swap(int arr[], int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	/**
	 * 全排列方法一
	 * 
	 * @Function @param arr
	 */
	public void fullPermutation(int[] arr) {
		fullPermutation(arr, 0, arr.length - 1);
	}

	private void fullPermutation(int[] arr, int p, int q) {
		if (p == q) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} else {
			for (int i = p; i <= q; i++) {
				swap(arr, p, i);
				fullPermutation(arr, p + 1, q);
				swap(arr, p, i);
			}
		}
	}
}

/**
 * 对一个1--n的数进行全排列
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月26日
 * @version "13.0.1"
 */
class GeneratePermutation {
	/**
	 * 对一个1--n的数进行全排列
	 * 
	 * @Function @param n
	 */
	public void generatePermutation(int n) {
		int[] temp = new int[n];
		boolean hashtable[] = new boolean[n + 1];
		generatePermutation(0, n, temp, hashtable);
	}

	private void generatePermutation(int index, int n, int[] temp, boolean hashtable[]) {
		if (index == n) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (hashtable[i] == false) {
				temp[index] = i;
				hashtable[i] = true;
				generatePermutation(index + 1, n, temp, hashtable);
				hashtable[i] = false;
			}
		}

	}

}

/**
 * 对一个指定的数组进行全排列
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月26日
 * @version "13.0.1"
 */
class GeneratePermutation1 {
	/**
	 * 对一个指定的数组进行全排列
	 * 
	 * @Function @param arr
	 */
	public void generatePermutation1(int arr[]) {
		int[] temp = new int[arr.length];
		boolean hashtable[] = new boolean[arr.length];
		generatePermutation1(0, arr, temp, hashtable);
	}

	private void generatePermutation1(int index, int arr[], int[] temp, boolean hashtable[]) {
		if (index == arr.length) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (hashtable[i] == false) {
				temp[index] = arr[i];
				hashtable[i] = true;
				generatePermutation1(index + 1, arr, temp, hashtable);
				hashtable[i] = false;
			}
		}

	}

}

/**
 * 对指定数组进行组合
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月26日
 * @version "13.0.1"
 */
class GeneratePermutation2 {

	/**
	 * 对指定数组进行组合
	 * 
	 * @Function @param arr
	 * @Function @param k
	 */
	public void generatePermutation2(int arr[], int k) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		generatePermutation2(arr, k, 0, temp);
	}

	private void generatePermutation2(int[] arr, int k, int start, ArrayList<Integer> temp) {

		if (temp.size() == k) {
			System.out.println(temp);

			return;
		}

		for (int i = start; i < arr.length; i++) {
			temp.add(arr[i]);
			generatePermutation2(arr, k, i + 1, temp);
			temp.remove(temp.size() - 1);
		}
		return;

	}

}

/**
 * 对1--n数据进行组合
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月26日
 * @version "13.0.1"
 */
class GeneratePermutation3 {

	/**
	 * 对1--n数据进行组合
	 * 
	 * @Function @param arr
	 * @Function @param k
	 */
	public void generatePermutation3(int n, int k) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		generatePermutation3(n, k, 1, temp);
	}

	private void generatePermutation3(int n, int k, int start, ArrayList<Integer> temp) {
		if (temp.size() == k) {
			System.out.println(temp);

			return;
		}

		for (int i = start; i <= n - temp.size() + 1; i++) {//剪枝
//		for (int i = start; i <= n ; i++) {
			temp.add(i);
			generatePermutation3(n, k, i + 1, temp);
			temp.remove(temp.size() - 1);
		}
		return;

	}

}
