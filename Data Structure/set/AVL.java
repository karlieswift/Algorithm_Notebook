package set;



/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月21日
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
	 * 获取节点node的高度
	 * 这里有必要写成函数，便于处理node为空，不处理会出现空指针异常
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
			  
	 * rr 右旋转 :左边因子大，向右旋转
	 * @Function @param node
	 * @Function @return
	 */
	 
	private Node rightRotate(Node X) {
		// 拆分节点
		Node Y = X.leftNode;
		Node T2 = Y.rightNode;
		// 旋转
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
	 * LL 左旋转 :右边因子大，向左旋转
	 * @Function @param X
	 * @Function @return
	 */
	private Node leftRotate(Node X) {
		// 拆分节点
		Node Y = X.rightNode;
		Node T2 = Y.leftNode;
		// 旋转
		Y.leftNode = X;
		X.rightNode = T2;
		X.height = 1 + Math.max(getHeight(X.leftNode), getHeight(X.rightNode));
		Y.height = 1 + Math.max(getHeight(Y.leftNode), getHeight(Y.rightNode));
		return Y;
	}

	/**
	 * 判断是否为AVL
	 * 判断当前节点为root节点的是否为平衡二叉树
	 * @Function @return
	 */
	public boolean isBalanced() {
		return isBalanced(root);
	}
	// 判断当前节点为root节点的是否为平衡二叉树
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
	 * 获取node的平衡因子
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
	 * 递归添加元素
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
		
		
		//更新height
		node.height=1+Math.max(getHeight(node.leftNode),getHeight(node.rightNode));
		int balancefactor=getBanlanceFactor(node);
		//LL 向右旋转
		if(balancefactor>1 && getBanlanceFactor(node.leftNode)>=0) {
			return rightRotate(node);
		}
		//RR  向左旋转
		if(balancefactor<-1&& getBanlanceFactor(node.rightNode)<=0) {
			return leftRotate(node);
		}
		
		//LR
		if(balancefactor>1&& getBanlanceFactor(node.leftNode)<0) {
			//先对node的左子树左旋转
			node.leftNode=leftRotate(node.leftNode);
			//现在变成LL,进行右旋转
			return rightRotate(node);
		}
		//RL
		if(balancefactor<-1&& getBanlanceFactor(node.rightNode)>0) {
			//先对node的右子树右旋转
			node.rightNode=rightRotate(node.rightNode);
			//现在变成RR,进行左旋转
			return leftRotate(node);
		}
		
		
		return node;
	}
	/**
	 * 中序序遍历结果递归
	 */
	public void inorder() {
		System.out.print("中序遍历:");
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
	 * 删除节点，不维护平衡
	 * 
	 * @Function @param e
	 */
	public void remove1(E e) {
		root = deleteNode1(root, e);
	}
	//返回删除节点后新的树的根
	
	private Node deleteNode1(Node node, E e) {
		// 如果节点是空则return
		if (node == null) { // 如果节点为空则返回
			return null;
		}
		Node tempNode ;
		if (node.e.compareTo(e) > 0) {// 如果节点大于数据则递归左子树
			node.leftNode = deleteNode1(node.leftNode, e);
			tempNode=node;
		} else if (node.e.compareTo(e) < 0) {// 如果节点小于数据则递归右子树
			node.rightNode = deleteNode1(node.rightNode, e);
			tempNode=node;
		} else { // 否则找到该节点，现在进行删除
			size--;
			if (node.leftNode == null) {
				tempNode=node.rightNode;
			}
			else if (node.rightNode == null) {
				tempNode=node.leftNode;
			} 
			// 该节点的左右子树非空，此时进行有2种方法，向左找最大值进行替换，或者向右找最小值进行替换
			else { // 此方法是向右找最小值
					// 向右找最小值
				Node pnode = node.rightNode;
				// 最小值在最左边，往左遍历
				while (pnode.leftNode != null) {
					pnode = pnode.leftNode;
				}
				// 通过替换进行删除
				tempNode= pnode;
				tempNode.leftNode=node.leftNode;
				tempNode.rightNode=node.rightNode;
				node=null;
				pnode = null;
				// 结束

				// 然后进行对pnode删除,所以传入的数据是pnode的e,
				// 因为目前的节点应该从右边开始,所以node.right变为当前的根节点所以传入node.right,
				// 再次向右递归删除

				// node.rightNode = deleteNode(node.rightNode, pnode.e);
			}
		}
		return tempNode;
	}
	/**
	 * 删除节点，维护平衡
	 * 
	 * @Function @param e
	 */
	public void remove(E e) {
		root = deleteNode(root, e);
	}
	private Node deleteNode(Node node, E e) {
		// 如果节点是空则return
		if (node == null) { // 如果节点为空则返回
			return null;
		}
		Node tempNode;
		if (node.e.compareTo(e) > 0) {// 如果节点大于数据则递归左子树
			node.leftNode = deleteNode(node.leftNode, e);
			tempNode = node;
		} else if (node.e.compareTo(e) < 0) {// 如果节点小于数据则递归右子树
			node.rightNode = deleteNode(node.rightNode, e);
			tempNode = node;
		} else { // 否则找到该节点，现在进行删除
			size--;
			if (node.leftNode == null) {
				tempNode = node.rightNode;
			} else if (node.rightNode == null) {
				tempNode = node.leftNode;
			}
			// 该节点的左右子树非空，此时进行有2种方法，向左找最大值进行替换，或者向右找最小值进行替换
			else { // 此方法是向右找最小值
					// 向右找最小值
				Node pnode = node.rightNode;
				// 最小值在最左边，往左遍历
				while (pnode.leftNode != null) {
					pnode = pnode.leftNode;
				}
				// 通过替换进行删除
				tempNode = pnode;
				tempNode.leftNode = node.leftNode;
				tempNode.rightNode = node.rightNode;
				node = null;
				pnode = null;
				// 结束

				// 然后进行对pnode删除,所以传入的数据是pnode的e,
				// 因为目前的节点应该从右边开始,所以node.right变为当前的根节点所以传入node.right,
				// 再次向右递归删除

				// node.rightNode = deleteNode(node.rightNode, pnode.e);
			}
		}

		//java.lang.NullPointerException 当为空时，就不用旋转，否则空指针异常
		if(tempNode==null) {
			return null;
		}
		// 更新height
		tempNode.height = 1 + Math.max(getHeight(tempNode.leftNode), getHeight(tempNode.rightNode));
		int balancefactor = getBanlanceFactor(tempNode);
		// LL 向右旋转
		if (balancefactor > 1 && getBanlanceFactor(tempNode.leftNode) >= 0) {
			return rightRotate(tempNode);
		}
		// RR 向左旋转
		if (balancefactor < -1 && getBanlanceFactor(tempNode.rightNode) <= 0) {
			return leftRotate(tempNode);
		}

		// LR
		if (balancefactor > 1 && getBanlanceFactor(tempNode.leftNode) <0) {
			// 先对tempNode的左子树左旋转
			tempNode.leftNode = leftRotate(tempNode.leftNode);
			// 现在变成LL,进行右旋转
			return rightRotate(tempNode);
		}
		// RL
		if (balancefactor < -1 && getBanlanceFactor(tempNode.rightNode) >0) {
			// 先对tempNode的右子树右旋转
			tempNode.rightNode = rightRotate(tempNode.rightNode);
			// 现在变成RR,进行左旋转
			return leftRotate(tempNode);
		}

		return tempNode;
	}
	/**
	 * 查找节点
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
		if (node == null) { // 如果为空返回false
			return false;
		}
		if (node.e.compareTo(e) == 0) { // 找到返回true
			return true;
		} else { // 没有找到递归
			if (node.e.compareTo(e) > 0) { // 递归向左查找
				return searchNode(node.leftNode, e);
			} else { // 递归向右查找
				return searchNode(node.rightNode, e);
			}
		}

	}

}