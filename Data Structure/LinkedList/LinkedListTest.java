package LinkedList;

/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月23日
 * @version "13.0.1"
 */
public class LinkedListTest {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			linkedList.addFirst(arr[i]);
		}
		linkedList.showlist();
		System.out.println(linkedList.getSize());
		System.out.println(linkedList.isEmpty());

		System.out.println("-------------------------------------------");
		LinkedList<Integer> linkedList1 = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			linkedList1.addLast(arr[i]);
		}
		linkedList1.showlist();
		System.out.println("-------------------------------------------");
		System.out.print("初始链表：");
		linkedList1.showlist();
		System.out.print("翻转链表：");
		linkedList1.reverseshow();
		System.out.print("删除第一个节点结果：");
		linkedList1.delete(5);
		linkedList1.showlist();
		System.out.print("将节点插入一个位置：");
		linkedList1.insert(5, 5);
		linkedList1.showlist();
		System.out.print("更新一个元素的信息：");
		linkedList1.update(5, 6);
		linkedList1.showlist();
		System.out.print("递归遍历：");
		linkedList1.showlist1();

	}

}

//单链表
class LinkedList<E> {

	private class Node {
		public E e;
		public Node next;

		public Node() {
		}

		public Node(E e) {
			this.e = e;
		}
	}

	private Node head = new Node();// 头结点
	private Node reverhead = new Node(null);// 翻转链表头结点
	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public void addLast(E e) {
		insert(size + 1, e);
	}

	public void addFirst(E e) {
		insert(1, e);
	}

	public void insert(int index, E e) {//index从一开始

		if (index < 1 || index > size + 1) {
			return;
		}
		Node pre = head;
		for (int i = 0; i < index - 1; i++) {
			pre = pre.next;//找到插入节点的前一个位置
		}
		Node p = new Node(e);
		p.next = pre.next;
		pre.next = p;
		size++;

	}

	// 删除位置节点 1-2-3-4
	public void delete(int index) {
		if (index < 1 || index > size) {
			return;
		}
		int n = 0;
		Node p = head;
		while (true) {
			n++;
			if (index == n) {
				break;
			}
			p = p.next;
		}
		Node tempNode = p.next;
		p.next = tempNode.next;
		size--;
	}

	// 更新数据位置数据 1 2 3
	public void update(int index, E e) {
		int n = 0;
		Node p = head;
		while (true) {
			n++;
			if (n == index)
				break;
			p = p.next;
		}
		p.next.e = e;
	}

	/**
	 * 递归遍历
	 * 
	 * @Function
	 */

	public void showlist1() {
		showlist1(head.next);
	}

	private void showlist1(Node head) {

		if (head == null)
			return;
		if (head != null) {
			System.out.print(head.e + " ");
			showlist1(head.next);
		}
	}

	/**
	 * 非递归遍历
	 * 
	 * @Function
	 */
	public void showlist() {
		Node p = head.next;
		while (p != null) {
			System.out.print(p.e + " ");
			p = p.next;
		}
		System.out.println();
	}

	// 翻转链表
	private Node reverse() {
		Node p;
		reverhead.next = null;
		Node temp = head;
		while (temp.next != null) {
			E data = temp.next.e;
			p = new Node(data);
			p.next = reverhead.next;
			reverhead.next = p;
			temp = temp.next;

		}
		return reverhead;
	}

	/**
	 * 翻转链表遍历
	 * 
	 * @Function
	 */
	public void reverseshow() {
		reverhead = reverse();
		Node temp = reverhead.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.print(temp.e + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
