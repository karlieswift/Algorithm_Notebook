package LinkedList;

/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��23��
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
		System.out.print("��ʼ����");
		linkedList1.showlist();
		System.out.print("��ת����");
		linkedList1.reverseshow();
		System.out.print("ɾ����һ���ڵ�����");
		linkedList1.delete(5);
		linkedList1.showlist();
		System.out.print("���ڵ����һ��λ�ã�");
		linkedList1.insert(5, 5);
		linkedList1.showlist();
		System.out.print("����һ��Ԫ�ص���Ϣ��");
		linkedList1.update(5, 6);
		linkedList1.showlist();
		System.out.print("�ݹ������");
		linkedList1.showlist1();

	}

}

//������
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

	private Node head = new Node();// ͷ���
	private Node reverhead = new Node(null);// ��ת����ͷ���
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

	public void insert(int index, E e) {//index��һ��ʼ

		if (index < 1 || index > size + 1) {
			return;
		}
		Node pre = head;
		for (int i = 0; i < index - 1; i++) {
			pre = pre.next;//�ҵ�����ڵ��ǰһ��λ��
		}
		Node p = new Node(e);
		p.next = pre.next;
		pre.next = p;
		size++;

	}

	// ɾ��λ�ýڵ� 1-2-3-4
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

	// ��������λ������ 1 2 3
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
	 * �ݹ����
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
	 * �ǵݹ����
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

	// ��ת����
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
	 * ��ת�������
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
