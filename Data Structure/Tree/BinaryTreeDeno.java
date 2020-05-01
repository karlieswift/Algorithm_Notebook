package Tree;
import java.util.LinkedList;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;




/**
 * 
 *          6
 *       2     7
 *     1   0 3  8
 * 
 * 
 * 
 * 
 *          6
 *       2     7
 *     1   0 3  0
 * 
 * 
 * 1-�ݹ鴴������  �������� 6 2 1 0 0 0 7 3 0 0 0
 * 2-searchAncestor(int a,int b)���������ڵ������������ڵ�
 * 3-��������ݹ���ǵݹ�  6 2 1 7 3
 * 4-��������ݹ���ǵݹ� 1 2 6 3 7
 * 5-��������ݹ���ǵݹ� 1 2 3 7 6
 * 6-��α���6 2 7 1 3 
 * 7-ɾ��
 * 8-����    
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��15��
 * @version "13.0.1"
 */
public class BinaryTreeDeno {

	public static void main(String[] args) {
		BiTree tree = new BiTree();

		//int arr[] = { 6, 2, 1, 0, 0, 0, 7, 3, 0, 0, 8, 0, 0 };
		 int arr[] = { 6, 2, 1, 0, 0, 0, 7, 3, 0, 0, 0 };
		// System.out.println("����ڵ�0����սڵ�:");
		tree.creatTree(arr);
		tree.searchAncestor(1, 3);//6
		tree.searchAncestor(3, 7);//6
		tree.preorder();
		tree.inorder();
		tree.postorder();
		tree.preorder1();
		tree.inorder1();
		tree.postorder1();
		tree.level();
		tree.search(6);
		System.out.print("ɾ���ڵ�7��");
		tree.del(7);
		tree.postorder();

//	    
	}
}

//�����������Ľڵ�Node
class Node {
	int data;
	Node lchildNode;
	Node rchildNode;


	public Node() {

	}

	public Node(int data) {
		this.data = data;
	}

}

//����������
class BiTree {
	private Node root;

	public BiTree() {

	}

	// �ݹ鴴����0�������ĸýڵ�Ϊ��
	static int i = 0;

	public void creatTree(int[] arr) {
		root = creatTree(root, arr);
	}

	private Node creatTree(Node node, int[] arr) {
		// int arr[]= {6, 2, 1, 0 ,0 ,0, 7, 3, 0 ,0 ,0};
		int data = arr[i++];
		if (data != 0) {
			node = new Node();
			node.data = data;
			node.lchildNode = creatTree(node.lchildNode, arr);
			node.rchildNode = creatTree(node.rchildNode, arr);
		} else {
			node = null;
		}
		return node;
	}

	/**
	 * ���������ڵ������������ڵ㣬������Ԫ�ز���
	 * 
	 * @Function @param a
	 * @Function @param b
	 */
	public void searchAncestor(int a, int b) {
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		int aa[] = null;
		int bb[];
		Node p = root;
		Node r = null;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.lchildNode;
			} else {
				p = stack.peek();// ȡջ��Ԫ��
				if (p.rchildNode != null && p.rchildNode != r) { // ���������գ���û�б�����
					p = p.rchildNode;// ������
					stack.push(p);
					p = p.lchildNode;// �ٴο���ǰp����������p����root
				} else {// p.rchildNode==r����p�����������ʹ�����ǰ�ڵ�p�����α����ʣ�p.rchildNode�����ʹ�
					p = stack.pop();
					if (p.data == a) {
						aa=new int[stack.size()];
						for(int i=0;i<aa.length;i++) {
							aa[i]=stack.get(i).data;
						}
					}
					if (p.data == b) {
						bb=new int[stack.size()];
						for(int i=0;i<bb.length;i++) {
							bb[i]=stack.get(i).data;
						}
						for (int i = aa.length-1; i >= 0; i--) {
							for (int j = bb.length-1; j >= 0; j--) {
								
								if (aa[i]==bb[j]) {
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
	 * �����������ݹ�
	 */
	public void preorder() {
		System.out.print("�������:");
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.lchildNode);
			preorder(node.rchildNode);
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
			inorder(node.lchildNode);
			System.out.print(node.data + " ");
			inorder(node.rchildNode);
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
			postorder(node.lchildNode);
			postorder(node.rchildNode);
			System.out.print(node.data + " ");
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
			System.out.print(temp.data + " ");
			if (temp.rchildNode != null) {// ջ���ص㣬������������ȥ�������
				stack.push(temp.rchildNode);
			}
			if (temp.lchildNode != null) {// ջ���ص㣬���������ȥ���ȳ���
				stack.push(temp.lchildNode);
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
				p = p.lchildNode;
			} else {
				p = stack.pop();// �ҵ�����ߣ�����p�ĸ��ڵ㼴ջ����p
				System.out.print(p.data + " ");// ����p
				p = p.rchildNode;// ������
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
				p = p.lchildNode;
			} else {
				p = stack.peek();// ȡջ��Ԫ��
				if (p.rchildNode != null && p.rchildNode != r) { // ���������գ���û�б�����
					p = p.rchildNode;// ������
					stack.push(p);
					p = p.lchildNode;// �ٴο���ǰp����������p����root
				} else {// p.rchildNode==r����p�����������ʹ�����ǰ�ڵ�p�����α����ʣ�p.rchildNode�����ʹ�
					p = stack.pop();
					System.out.print(p.data + " ");
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
			System.out.print(p.data + " ");
			if (p.lchildNode != null) {
				queue.add(p.lchildNode);
			}
			if (p.rchildNode != null) {
				queue.add(p.rchildNode);
			}
		}

	}

	// ��ѯ�����ҳɹ����ؽڵ㣬���򷵻ؿ�
	public void search(int data) {
		if (search(root, data)) {
			System.out.println("�ҵ�" + data);
		} else {
			System.out.println("û�ҵ�" + data);
		}
	}

	private boolean search(Node node, int data) {
		if (node.data == data) { // ����鵽���ݾͷ��طǿ�
			return true;
		} else {
			if (node.lchildNode != null) { // ���������գ��ݹ�������
				return search(node.lchildNode, data);
			}
			if (node.rchildNode != null) { // ���������գ��ݹ�������
				return search(node.rchildNode, data);
			} else
				return false;
		}

	}

	public void del(int data) {
		del(root, data);
	}

	private void del(Node node, int data) {
		if (node.lchildNode != null && node.lchildNode.data == data) {
			node.lchildNode = null;
		}
		if (node.rchildNode != null && node.rchildNode.data == data) {
			node.rchildNode = null;
		}
		if (node.lchildNode != null) {
			del(node.lchildNode, data);
		}
		if (node.rchildNode != null) {
			del(node.rchildNode, data);
		}
	}

}











