package set;

public class BSTSet<E extends Comparable<E>> implements MySet<E>{

	private BST<E> bst=new BST<>();
	@Override
	public void add(E e) {
		bst.add(e);
		
	}

	@Override
	public void remove(E e) {
	
		bst.remove(e);
		
	}

	@Override
	public boolean contains(E e) {
		return bst.searchNode(e);
	}

	@Override
	public int getSize() {
		 
		return bst.size();
	}

	@Override
	public boolean isEmpty() {
		 
		return bst.isempty();
	}

}
