package leetcode;

import java.util.Stack;
/**
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 *
 *˼·��
 * Stack<Integer> stack1 = new Stack<Integer>();//������������
 * Stack<Integer> stack2 = new Stack<Integer>();//����ɾ������
 * �����ݽ�վʱ������stack1�������Ҫɾ�������������Stack2������У����Խ�stack1�����ݽ�ȥstack2�
 * ע�⣺stack1����Stack2��������Stack2Ϊ��
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��12��
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
		//���ж�stack2�Ƿ�Ϊ�գ�����ֱ�ӳ�վ
		if(stack2.size()!=0) {
			return stack2.pop();
		}
		else { //��stack1ѹ��Stack2
				while(stack1.size()!=0) {
					stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
		
	}
}
