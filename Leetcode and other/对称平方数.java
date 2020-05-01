package leetcode;

import java.util.*;

/**
 * 打印所有不超过n（n<256）的，其平方具有对称性质的数。如11*11=121。
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月29日
 * @version "13.0.1"
 */
public class 对称平方数 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		// int number=scan.nextInt();
		for (int i = 0; i < 256; i++) {
			String str = String.valueOf(i * i);
			StringBuffer str_1 = new StringBuffer(str);
			if (new String(str_1.reverse()).equals(str)) {
				System.out.println(str);
			}
		}

	}

}
