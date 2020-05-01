package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * @Description: <Function>
 * @author karlieswift
 * @date 2020��4��16��
 * @version "13.0.1"
 *        12
 *    3       66
 *  1   7  23
 * 1-�ݹ鴴������  �������� { 12, 3, 1, 66, 23, 7 };
 * 2-searchAncestor(int a,int b)���������ڵ������������ڵ�
 * 3-��������ݹ���ǵݹ�  12 3 1 7 66 23 
 * 4-��������ݹ���ǵݹ� 1 3 7 12 23 66 
 * 5-��������ݹ���ǵݹ� 1 7 3 23 66 12 
 * 6-��α���12 3 66 1 7 23 
 * 7-ɾ��
 * 8-����    

 */
public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bis = new BinarySearchTree<>();

		int arr[] = { 12, 3, 1, 66, 23, 7 };
		for (int i = 0; i < arr.length; i++) {
			bis.add(arr[i]);
		} 
		bis.searchAncestor(1, 7);// 3
		bis.searchAncestor(23, 66);// 12
		bis.preorder(); 
		bis.inorder();
		bis.postorder();
		bis.preorder1();
		bis.inorder1();
		bis.postorder1();
		bis.level();
		System.out.println(bis.isempty());
		System.out.println(bis.size());// 6
		bis.deleteNode(66);
		bis.inorder();
		System.out.println(bis.size());// 5
		bis.deleteNode(7);
		bis.inorder();
		bis.deleteNode(23);
		bis.inorder();
		bis.deleteNode(12);
		System.out.println(bis.size());// 2
		bis.inorder();
		bis.deleteNode(1);
		System.out.println(bis.size());// 1
		bis.inorder();
		bis.deleteNode(3);
		bis.inorder();
		System.out.println(bis.isempty());
		bis.searchNode(7);
		bis.searchNode(12);
	}
 
}

class BinarySearchTree<E extends Comparable<E>> {

	private class Node {
		E e;
		Node leftNode, rightNode;

		public Node(E e) {
			this.e = e;
		}

	}

	private Node root;

	private int size;

	public boolean isempty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	/**
	 * �ݹ����Ԫ��
	 * 
	 * @Function @param e
	 */
	public void add1(E e) {
		insert1(root, e);
	}

	private void insert1(Node node, E e) {
		if (node == null) {
			size++;
			root = new Node(e);
			return;
		}
		if (node.e.compareTo(e) == 0) { // ����Ѿ��и����ݾͲ�����
			return;
		}
		if (node.e.compareTo(e) > 0) {
			// �������С��root����������
			if (node.leftNode == null) { // �������Ϊ����ֱ�Ӳ���
				size++;
				node.leftNode = new Node(e);
			} else { // ��������Ϊ�գ�������ݹ�������
				insert1(node.leftNode, e);
			}
		}
 
		else { // ������ݴ��������������
			if (node.rightNode == null) {
				size++;
				// ���������Ϊ����ֱ�Ӳ���
				node.rightNode = new Node(e);
			} else {
				// �����������Ϊ��������ݹ�������
				insert1(node.rightNode, e);
			}
		}
	}

	/**
	 * �ݹ����Ԫ��
	 * 
	 * @Function @param e
	 */
	public void add(E e) {
		root = insert(root, e);
	}

	private Node insert(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}
		if (e.compareTo(node.e) < 0) {
			node.leftNode = insert(node.leftNode, e);
		} else if (e.compareTo(node.e) > 0) {
			node.rightNode = insert(node.rightNode, e);
		}
		return node;
	}

	/**
	 * ���������ڵ������������ڵ㣬������Ԫ�ز���
	 * 
	 * @Function @param a
	 * @Function @param b
	 */
	public void searchAncestor(E a, E b) {
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		Object aa[] = null;
		Object bb[];
		Node p = root;
		Node r = null;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.leftNode;
			} else {
				p = stack.peek();// ȡջ��Ԫ��
				if (p.rightNode != null && p.rightNode != r) { // ���������գ���û�б�����
					p = p.rightNode;// ������
					stack.push(p);
					p = p.leftNode;// �ٴο���ǰp����������p����root
				} else {// p.rchildNode==r����p�����������ʹ�����ǰ�ڵ�p�����α����ʣ�p.rchildNode�����ʹ�
					p = stack.pop();
					if (p.e.compareTo(a) == 0) {
						aa = new Object[stack.size()];
						for (int i = 0; i < aa.length; i++) {
							aa[i] = stack.get(i).e;
						}
					}
					if (p.e == b) {
						bb = new Object[stack.size()];
						for (int i = 0; i < bb.length; i++) {
							bb[i] = stack.get(i).e;
						}
						for (int i = aa.length - 1; i >= 0; i--) {
							for (int j = bb.length - 1; j >= 0; j--) {

								if (aa[i] == bb[j]) {
									System.out.println(aa[i]);
									return;
								}
							}
						}
					}
					r = p;
					p = null;
				}
			}
		}

		System.out.println();
	}

	/**
	 * ɾ���ڵ�
	 * 
	 * @Function @param e
	 */
	public void deleteNode(E e) {
		root = deleteNode(root, e);
	}
	

	private Node deleteNode(Node node, E e) {
		// ����ڵ��ǿ���return
		if (node == null) { // ����ڵ�Ϊ���򷵻�
			return null;
		}
		if (node.e.compareTo(e) > 0) {// ����ڵ����������ݹ�������
			node.leftNode = deleteNode(node.leftNode, e);
		} else if (node.e.compareTo(e) < 0) {// ����ڵ�С��������ݹ�������
			node.rightNode = deleteNode(node.rightNode, e);
		} else { // �����ҵ��ýڵ㣬���ڽ���ɾ��
			size--;
//			//����һ
//			if (node.leftNode == null && node.rightNode == null) { // ΪҶ�ӽڵ�ֱ��ɾ��
//				node = null;
//			}
//			// ֻ�е���������ֱ���øò������ֱ���滻����Ϊ�ýڵ�Ľڵ�Ϊ��������Сֵ
//			// ������Ϊ�գ�ֱ�����������滻
//			else if (node.leftNode != null && node.rightNode == null) {
//				node = node.leftNode;
//			}
//			// ������Ϊ�գ�ֱ�����������滻
//			else if (node.leftNode == null && node.rightNode != null) {
//				node = node.rightNode;
//			}
			// ������
			if (node.leftNode == null) {
				return node.rightNode;
			}
			if (node.rightNode == null) {
				return node.leftNode;
			} // ����һ������

			// �ýڵ�����������ǿգ���ʱ������2�ַ��������������ֵ�����滻��������������Сֵ�����滻
			else { // �˷�������������Сֵ
					// ��������Сֵ
				Node pnode = node.rightNode;
				// ��Сֵ������ߣ��������
				while (pnode.leftNode != null) {
					pnode = pnode.leftNode;
				}
				// ͨ���滻����ɾ��
				node.e = pnode.e;
				pnode = null;
				// ����

				// Ȼ����ж�pnodeɾ��,���Դ����������pnode��e,
				// ��ΪĿǰ�Ľڵ�Ӧ�ô��ұ߿�ʼ,����node.right��Ϊ��ǰ�ĸ��ڵ����Դ���node.right,
				// �ٴ����ҵݹ�ɾ��

				// node.rightNode = deleteNode(node.rightNode, pnode.e);
			}
		}
		return node;
	}

	/**
	 * ���ҽڵ�
	 * 
	 * @Function @param e
	 */
	public void searchNode(E e) {
		if (searchNode(root, e) == true) {
			System.out.println("�ҵ�" + e);
			return;
		}
		System.out.println("û�ҵ�" + e);
	}

	private boolean searchNode(Node node, E e) {
		if (node == null) { // ���Ϊ�շ���false
			return false;
		}
		if (node.e.compareTo(e) == 0) { // �ҵ�����true
			return true;
		} else { // û���ҵ��ݹ�
			if (node.e.compareTo(e) > 0) { // �ݹ��������
				return searchNode(node.leftNode, e);
			} else { // �ݹ����Ҳ���
				return searchNode(node.rightNode, e);
			}
		}

	}

	/**
	 * �����������ݹ�
	 */
	public void preorder() {
		System.out.print("�������:");
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {
		if (node != null) {
			System.out.print(node.e + " ");
			preorder(node.leftNode);
			preorder(node.rightNode);
		}
	}

	/**
	 * �������������ݹ�
	 */
	public void inorder() {
		System.out.print("�������:");
		inorder(root);
		System.out.println();
	}

	private void inorder(Node node) {
		if (node != null) {
			inorder(node.leftNode);
			System.out.print(node.e + " ");
			inorder(node.rightNode);
		}
	}

	/**
	 * �����������ݹ�
	 */
	public void postorder() {
		System.out.print("�������:");
		postorder(root);
		System.out.println();
	}

	private void postorder(Node node) {
		if (node != null) {
			postorder(node.leftNode);
			postorder(node.rightNode);
			System.out.print(node.e + " ");
		}
	}

	/**
	 * �����������ǵݹ�
	 */
	public void preorder1() {
		System.out.print("��������ǵݹ�:");
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);// ������
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.e + " ");
			if (temp.rightNode != null) {// ջ���ص㣬������������ȥ�������
				stack.push(temp.rightNode);
			}
			if (temp.leftNode != null) {// ջ���ص㣬���������ȥ���ȳ���
				stack.push(temp.leftNode);
			}
		}
		System.out.println();
	}

	/**
	 * �����������ǵݹ�
	 */
	public void inorder1() {
		System.out.print("��������ǵݹ�:");
		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {// һֱ�ҵ������
				stack.push(p);
				p = p.leftNode;
			} else {
				p = stack.pop();// �ҵ�����ߣ�����p�ĸ��ڵ㼴ջ����p
				System.out.print(p.e + " ");// ����p
				p = p.rightNode;// ������
			}
		}
		System.out.println();
	}

	/**
	 * �����������ǵݹ�1
	 */
	public void postorder1() {
		System.out.print("��������ǵݹ�:");

		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		Node r = null;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.leftNode;
			} else {
				p = stack.peek();// ȡջ��Ԫ��
				if (p.rightNode != null && p.rightNode != r) { // ���������գ���û�б�����
					p = p.rightNode;// ������
					stack.push(p);
					p = p.leftNode;// �ٴο���ǰp����������p����root
				} else {// p.rightNode==r����p�����������ʹ�����ǰ�ڵ�p�����α����ʣ�p.rightNode�����ʹ�
					p = stack.pop();
					System.out.print(p.e + " ");
					r = p;
					p = null;
				}
			}
		}

		System.out.println();
	}

	/**
	 * ��α���
	 * 
	 * @Function
	 */
	public void level() {
		System.out.print("��α���:");
		level(root);
		System.out.println();
	}

	private void level(Node node) {
		Queue<Node> queue = new LinkedList<>();
		Node p = node;
		queue.add(p);
		while (!queue.isEmpty()) {
			p = queue.poll();
			System.out.print(p.e + " ");
			if (p.leftNode != null) {
				queue.add(p.leftNode);
			}
			if (p.rightNode != null) {
				queue.add(p.rightNode);
			}
		}

	}
}
