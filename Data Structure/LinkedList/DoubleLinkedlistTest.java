package LinkedList;
/**
 * 
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��23��
 * @version "13.0.1"
 */
public class DoubleLinkedlistTest {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };
		DoubleLinkedlist<Integer> linkedList1 = new DoubleLinkedlist<>();
		for (int i = 0; i < arr.length; i++) {
			linkedList1.addLast(arr[i]);
		}
		linkedList1.showlist();
		linkedList1.insert(7, 121212);
		linkedList1.showlist();
		System.out.println("-------------------------------------------");
		System.out.print("��ʼ����");
		linkedList1.showlist();
		System.out.print("ɾ����һ���ڵ�����");
		linkedList1.delete(7);
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
class DoubleLinkedlist<E> {

	private class Node {
		public E e;
		public Node next;
		public Node pre;

		public Node() {
		}

		public Node(E e) {
			this.e = e;
		}
	}

	private Node head = new Node();// ͷ���
	 
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
	public void insert(int index, E e) {//index��һ��ʼ

		if (index < 1 || index > size + 1) {
			return;
		}
		Node temp = head;
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;//�ҵ�����ڵ��ǰһ��λ��
		}
		
		Node p = new Node(e);
		Node q=temp.next;
		if(q!=null) {	//���������һ��λ��null.preΪ���쳣
			p.next=q;
			q.pre=p;
		}
		temp.next=p;
		p.pre=temp; 
		size++;

	}

	// ɾ��λ�ýڵ� 1-2-3-4
	public void delete(int index) {
		if (index < 1 || index > size) {
			return;
		}
		int n = 1;
		Node p = head;
		while(n!=index) {
			n++;
			p=p.next;
		}
		Node q=p.next;//��ǰq�Ľڵ��Ϊɾ���Ľڵ�
		p.next=q.next;
		if(q.next!=null) {
			q.next.pre=p;
		}
		
		
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

	

}
