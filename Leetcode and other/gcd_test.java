package leetcode;
import java.util.*;

/**
 * x y
 *24 18 
 *18 24 
 *6 18 
 *0 6
 * x*y/���Լ��=��С������
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class gcd_test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int tay_x = x;
			int tay_y = y;
			while (x != 0) {
				int temp = y % x;
				y = x;
				x = temp;
			}
			System.out.println("���Լ�� " + y);
			System.out.println("��С������ " + tay_x * tay_y / y);
		}

	}
}
