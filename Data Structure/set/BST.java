package set;
/**
 * 
 * @Description: <Function>
 * @author  karlieswift
 * @date 2020��4��21��
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
	 * ɾ���ڵ�
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