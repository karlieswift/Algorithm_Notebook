package Tree;
/**
 * 仅适用于完全二叉树
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年5月1日
 * @version "13.0.1"
 */
public class ArrayTree {
/*  仅适用于完全二叉树
 *      1
 *   2     3
 * 4  5  6   7
 * 
 * 先序遍历 1 2 4 5 3 6 7
 * 中序遍历 4 2 5 1 6 3 7
 * 后序遍历 4 5 2 6 7 3 1
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6,7};

		System.out.print("先序遍历：");
		prelist(arr,0);
		System.out.print("中序遍历：");
		inlist(arr,0);
		System.out.print("后序遍历：");
		postlist(arr,0);
	}

	//先序遍历
		public static void prelist(int arr[],int index) {
			if(index<arr.length) {
				System.out.print(arr[index]+" ");
				prelist(arr,index*2+1);
				prelist(arr,index*2+2);
			}
		}
		
	//中序遍历
	public static void inlist(int arr[],int index) {
		if(index<arr.length) {
			inlist(arr,index*2+1);
			System.out.print(arr[index]+" ");
			inlist(arr,index*2+2);
		}
	}
	//后序遍历
		public static void postlist(int arr[],int index) {
			if(index<arr.length) {
				postlist(arr,index*2+1);
				postlist(arr,index*2+2);
				System.out.print(arr[index]+" ");
			}
		}
}
