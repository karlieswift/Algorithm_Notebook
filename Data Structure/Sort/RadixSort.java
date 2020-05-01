package Sort;

import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��5��1��
 * @version "13.0.1"
 * ��������
 *   ���            ƽ��                 �            �ռ�
 * O(d(r+n)) O(d(r+n)) O(d(r+n))    O(r)   �ȶ�
 * r����ؼ��ֻ���(0-9,����r=10)��d����ؼ��ֳ���(���Ǽ�λ��)��n����ؼ��ָ���
 */
public class RadixSort {

	public static void main(String[] args) {
		Random random = new Random(6);
		int arr[] = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(1000);
		}
		System.out.println("��ʼ����:"+Arrays.toString(arr));
		radixSort(arr);

	}

	public static void radixSort(int[] arr) {

		// ����һ����ά����
		int bucket[][] = new int[10][arr.length];
		// ÿ��Ͱ��Ԫ�صĸ���
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
			for (int j = 0; j < arr.length; j++) {// �ռ�ÿ��Ͱ���Ԫ��
				if (bucketelementcounts[j] != 0) {// bucketelementcounts[j]=��j��Ͱ�м���Ԫ��
					for (int k = 0; k < bucketelementcounts[j]; k++) {
						arr[index++] = bucket[j][k];// �ռ���j��Ͱ�ĵ�k��Ԫ��
					}
					bucketelementcounts[j] = 0;
				}
			}
			System.out.println("��"+(p+1)+"��Ͱ����"+Arrays.toString(arr));
		}

	}
}
