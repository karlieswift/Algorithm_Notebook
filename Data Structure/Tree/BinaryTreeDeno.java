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
 * 1-递归创建函数  输入数据 6 2 1 0 0 0 7 3 0 0 0
 * 2-searchAncestor(int a,int b)查找两个节点的最近公共父节点
 * 3-先序遍历递归与非递归  6 2 1 7 3
 * 4-中序遍历递归与非递归 1 2 6 3 7
 * 5-后序遍历递归与非递归 1 2 3 7 6
 * 6-层次遍历6 2 7 1 3 
 * 7-删除
 * 8-查找    
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月15日
 * @version "13.0.1"
 */
public class BinaryTreeDeno {

	public static void main(String[] args) {
		BiTree tree = new BiTree();

		//int arr[] = { 6, 2, 1, 0, 0, 0, 7, 3, 0, 0, 8, 0, 0 };
		 int arr[] = { 6, 2, 1, 0, 0, 0, 7, 3, 0, 0, 0 };
		// System.out.println("输入节点0代表空节点:");
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
		System.out.print("删除节点7：");
		tree.del(7);
		tree.postorder();

//	    
	}
}

//创建二叉树的节点Node
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

//创建二叉树
class BiTree {
	private Node root;

	public BiTree() {

	}

	// 递归创建树0代表树的该节点为空
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
	 * 查找两个节点的最近公共父节点，这里用元素测试
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
				p = stack.peek();// 取栈顶元素
				if (p.rchildNode != null && p.rchildNode != r) { // 右子树不空，且没有被访问
					p = p.rchildNode;// 右子树
					stack.push(p);
					p = p.lchildNode;// 再次看当前p的左子树，p当成root
				} else {// p.rchildNode==r代表p左子树被访问过，当前节点p第三次被访问，p.rchildNode被访问过
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
	 * 先序遍历结果递归
	 */
	public void preorder() {
		System.out.print("先序遍历:");
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
	 * 中序序遍历结果递归
	 */
	public void inorder() {
		System.out.print("中序遍历:");
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
	 * 后序遍历结果递归
	 */
	public void postorder() {
		System.out.print("后序遍历:");
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
	 * 先序遍历结果非递归
	 */
	public void preorder1() {
		System.out.print("先序遍历非递归:");
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);// 根进入
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.rchildNode != null) {// 栈的特点，先让右子树进去，后出来
				stack.push(temp.rchildNode);
			}
			if (temp.lchildNode != null) {// 栈的特点，左子树后进去，先出来
				stack.push(temp.lchildNode);
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
				p = p.lchildNode;
			} else {
				p = stack.pop();// 找到最左边，弹出p的父节点即栈顶给p
				System.out.print(p.data + " ");// 访问p
				p = p.rchildNode;// 向右走
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
				p = p.lchildNode;
			} else {
				p = stack.peek();// 取栈顶元素
				if (p.rchildNode != null && p.rchildNode != r) { // 右子树不空，且没有被访问
					p = p.rchildNode;// 右子树
					stack.push(p);
					p = p.lchildNode;// 再次看当前p的左子树，p当成root
				} else {// p.rchildNode==r代表p左子树被访问过，当前节点p第三次被访问，p.rchildNode被访问过
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
			System.out.print(p.data + " ");
			if (p.lchildNode != null) {
				queue.add(p.lchildNode);
			}
			if (p.rchildNode != null) {
				queue.add(p.rchildNode);
			}
		}

	}

	// 查询：查找成功返回节点，否则返回空
	public void search(int data) {
		if (search(root, data)) {
			System.out.println("找到" + data);
		} else {
			System.out.println("没找到" + data);
		}
	}

	private boolean search(Node node, int data) {
		if (node.data == data) { // 如果查到数据就返回非空
			return true;
		} else {
			if (node.lchildNode != null) { // 左子树不空，递归左子树
				return search(node.lchildNode, data);
			}
			if (node.rchildNode != null) { // 右子树不空，递归右子树
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











