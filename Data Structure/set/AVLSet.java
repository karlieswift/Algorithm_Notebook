package set;

public class AVLSet<E extends Comparable<E>> implements MySet<E> {
	private AVL<E> avl=new AVL<>();

	@Override
	public void add(E e) {
		avl.add(e);
	}

	@Override
	public void remove(E e) {
		avl.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return avl.searchNode(e);
	}

	@Override
	public int getSize() {
		return avl.size();
	}

	@Override
	public boolean isEmpty() {
		return avl.isempty();
	}

}
