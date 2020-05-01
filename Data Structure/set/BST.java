package set;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020年4月21日
 * @version "13.0.1"
 */
public class BST<E extends Comparable<E>> {

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
	 * 删除节点
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