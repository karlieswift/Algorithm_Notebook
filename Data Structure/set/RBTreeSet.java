package set;

public class RBTreeSet<E extends Comparable<E>> implements MySet<E> {
	private RBTree <E> tree=new RBTree<>();

	@Override
	public void add(E e) {
		tree.add(e);
	}

	@Override
	public void remove(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	 
 
}
