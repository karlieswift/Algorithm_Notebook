package Sort;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��5��1��
 * @version "13.0.1"
 * 
 * ֱ�Ӳ�������
 * ���       ƽ��          �     �ռ�
 * O(N)  O(N^2)   O(N^2) O(1)  �ȶ�
 */
public class InsertSort {

	public static void main(String[] args) {
		int arr[]= {12,3,60,61,7,32,21,32,12,322};
		System.out.print("��ʼ����:");
		show(arr);
		insertsort(arr);
		System.out.print("��������:");
		show(arr);
	}
	
	public static void insertsort(int []arr) {
		for(int i=1;i<arr.length;i++) {
			int temp=arr[i];  //Ŀǰ��Ԫ�� һ���ƶ�Ԫ��ʱ�ᱻ���ǣ�������temp��¼
			int insert_index=i-1; //�Ӹ�Ԫ�ص�ǰһ����ʼ�Ƚ�
			while(insert_index>=0 && arr[insert_index]>temp) {
				arr[insert_index+1]=arr[insert_index];  //�ƶ�
				insert_index--;
			}
			//�ҵ���һ����tempС��Ԫ�أ�����Ϊinsert_index��
			//���Բ��뵽insert_index+1��λ��
			arr[insert_index+1]=temp;  
			
			System.out.print("��"+(i)+"������:");
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

