package leetcode;

import java.util.Arrays;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 * 
 * ����:
{1,2,4,6,3,5}

��Ӧ���Ӧ��Ϊ:

[1, 3, 5, 2, 4, 6]
 
 ������
[1, 2, 4, 6, 3, 5]
--------------------
[1, 2, 4, 3, 5, 6]
[1, 2, 3, 5, 4, 6]
[1, 3, 5, 2, 4, 6]
[1, 3, 5, 2, 4, 6]
--------------------
[1, 3, 5, 2, 4, 6]

 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��27��
 * @version "13.0.1"
 */
public class ��������˳��ʹ����λ��ż��ǰ�� {
	public static void main(String[] args) {
		int arr[]= {1,2,4,6,3,5};
		System.out.println(Arrays.toString(arr));
		System.out.println("--------------------");
		reOrderArray(arr);
		System.out.println("--------------------");
		System.out.println(Arrays.toString(arr));
	}
	 
	public static void reOrderArray(int[] arr) {
		int temp;
		 
		for(int i=0;i<arr.length;i++) {//������ð�����򣬽���
			boolean flag=true;
			for(int j=0;j<arr.length-1;j++) {//�����0��ʼ,��Ϊֻ�������ڵ�2����
				if(arr[j]%2==0 && arr[j+1]%2==1) {
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					flag=false;
				}
			}
			System.out.println(Arrays.toString(arr));
			if(flag==true) {
				break;
			}
		}		
	}
}
