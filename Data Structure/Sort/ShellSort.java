package Sort;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��5��1��
 * @version "13.0.1"
 * 
 * ϣ������
 * ��ȡһ��С��n������d1��Ϊ��һ�����������ļ���ȫ����¼�ֳ�d1���顣���о���Ϊdl�ı����ļ�¼����ͬһ�����С�
 * ���ڸ����ڽ���ֱ�Ӳ�������Ȼ��ȡ�ڶ�������d2<d1�ظ������ķ��������
 * ֱ����ȡ������dt=1(dt<dt-l<��<d2<d1)�������м�¼����ͬһ���н���ֱ�Ӳ�������Ϊֹ��
 * 
 * ���       ƽ��          �     �ռ�
 * O(N)  O(N^1.3) O(N^2) O(1) ���ȶ�
 */
public class ShellSort {

	public static void main(String[] args) {
		int arr[] = { 23, 1, 3, 4, 6, 7, 32, 21, 32, 12, 322 };
		System.out.print("��ʼ����:");
		show(arr);
		shellsort(arr);
		System.out.print("��������:");
		show(arr);
	}

	//
	public static void shellsort(int[] arr) {
		int times = 1; // ��¼�������
		// ��һ��forѭ���ǽ������Ϊ��������
		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) { // gap������
			// ͨ����һ��forѭ���õ���gap���з��飬�����forѭ���ǶԵõ������������
			for (int i = gap; i < arr.length; i++) { // ��gap��ʼ

				int j = i;
				int temp = arr[j];
				// whileѭ���Ƕ�����һ���������������
				while (j - gap >= 0 && temp < arr[j - gap]) { // temp<arr[j-gap]����;temp>arr[j-gap]����
					arr[j] = arr[j - gap]; // �����ƶ�Ԫ��
					j = j - gap;
				}
				arr[j] = temp;// �����滻
			}
			System.out.print("��" + (times++) + "������:");
			show(arr);
		}

	}

	public static void show(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
