package Sort;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��5��1��
 * @version "13.0.1"
 * ֱ��ѡ������
 * ���       ƽ��       �     �ռ�
 * O(N)  O(N^2) O(N^2) O(1) ���ȶ�
 */
public class SelectSort {

	public static void main(String[] args) {
		int arr[]= {23,1,3,4,6,7,32,21,32,12,322};
		System.out.print("��ʼ����:");
		show(arr);
		selectsort(arr);
		System.out.print("��������:");
		show(arr);
	}
	//ÿ��ȡ����Сֵ�ŵ���ǰ��
	public static void selectsort(int []arr) {
		for(int j=0;j<arr.length;j++) {
			int min_index=j;
			int min=arr[j];
			for(int i=j;i<arr.length;i++) {
				if(min>arr[i]) {
					min=arr[i];
					min_index=i;  //��¼��Сֵ��λ��
				}
			}
			//����
			int temp=arr[j];
			arr[j]=arr[min_index];
			arr[min_index]=temp;
			System.out.print("��"+(j+1)+"������:");
			show(arr);

		}
	}
	
	public static void show(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}

