package redblackTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * REDBLACKTREE
 * @Description: <Function>
 * @author karlieswift
 * @date 2020年4月16日
 * @version "13.0.1"
 *        12
 *    3       66
 *  1   7  23
 * 1-递归创建函数  输入数据 { 12, 3, 1, 66, 23, 7 };
 * 2-searchAncestor(int a,int b)查找两个节点的最近公共父节点
 * 3-先序遍历递归与非递归  12 3 1 7 66 23 
 * 4-中序遍历递归与非递归 1 3 7 12 23 66 
 * 5-后序遍历递归与非递归 1 7 3 23 66 12 
 * 6-层次遍历12 3 66 1 7 23 
 * 7-删除
 * 8-查找    

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
       * 判断节点颜色
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
			  
	 * rr 右旋转 :左边因子大，向右旋转
	 * @Function @param node
	 * @Function @return
	 */
	 
	private Node rightRotate(Node X) {
		// 拆分节点
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
	 * LL 左旋转 :右边因子大，向左旋转
	 * @Function @param X
	 * @Function @return
	 */
	private Node leftRotate(Node X) {
		// 拆分节点
		Node Y=X.rightNode;
		Node T2=Y.leftNode;
		Y.leftNode=X;
		X.rightNode=T2;
		//颜色更新
		Y.color=X.color;
		X.color=RED;
		return Y;
	}

      //颜色翻转
	private void  flipColors(Node node) {
		node.color=RED;
		node.leftNode.color=BLACK;
		node.rightNode.color=BLACK;
	}
	/**
	 * 递归添加元素
	 * 
	 * @Function @param e
	 */
	public void add(E e) {
		root = insert(root, e);
		root.color=BLACK;//最终的根节点是黑色节点
	}

	//向以node为根的二叉树中插入元素，返回插入新节点后的二叉树的根
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
		// 左旋转:当前节点node的右孩子是红色 且 当前节点的左孩子是黑色
		if (isRedNode(node.rightNode) && !isRedNode(node.leftNode)) {
			node = leftRotate(node);
		}
		// 右旋转：当前节点的左孩子为红，且左孩子的左孩子也是红色
		if (isRedNode(node.leftNode) && isRedNode(node.leftNode.leftNode)) {
			node = rightRotate(node);
		}
		// 颜色翻转:当前节点的左右孩子都为红色
		if (isRedNode(node.leftNode) && isRedNode(node.rightNode)) {
			flipColors(node);
		}
		
		return node;
	}

	/**
	 * 删除节点
	 * 
	 * @Function @param e
	 */
	public void deleteNode(E e) {
		root = deleteNode(root, e);
	}
	private Node deleteNode(Node node, E e) {
		// 如果节点是空则return
		if (node == null) { // 如果节点为空则返回
			return null;
		}
		if (node.e.compareTo(e) > 0) {// 如果节点大于数据则递归左子树
			node.leftNode = deleteNode(node.leftNode, e);
		} else if (node.e.compareTo(e) < 0) {// 如果节点小于数据则递归右子树
			node.rightNode = deleteNode(node.rightNode, e);
		} else { // 否则找到该节点，现在进行删除
			size--;
//			//方法一
//			if (node.leftNode == null && node.rightNode == null) { // 为叶子节点直接删除
//				node = null;
//			}
//			// 只有单侧树，则直接让该侧的子树直接替换，因为该节点的节点为该最大或最小值
//			// 右子树为空，直接让左子树替换
//			else if (node.leftNode != null && node.rightNode == null) {
//				node = node.leftNode;
//			}
//			// 左子树为空，直接让右子树替换
//			else if (node.leftNode == null && node.rightNode != null) {
//				node = node.rightNode;
//			}
			// 方法二
			if (node.leftNode == null) {
				return node.rightNode;
			}
			if (node.rightNode == null) {
				return node.leftNode;
			} // 方法一二结束

			// 该节点的左右子树非空，此时进行有2种方法，向左找最大值进行替换，或者向右找最小值进行替换
			else { // 此方法是向右找最小值
					// 向右找最小值
				Node pnode = node.rightNode;
				// 最小值在最左边，往左遍历
				while (pnode.leftNode != null) {
					pnode = pnode.leftNode;
				}
				// 通过替换进行删除
				node.e = pnode.e;
				pnode = null;
				// 结束

				// 然后进行对pnode删除,所以传入的数据是pnode的e,
				// 因为目前的节点应该从右边开始,所以node.right变为当前的根节点所以传入node.right,
				// 再次向右递归删除

				// node.rightNode = deleteNode(node.rightNode, pnode.e);
			}
		}
		return node;
	}

	/**
	 * 查找节点
	 * 
	 * @Function @param e
	 */
	public void searchNode(E e) {
		if (searchNode(root, e) == true) {
			System.out.println("找到" + e);
			return;
		}
		System.out.println("没找到" + e);
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
			System.out.print(node.e + " ");
			inorder(node.rightNode);
		}
	}



	/**
	 * 层次遍历
	 * 
	 * @Function
	 */
	public void level() {
		System.out.print("层次遍历:");
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
