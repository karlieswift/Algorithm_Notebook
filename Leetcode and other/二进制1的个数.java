/**
 *
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 例如把9表示成二进制是1001 ，有2位是1. 因此如果输入9，返回2。
 * @author karlieswift
 * date: 2020/5/28 18:32
 * ClassName: Solution
 * @version java "13.0.1"
 */
public class Solution {

    public static void main(String[] args) {

        int n=9;
        System.out.println(fun(n));
    }

    //方法1
    public static int fun(int n){
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }


    //方法2
    public static  int fun2(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }
}
