package Sort;

import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 * 基数排序
 *   最好            平均                 最坏            空间
 * O(d(r+n)) O(d(r+n)) O(d(r+n))    O(r)   稳定
 * r代表关键字基数(0-9,所以r=10)，d代表关键字长度(就是几位数)，n代表关键字个数
 */
public class RadixSort {

	public static void main(String[] args) {
		Random random = new Random(6);
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(1000);
		}
		System.out.println("初始数组:"+Arrays.toString(arr));
		radixSort(arr);

	}

	public static void radixSort(int[] arr) {

		// 定义一个二维数组
		int bucket[][] = new int[10][arr.length];
		// 每个桶的元素的个数
		int[] bucketelementcounts = new int[arr.length];
		int maxvalue = arr[0];
		for (int h = 1; h < arr.length; h++) {
			if (maxvalue < arr[h])
			maxvalue = arr[h];
		}
		int length = ("" + maxvalue).length();

		for (int w = 1, p = 0; p < length; p++, w *= 10) {

			int index = 0;
			for (int i = 0; i < arr.length; i++) {
				int number = arr[i] / w % 10;
				bucket[number][bucketelementcounts[number]] = arr[i];
				bucketelementcounts[number]++;
			}
			for (int j = 0; j < arr.length; j++) {// 收集每个桶里的元素
				if (bucketelementcounts[j] != 0) {// bucketelementcounts[j]=第j个桶有几个元素
					for (int k = 0; k < bucketelementcounts[j]; k++) {
						arr[index++] = bucket[j][k];// 收集第j个桶的第k个元素
					}
					bucketelementcounts[j] = 0;
				}
			}
			System.out.println("第"+(p+1)+"次桶排序"+Arrays.toString(arr));
		}

	}
}
