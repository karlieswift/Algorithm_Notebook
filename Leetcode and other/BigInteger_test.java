package leetcode;

import java.math.BigInteger;
/**
 * ����������
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class BigInteger_test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger big_1=new BigInteger("10000");
		BigInteger big_2=new BigInteger("100222222222222666666666666666666666666666200");
		System.out.println("�������ת��:"+new BigInteger("17",10).toString(2));//10001
		String str_1=big_1.toString();
		System.out.println("ת��Ϊ�ַ����Ƚ�:"+str_1.equals("10000"));  //return true
		System.out.println("�ӷ���"+big_1.add(big_2));  //�ӷ�
		System.out.println("������"+big_1.subtract(big_2));
		BigInteger big_3=new BigInteger("10");
		BigInteger big_4=new BigInteger("6");
		System.out.println("������"+big_1.divide(big_2));
		System.out.println("������"+big_2.divide(big_1));
		System.out.println("����(6/10)��"+big_4.divide(big_3));//0
		System.out.println("����(10/6)��"+big_3.divide(big_4));//1
		System.out.println("��ģ(10/6)��"+big_3.mod(big_4));//4
		System.out.println("�˷���"+big_1.multiply(big_2));
		System.out.println("���ֵ��"+big_1.max(big_2));
		System.out.println("��Сֵ��"+big_1.min(big_2));
		System.out.println("�ݴη���"+big_2.pow(6));
	}

}
