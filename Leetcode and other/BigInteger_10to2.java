package leetcode;

import java.math.BigInteger;
import java.util.*;
/**
 * 10����ת2����
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class BigInteger_10to2 {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		int n = 1000;
		while (n != 0) {
			stack.add(n % 2); 
			n = n / 2;
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();

		//10����ת2����
		System.out.println(new BigInteger("1000", 10).toString(2));

	}
}