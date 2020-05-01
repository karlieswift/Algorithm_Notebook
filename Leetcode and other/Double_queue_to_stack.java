package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ������������ʵ��һ��ջ����ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 * ˼·����������һ������һ�������ǿ�
 * 2�����У�push �鿴�����Ƿ�Ϊ�գ�����ֱ�����
 * pop()�ǿն��г���ֱ��ʣ��һ��Ԫ�أ�����ն���
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��12��
 * @version "13.0.1"
 */
public class Double_queue_to_stack {

	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();

	public static void main(String[] args) {

		Double_queue_to_stack q = new Double_queue_to_stack();
		q.push(1);
		q.push(2);
		q.push(3);
		System.out.println(q.pop());
		System.out.println(q.pop());
		q.push(4);
		System.out.println(q.pop());
		q.push(5);
		q.push(6);
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());

	}

	public void push(int data) {
		if (queue1.isEmpty()) {
			queue2.add(data);
		}
		if (queue2.isEmpty()) {
			queue1.add(data);
		}

	}
 
	public int pop() {
		//��Ϊ�յĳ����У�
		int data = 0;
		if (queue1.isEmpty()) {
			while (queue2.size() > 1) {//ֱ��size==1
				queue1.add(queue2.poll());
			}
			data = queue2.poll();
		} else {
			while (queue1.size() > 1) {
				queue2.add(queue1.poll());
			}
			data = queue1.poll();
		}

		return data;
	}
}
