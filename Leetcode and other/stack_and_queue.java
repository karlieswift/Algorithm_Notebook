package leetcode;
import java.util.*;
/**
 * queue stack����
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��30��
 * @version "13.0.1"
 */
public class stack_and_queue {   
	
    public static void main(String[] args) {  	
    	Scanner scan=new Scanner(System.in);
    	Stack<Integer> st=new Stack<Integer>();
    	for(int i=0;i<10;i++)
    		st.push(i);
    	while(!st.empty())	
    		System.out.print(st.pop()+" ");
    	System.out.println();
    	System.out.println("=============================================");
    	Queue<Integer> qe=new LinkedList<Integer>();
    	for(int i=0;i<10;i++)
    		qe.offer(i);
    	System.out.println(qe.peek()+" ");  //ȡ����
    	while(!qe.isEmpty())	
    		System.out.print(qe.poll()+" "); //ȡ���ײ�ɾ��

     
    }      
}  