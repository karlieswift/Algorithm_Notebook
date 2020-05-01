package redblackTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * REDBLACKTREE
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

public class RBtreeTest {

	public static void main(String[] args) {
		RBTree<Integer> rbtree = new RBTree<>();

		int arr[] = { 12, 3, 1, 66, 23, 7 };
		for (int i = 0; i < arr.length; i++) {
			rbtree.add(arr[i]);
		} 
		
		rbtree.level();


		rbtree.deleteNode(66);
		rbtree.inorder();

		rbtree.deleteNode(7);
		rbtree.inorder();
		rbtree.deleteNode(23);
		rbtree.inorder();
		rbtree.deleteNode(12);

		rbtree.inorder();
	
	}
 
}

class RBTree<E extends Comparable<E>> {
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private Node root;
	private int size;
	private class Node {
		E e;
		Node leftNode, rightNode;
		public boolean color;
		public Node(E e) {
			this.e = e;
			color=RED;
		}
	}


	public boolean isempty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

      /**
       * �жϽڵ���ɫ
       * @Function @param node
       * @Function @return
       */
	private boolean isRedNode(Node node) {
		if(node==null) {
			return BLACK;
		}
		return node.color;
	}
	
	
	/**
			         X
			     Y       T1   
			  Z     T2
	      
			        
			     Y       
			  Z       X
	               T2  T1
			  
	 * rr ����ת :������Ӵ�������ת
	 * @Function @param node
	 * @Function @return
	 */
	 
	private Node rightRotate(Node X) {
		// ��ֽڵ�
		Node Y=X.leftNode;
		Node T2=Y.rightNode;
		Y.rightNode=X;
		X.leftNode=T2;
		Y.color=X.color;
		X.color=RED;
		return Y;
		
	}

	/**
	         X
	     T1      Y
	          T2    Z
	
	 
	         
	             Y
	         X        Z
	     T1    T2   
	 * LL ����ת :�ұ����Ӵ�������ת
	 * @Function @param X
	 * @Function @return
	 */
	private Node leftRotate(Node X) {
		// ��ֽڵ�
		Node Y=X.rightNode;
		Node T2=Y.leftNode;
		Y.leftNode=X;
		X.rightNode=T2;
		//��ɫ����
		Y.color=X.color;
		X.color=RED;
		return Y;
	}

      //��ɫ��ת
	private void  flipColors(Node node) {
		node.color=RED;
		node.leftNode.color=BLACK;
		node.rightNode.color=BLACK;
	}
	/**
	 * �ݹ����Ԫ��
	 * 
	 * @Function @param e
	 */
	public void add(E e) {
		root = insert(root, e);
		root.color=BLACK;//���յĸ��ڵ��Ǻ�ɫ�ڵ�
	}

	//����nodeΪ���Ķ������в���Ԫ�أ����ز����½ڵ��Ķ������ĸ�
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
		// ����ת:��ǰ�ڵ�node���Һ����Ǻ�ɫ �� ��ǰ�ڵ�������Ǻ�ɫ
		if (isRedNode(node.rightNode) && !isRedNode(node.leftNode)) {
			node = leftRotate(node);
		}
		// ����ת����ǰ�ڵ������Ϊ�죬�����ӵ�����Ҳ�Ǻ�ɫ
		if (isRedNode(node.leftNode) && isRedNode(node.leftNode.leftNode)) {
			node = rightRotate(node);
		}
		// ��ɫ��ת:��ǰ�ڵ�����Һ��Ӷ�Ϊ��ɫ
		if (isRedNode(node.leftNode) && isRedNode(node.rightNode)) {
			flipColors(node);
		}
		
		return node;
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
