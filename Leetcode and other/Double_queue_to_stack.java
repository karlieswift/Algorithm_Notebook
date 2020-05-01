package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 用两个队列来实现一个栈，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：整个过程一定至少一个队列是空
 * 2个队列，push 查看队列是否为空，不空直接入队
 * pop()非空队列出队直到剩余一个元素，进入空队列
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月12日
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
		//不为空的出队列，
		int data = 0;
		if (queue1.isEmpty()) {
			while (queue2.size() > 1) {//直到size==1
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
