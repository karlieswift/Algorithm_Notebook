package leetcode;
/**
 * ɢ�з���
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��11��
 * @version "13.0.1"
 * 
 *          ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
 *          Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
 *          ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2��
 * 
 * 
 * 
 * 
 */
public class �����ظ� {

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