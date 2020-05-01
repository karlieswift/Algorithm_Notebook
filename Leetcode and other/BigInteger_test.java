package leetcode;

import java.math.BigInteger;
/**
 * 大整数测试
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class BigInteger_test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger big_1=new BigInteger("10000");
		BigInteger big_2=new BigInteger("100222222222222666666666666666666666666666200");
		System.out.println("任意进制转化:"+new BigInteger("17",10).toString(2));//10001
		String str_1=big_1.toString();
		System.out.println("转化为字符串比较:"+str_1.equals("10000"));  //return true
		System.out.println("加法："+big_1.add(big_2));  //加法
		System.out.println("减法："+big_1.subtract(big_2));
		BigInteger big_3=new BigInteger("10");
		BigInteger big_4=new BigInteger("6");
		System.out.println("除法："+big_1.divide(big_2));
		System.out.println("除法："+big_2.divide(big_1));
		System.out.println("除法(6/10)："+big_4.divide(big_3));//0
		System.out.println("除法(10/6)："+big_3.divide(big_4));//1
		System.out.println("求模(10/6)："+big_3.mod(big_4));//4
		System.out.println("乘法："+big_1.multiply(big_2));
		System.out.println("最大值："+big_1.max(big_2));
		System.out.println("最小值："+big_1.min(big_2));
		System.out.println("幂次方："+big_2.pow(6));
	}

}
