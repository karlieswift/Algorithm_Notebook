package leetcode;

import java.util.Arrays;

public class ��̬�滮Fibonacci {

	public static void main(String[] args) {

		int n=40;
		System.out.println("��ʽ��Fibonacci="+Fibonacci1(n));
		System.out.println("�ݹ�Fibonacci="+Fibonacci2(n)+" "+ n2);
		System.out.println("���仯����Fibonacci="+Fibonacci3(n)+" "+n3);
		System.out.println("��̬�滮Fibonacci="+Fibonacci4(n)+" "+ n4);
	}
//����һ��ʽ��
	public static int Fibonacci1(int n) {
		if (n == 0) {
			return 0;
		}
		double a_1 = Math.pow(5, 0.5);
		int result = (int) ((Math.pow((1 + a_1) / 2, n) - Math.pow((1 - a_1) / 2, n)) / a_1);
		return result;
	}

	static int n2=0;
//�������ݹ�
	public static int Fibonacci2(int n) {

		n2++;
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		return Fibonacci2(n - 2) + Fibonacci2(n - 1);
	}

	static int n3=0;
	//������ ���仯����ʱ�临�Ӷ� O(n)
	public  static int Fibonacci3(int n) {
	int meme[]=new int[n+1];
	Arrays.fill(meme, -1);
	return Fibonacci3(n, meme);
	}
	private static int Fibonacci3(int n,int []meme) {
		if(n==0) return 0;
		if(n==1) return 1;
		if(meme[n]==-1) {
			n3++;
			meme[n]=Fibonacci3(n-1,meme)+Fibonacci3(n-2,meme);
		}
		return meme[n];
	}
	
	
	
	
	static int n4=0;
	//����4 ��̬�滮ʱ�临�Ӷ� O(n)
		public static int Fibonacci4(int n) {
			int []meme=new int[n+1];
			meme[0]=0;
			meme[1]=1;
			for (int i = 2; i <= n; i++) {
				n4++;
				meme[i]=meme[i-1]+meme[i-2];
			}
			return meme[n];
		}
}


