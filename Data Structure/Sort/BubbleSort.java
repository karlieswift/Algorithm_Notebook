package Sort;

/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��5��1��
 * @version "13.0.1"
 * 
 * 
 * ð������: 
 * ԭ���Ƚ��������ڵ�Ԫ�أ���ֵ���Ԫ�ؽ������Ҷˡ�
 *          
 * ���       ƽ��       �     �ռ�
 * O(N)  O(N^2) O(N^2) O(1) �ȶ�
 * 
 *          1��ð��������һ����ʱ�任�ռ�����򷽷���nСʱ��
 *          2�������ǰ�˳������б�����򣬻��߰���������б��˳�����ʱ�临�Ӷ�O(N^2)ֻ�Ǳ�ʾ�����������������
 *          3����õ���������ݱ��������򣬸��Ӷ�ΪO(n)
 * 
 */
public class BubbleSort {

	public static void main(String[] args) {
		int arr_1[] = { 23, 1, 3, 4, 6, 7 };
		System.out.println("�Ż�:");
		System.out.print("��ʼ����:");
		show(arr_1);
		bubblesort_1(arr_1);
		System.out.print("��������:");
		show(arr_1);
		System.out.println();

		System.out.println("���Ż�:");
		int arr_2[] = { 23, 1, 3, 4, 6, 7 };
		System.out.print("��ʼ����:");
		show(arr_2);
		bubblesort_2(arr_2);
		System.out.print("��������:");
		show(arr_2);
	}

	// �Ż�
	public static void bubblesort_1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					flag = true;
				}
			}

			if (flag == false)
				break;

			System.out.print("��" + (i + 1) + "������:");
			show(arr);
		}
	}

	// ���Ż�
	public static void bubblesort_2(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// boolean flag=false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					// flag=true;
				}
			}

			// if(flag==false) break;

			System.out.print("��" + (i + 1) + "������:");
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
