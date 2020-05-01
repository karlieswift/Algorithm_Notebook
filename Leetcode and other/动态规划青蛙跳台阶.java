package leetcode;

import java.util.Arrays;
/**
 * �������
 * 1-�ݹ鱩������ JumpFloor_1(int target) 
 * 2-�ݹ���仯����JumpFloor_2(int target) 
 * 3-��̬�滮JumpFloor_3(int target) 
 * 
 * ��һ�⣺
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n
 * ����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 * ˼·��
 * �ݹ鹫ʽ����Ϊ������f(n)ʱ�������ֿ�������fn,��f(n-1)�������ģ�Ҳ���ߴ�f(n-2)ֱ��������
 * ����f(n)=f(n-1)+f(n-2),�ҵ����ƹ�ϵ
 * ��������������̨�׵���1 һ�� ̨��==2������
 * 
 * 
 * �ڶ��⣺JumpFloor_4(int target) 
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 * �����������һ��n����̨���ܹ��ж�����������
 * ˼·��
   f(1)=1,f(2)=2, f(n) =f(n-1)+f(n-2)+...+f(2)+f(1) f(n-1)=f(n-2)+...+f(2)+f(1)
   f(n)=f(n-1)+f(n-1) =2*f(n-1) =2*[2*f(n-2)] =2^2*f(n-2) =2^3*f(n-3)
       =2^(n-1)*f(1) =2^(n-1)
       
       
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��27��
 * @version "13.0.1"
 */
public class ��̬�滮������̨�� {
	public static void main(String[] args) {
		System.out.println(JumpFloor_1(6));
		System.out.println(JumpFloor_2(6));
		System.out.println(JumpFloor_3(6));
		System.out.println(JumpFloor_4(6));
	}

    //�ݹ�
	public static int JumpFloor_1(int target) { // һ����1������2��̨��
		if (target == 1)
			return 1;
		if (target == 2)
			return 2;

		return JumpFloor_1(target - 1) + JumpFloor_1(target - 2);
	}

	// ���仯����
	public static int JumpFloor_2(int n) {
		int[] meme = new int[n + 1];
		Arrays.fill(meme, -1);
		return JumpFloor_2(n, meme);
	}

	private static int JumpFloor_2(int target, int[] meme) { // һ����1������2��̨��
		meme[1] = 1;
		meme[2] = 2;
		if (meme[target] == -1) {//���Ѿ������ֱ��return
			meme[target] = JumpFloor_2(target - 1, meme) + JumpFloor_2(target - 2, meme);
		}

		return meme[target];

	}

	/**
	 * ��̬�滮
	 * @Function @param target
	 * @Function @return
	 */
	public static int JumpFloor_3(int target) { // һ����1������2��̨��
		int[] meme = new int[target + 1];
		meme[0] = 1;
		meme[1] = 1;
		for (int i = 2; i <= target; i++) {
			meme[i] = meme[i - 1] + meme[i - 2];
		}
		return meme[target];

	}
/**
 * �ڶ���
 * һ�ο����� 1����targetge ��̨��
 * @Function @param target
 * @Function @return
 */
	public static int JumpFloor_4(int target) { // һ�ο����� 1����targetge ��̨��
		/*
		 * f(1)=1,f(2)=2, f(n) =f(n-1)+f(n-2)+...+f(2)+f(1) f(n-1)=f(n-2)+...+f(2)+f(1)
		 * f(n)=f(n-1)+f(n-1) =2*f(n-1) =2*[2*f(n-2)] =2^2*f(n-2) =2^3*f(n-3)
		 * =2^(n-1)*f(1) =2^(n-1)
		 */
		return 1 << (target - 1);
	}

}
