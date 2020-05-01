package leetcode;

import java.util.Stack;
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 *思路：
 * Stack<Integer> stack1 = new Stack<Integer>();//用来进入数据
 * Stack<Integer> stack2 = new Stack<Integer>();//用来删除数据
 * 当数据进站时，进入stack1，如果想要删除数据则必须在Stack2里面进行，所以将stack1的数据进去stack2里，
 * 注意：stack1进入Stack2的条件是Stack2为空
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月12日
 * @version "13.0.1"
 */
public class Double_Stack_to_Queue {
	 
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {
		
		Double_Stack_to_Queue q=new Double_Stack_to_Queue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		q.push(5);
		q.push(6);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
	}
	public  void push(int node) {
		stack1.add(node);
	}
	
	public int pop() {
		//先判断stack2是否为空，不空直接出站
		if(stack2.size()!=0) {
			return stack2.pop();
		}
		else { //将stack1压如Stack2
				while(stack1.size()!=0) {
					stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
		
	}
}
