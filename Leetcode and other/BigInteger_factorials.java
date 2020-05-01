package leetcode;

import java.math.BigInteger;

/**
 * �������׳�
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class BigInteger_factorials {
	public static void main(String[] args) {
		System.out.println(biginteger_factorials(59));
	}

	public static BigInteger biginteger_factorials(int n) { // �������׳�
		BigInteger total = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			BigInteger bi_1 = new BigInteger(String.valueOf(i));
			total = total.multiply(bi_1);
		}
		return total;
	}
}
