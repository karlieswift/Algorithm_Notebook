package Tree;
/**
 * ����������ȫ������
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��5��1��
 * @version "13.0.1"
 */
public class ArrayTree {
/*  ����������ȫ������
 *      1
 *   2     3
 * 4  5  6   7
 * 
 * ������� 1 2 4 5 3 6 7
 * ������� 4 2 5 1 6 3 7
 * ������� 4 5 2 6 7 3 1
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6,7};

		System.out.print("���������");
		prelist(arr,0);
		System.out.print("���������");
		inlist(arr,0);
		System.out.print("���������");
		postlist(arr,0);
	}

	//�������
		public static void prelist(int arr[],int index) {
			if(index<arr.length) {
				System.out.print(arr[index]+" ");
				prelist(arr,index*2+1);
				prelist(arr,index*2+2);
			}
		}
		
	//�������
	public static void inlist(int arr[],int index) {
		if(index<arr.length) {
			inlist(arr,index*2+1);
			System.out.print(arr[index]+" ");
			inlist(arr,index*2+2);
		}
	}
	//�������
		public static void postlist(int arr[],int index) {
			if(index<arr.length) {
				postlist(arr,index*2+1);
				postlist(arr,index*2+2);
				System.out.print(arr[index]+" ");
			}
		}
}
