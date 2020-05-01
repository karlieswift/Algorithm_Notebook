package set;

import java.util.Random;

public class SetTest {

	public static void main(String[] args) {

		AVLSet<Integer> avlSet = new AVLSet<Integer>();
		BSTSet<Integer> bstSet = new BSTSet<Integer>();
		RBTreeSet<Integer> rbTree = new RBTreeSet<Integer>();
		Random random = new Random();
		long first = 0;
		long end = 0;
		System.out.println("添加元素：");

		first = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			// bstSet.add(i);
			bstSet.add(random.nextInt(10000000));
		}
		end = System.currentTimeMillis();
		System.out.println("bst " + (end - first));

		first = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			avlSet.add(random.nextInt(10000000));
		}
		end = System.currentTimeMillis();
		System.out.println("avl " + (end - first));

		first = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			rbTree.add(random.nextInt(10000000));
		}
		end = System.currentTimeMillis();
		System.out.println("rbtree " + (end - first));

		System.out.println("添加元素：");
		first = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			bstSet.add(i);

		}
		end = System.currentTimeMillis();
		System.out.println("bst " + (end - first));
		first = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			avlSet.add(i);
		}
		end = System.currentTimeMillis();
		System.out.println("avl " + (end - first));

		first = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			rbTree.add(i);
		}
		end = System.currentTimeMillis();
		System.out.println("rbtree " + (end - first));
	}
}
