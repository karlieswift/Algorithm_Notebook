package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
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
	 * 递归添加元素
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
		if (node.e.compareTo(e) == 0) { // 如果已经有改数据就不插入
			return;
		}
		if (node.e.compareTo(e) > 0) {
			// 如果数据小于root插入左子树
			if (node.leftNode == null) { // 如果左孩子为空则直接插入
				size++;
				node.leftNode = new Node(e);
			} else { // 左子树不为空，则继续递归左子树
				insert1(node.leftNode, e);
			}
		}
 
		else { // 如果数据大于则插入右子树
			if (node.rightNode == null) {
				size++;
				// 如果右子树为空则直接插入
				node.rightNode = new Node(e);
			} else {
				// 如果右子树不为空则继续递归右子树
				insert1(node.rightNode, e);
			}
		}
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
		return node;
	}

	/**
	 * 查找两个节点的最近公共父节点，这里用元素测试
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
				p = stack.peek();// 取栈顶元素
				if (p.rightNode != null && p.rightNode != r) { // 右子树不空，且没有被访问
					p = p.rightNode;// 右子树
					stack.push(p);
					p = p.leftNode;// 再次看当前p的左子树，p当成root
				} else {// p.rchildNode==r代表p左子树被访问过，当前节点p第三次被访问，p.rchildNode被访问过
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
	 * 先序遍历结果递归
	 */
	public void preorder() {
		System.out.print("先序遍历:");
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
	 * 后序遍历结果递归
	 */
	public void postorder() {
		System.out.print("后序遍历:");
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
	 * 先序遍历结果非递归
	 */
	public void preorder1() {
		System.out.print("先序遍历非递归:");
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);// 根进入
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.e + " ");
			if (temp.rightNode != null) {// 栈的特点，先让右子树进去，后出来
				stack.push(temp.rightNode);
			}
			if (temp.leftNode != null) {// 栈的特点，左子树后进去，先出来
				stack.push(temp.leftNode);
			}
		}
		System.out.println();
	}

	/**
	 * 中序遍历结果非递归
	 */
	public void inorder1() {
		System.out.print("中序遍历非递归:");
		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {// 一直找到最左边
				stack.push(p);
				p = p.leftNode;
			} else {
				p = stack.pop();// 找到最左边，弹出p的父节点即栈顶给p
				System.out.print(p.e + " ");// 访问p
				p = p.rightNode;// 向右走
			}
		}
		System.out.println();
	}

	/**
	 * 后序遍历结果非递归1
	 */
	public void postorder1() {
		System.out.print("后序遍历非递归:");

		Stack<Node> stack = new Stack<Node>();
		Node p = root;
		Node r = null;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.leftNode;
			} else {
				p = stack.peek();// 取栈顶元素
				if (p.rightNode != null && p.rightNode != r) { // 右子树不空，且没有被访问
					p = p.rightNode;// 右子树
					stack.push(p);
					p = p.leftNode;// 再次看当前p的左子树，p当成root
				} else {// p.rightNode==r代表p左子树被访问过，当前节点p第三次被访问，p.rightNode被访问过
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
