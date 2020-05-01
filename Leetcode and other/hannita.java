package leetcode;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月30日
 * @version "13.0.1"
 */
public class hannita {

	public static void main(String[] args) {
		hani(3,'A','B','C');
	}
	//  A B C
	static int i=1;
	public static void hani(int n,char A,char B,char C) {
		if(n==1) {
			System.out.println("第"+(i++)+"次移动"+A+"->"+C);
		}
		else {
			hani(n-1,A, C, B);
			System.out.println("第"+(i++)+"次移动"+A+"->"+C);
			hani(n-1,B, A, C);
		}
	}
}
