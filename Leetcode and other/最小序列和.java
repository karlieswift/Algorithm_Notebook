package leetcode;
import java.util.*;
public class ��С���к� {
	public static int fuction_1(int A[]) {  //��̬�滮dp[i]������A[i]��β����С���к�
		int []dp=new int [A.length];
		dp[0]=A[0];
		int max=dp[0];
		for(int i=1;i<A.length;i++) {
			dp[i]=Math.max(A[i], dp[i-1]+A[i]);
			if(dp[i]>max)  max=dp[i];
		} 
		return max;
	}	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		while(scan.hasNext()) {
			int number =scan.nextInt();
			int []a=new int[number];
			for(int i=0;i<number;i++) 
				a[i] =scan.nextInt();
			int max=fuction_1(a);
			System.out.println(max);			
		}
	}
}


