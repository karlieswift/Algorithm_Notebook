package set;



/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��21��
 * @version "13.0.1"
 */

public class AVL<E extends Comparable<E>> {

	private class Node {
		E e;
		Node leftNode, rightNode;

		public int height;
		public Node(E e) {
			this.e = e;
			height=1;
		}

	}

	private Node root;
	private int size;

	/**
	 * ��ȡ�ڵ�node�ĸ߶�
	 * �����б�Ҫд�ɺ��������ڴ���nodeΪ�գ����������ֿ�ָ���쳣
	 * @Function @param node
	 * @Function @return
	 */
	private int getHeight(Node node) {
		if(node==null) {
			return 0;
		}
		else {
			return node.height;
		}
	}
	
	/**
			         X
			     Y       T1   
			  Z     T2
	      T3    T4  
	      
			        
			     Y       
			  Z       X
	      T3    T4  T2  T1
			  
	 * rr ����ת :������Ӵ�������ת
	 * @Function @param node
	 * @Function @return
	 */
	 
	private Node rightRotate(Node X) {
		// ��ֽڵ�
		Node Y = X.leftNode;
		Node T2 = Y.rightNode;
		// ��ת
		Y.rightNode = X;
		X.leftNode = T2;
		X.height = 1 + Math.max(getHeight(X.leftNode), getHeight(X.rightNode));
		Y.height = 1 + Math.max(getHeight(Y.leftNode), getHeight(Y.rightNode));
		return Y;
	}

	/**
	         X
	     T1      Y
	          T2    Z
	            T3     T4
	 
	         
	             Y
	         X         Z
	     T1    T2  T3     T4
	 * LL ����ת :�ұ����Ӵ�������ת
	 * @Function @param X
	 * @Function @return
	 */
	private Node leftRotate(Node X) {
		// ��ֽڵ�
		Node Y = X.rightNode;
		Node T2 = Y.leftNode;
		// ��ת
		Y.leftNode = X;
		X.rightNode = T2;
		X.height = 1 + Math.max(getHeight(X.leftNode), getHeight(X.rightNode));
		Y.height = 1 + Math.max(getHeight(Y.leftNode), getHeight(Y.rightNode));
		return Y;
	}

	/**
	 * �ж��Ƿ�ΪAVL
	 * �жϵ�ǰ�ڵ�Ϊroot�ڵ���Ƿ�Ϊƽ�������
	 * @Function @return
	 */
	public boolean isBalanced() {
		return isBalanced(root);
	}
	// �жϵ�ǰ�ڵ�Ϊroot�ڵ���Ƿ�Ϊƽ�������
	private boolean isBalanced(Node node) {
		if (node == null) {
			return true;
		}
		int balancefactor = getBanlanceFactor(node);
		if (Math.abs(balancefactor) > 1) {
			return false;
		}
		return isBalanced(node.leftNode) && isBalanced(node.rightNode);
	}

	
	/**
	 * ��ȡnode��ƽ������
	 * @Function @param node
	 * @Function @return
	 */
	private int getBanlanceFactor(Node node) {
		if (node == null) {
			return 0;
		}
		return getHeight(node.leftNode) - getHeight(node.rightNode);
	}

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
		
		
		//����height
		node.height=1+Math.max(getHeight(node.leftNode),getHeight(node.rightNode));
		int balancefactor=getBanlanceFactor(node);
		//LL ������ת
		if(balancefactor>1 && getBanlanceFactor(node.leftNode)>=0) {
			return rightRotate(node);
		}
		//RR  ������ת
		if(balancefactor<-1&& getBanlanceFactor(node.rightNode)<=0) {
			return leftRotate(node);
		}
		
		//LR
		if(balancefactor>1&& getBanlanceFactor(node.leftNode)<0) {
			//�ȶ�node������������ת
			node.leftNode=leftRotate(node.leftNode);
			//���ڱ��LL,��������ת
			return rightRotate(node);
		}
		//RL
		if(balancefactor<-1&& getBanlanceFactor(node.rightNode)>0) {
			//�ȶ�node������������ת
			node.rightNode=rightRotate(node.rightNode);
			//���ڱ��RR,��������ת
			return leftRotate(node);
		}
		
		
		return node;
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
			System.out.print(node.e+"("+getBanlanceFactor(node)+")" + " ");
			inorder(node.rightNode);
		}
	}
	/**
	 * ɾ���ڵ㣬��ά��ƽ��
	 * 
	 * @Function @param e
	 */
	public void remove1(E e) {
		root = deleteNode1(root, e);
	}
	//����ɾ���ڵ���µ����ĸ�
	
	private Node deleteNode1(Node node, E e) {
		// ����ڵ��ǿ���return
		if (node == null) { // ����ڵ�Ϊ���򷵻�
			return null;
		}
		Node tempNode ;
		if (node.e.compareTo(e) > 0) {// ����ڵ����������ݹ�������
			node.leftNode = deleteNode1(node.leftNode, e);
			tempNode=node;
		} else if (node.e.compareTo(e) < 0) {// ����ڵ�С��������ݹ�������
			node.rightNode = deleteNode1(node.rightNode, e);
			tempNode=node;
		} else { // �����ҵ��ýڵ㣬���ڽ���ɾ��
			size--;
			if (node.leftNode == null) {
				tempNode=node.rightNode;
			}
			else if (node.rightNode == null) {
				tempNode=node.leftNode;
			} 
			// �ýڵ�����������ǿգ���ʱ������2�ַ��������������ֵ�����滻��������������Сֵ�����滻
			else { // �˷�������������Сֵ
					// ��������Сֵ
				Node pnode = node.rightNode;
				// ��Сֵ������ߣ��������
				while (pnode.leftNode != null) {
					pnode = pnode.leftNode;
				}
				// ͨ���滻����ɾ��
				tempNode= pnode;
				tempNode.leftNode=node.leftNode;
				tempNode.rightNode=node.rightNode;
				node=null;
				pnode = null;
				// ����

				// Ȼ����ж�pnodeɾ��,���Դ����������pnode��e,
				// ��ΪĿǰ�Ľڵ�Ӧ�ô��ұ߿�ʼ,����node.right��Ϊ��ǰ�ĸ��ڵ����Դ���node.right,
				// �ٴ����ҵݹ�ɾ��

				// node.rightNode = deleteNode(node.rightNode, pnode.e);
			}
		}
		return tempNode;
	}
	/**
	 * ɾ���ڵ㣬ά��ƽ��
	 * 
	 * @Function @param e
	 */
	public void remove(E e) {
		root = deleteNode(root, e);
	}
	private Node deleteNode(Node node, E e) {
		// ����ڵ��ǿ���return
		if (node == null) { // ����ڵ�Ϊ���򷵻�
			return null;
		}
		Node tempNode;
		if (node.e.compareTo(e) > 0) {// ����ڵ����������ݹ�������
			node.leftNode = deleteNode(node.leftNode, e);
			tempNode = node;
		} else if (node.e.compareTo(e) < 0) {// ����ڵ�С��������ݹ�������
			node.rightNode = deleteNode(node.rightNode, e);
			tempNode = node;
		} else { // �����ҵ��ýڵ㣬���ڽ���ɾ��
			size--;
			if (node.leftNode == null) {
				tempNode = node.rightNode;
			} else if (node.rightNode == null) {
				tempNode = node.leftNode;
			}
			// �ýڵ�����������ǿգ���ʱ������2�ַ��������������ֵ�����滻��������������Сֵ�����滻
			else { // �˷�������������Сֵ
					// ��������Сֵ
				Node pnode = node.rightNode;
				// ��Сֵ������ߣ��������
				while (pnode.leftNode != null) {
					pnode = pnode.leftNode;
				}
				// ͨ���滻����ɾ��
				tempNode = pnode;
				tempNode.leftNode = node.leftNode;
				tempNode.rightNode = node.rightNode;
				node = null;
				pnode = null;
				// ����

				// Ȼ����ж�pnodeɾ��,���Դ����������pnode��e,
				// ��ΪĿǰ�Ľڵ�Ӧ�ô��ұ߿�ʼ,����node.right��Ϊ��ǰ�ĸ��ڵ����Դ���node.right,
				// �ٴ����ҵݹ�ɾ��

				// node.rightNode = deleteNode(node.rightNode, pnode.e);
			}
		}

		//java.lang.NullPointerException ��Ϊ��ʱ���Ͳ�����ת�������ָ���쳣
		if(tempNode==null) {
			return null;
		}
		// ����height
		tempNode.height = 1 + Math.max(getHeight(tempNode.leftNode), getHeight(tempNode.rightNode));
		int balancefactor = getBanlanceFactor(tempNode);
		// LL ������ת
		if (balancefactor > 1 && getBanlanceFactor(tempNode.leftNode) >= 0) {
			return rightRotate(tempNode);
		}
		// RR ������ת
		if (balancefactor < -1 && getBanlanceFactor(tempNode.rightNode) <= 0) {
			return leftRotate(tempNode);
		}

		// LR
		if (balancefactor > 1 && getBanlanceFactor(tempNode.leftNode) <0) {
			// �ȶ�tempNode������������ת
			tempNode.leftNode = leftRotate(tempNode.leftNode);
			// ���ڱ��LL,��������ת
			return rightRotate(tempNode);
		}
		// RL
		if (balancefactor < -1 && getBanlanceFactor(tempNode.rightNode) >0) {
			// �ȶ�tempNode������������ת
			tempNode.rightNode = rightRotate(tempNode.rightNode);
			// ���ڱ��RR,��������ת
			return leftRotate(tempNode);
		}

		return tempNode;
	}
	/**
	 * ���ҽڵ�
	 * 
	 * @Function @param e
	 */
	public boolean searchNode(E e) {
		if (searchNode(root, e)) {
			return true;
		}
		return false;
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

}