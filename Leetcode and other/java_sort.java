package leetcode;
import java.util.*;
/**
 * �����뽵��
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class java_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer []a= new Integer[]{33,2,1,43,5,36,66};
		Arrays.sort(a);
		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
		System.out.println();
		//����
		Arrays.sort(a, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}	
		});
		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
	}

}
