package datastructure.tree;
import java.util.Comparator;

/**
 * 
 * @author Rajmani Arya
 * Generic AVL Tree implementation.
 * AVL tree is an advanced data structure.
 * it is Height balanced Binary Search Tree
 * for more details @see http://en.wikipedia.org/wiki/AVL_tree
 * @param <T>
 */
public class AvlTree<T extends Comparable<T>> {
	/**
	 * Main method for testing of AVL Tree
	 * @param args
	 */
	public static void main(String[] args) {
		AvlTree<Integer> tree = new AvlTree<>();
		tree.insert(1);
		tree.insert(3);
		tree.insert(2);
		tree.levelorder();
	}
	/**
	 * prints level order traversal of AVL tree
	 */
	public void levelorder() {
		int height = getHeight(root);
		for (int i = 0; i <= height; i++) {
			levelordertraversal(root, i);
			System.out.println("");
		}
	}
	/**
	 * helper method to print level order travesal height by height
	 * root height is zero
	 * @param root
	 * @param level
	 */
	private void levelordertraversal(Node<T> root, int level) {
		if(root == null) return;
		if(level == 0){
			System.out.print(" "+root.data);
		}else {
			levelordertraversal(root.left, level-1);
			levelordertraversal(root.right, level-1);
		}
	}
	/**
	 * Inserts a node into avl tree
	 * if it is duplicate then it can't be inserted
	 * @param data
	 */
	public void insert(T data){
		root = insert(root, data);
	}
	/**
	 * 
	 * @param root is the parent of all node
	 * @param data is to be inserted into the tree
	 * @return root after insertion
	 * <p>First insert data according to BST, After this 
	 * getBalance factor for the root node if it is > 1 (i.e, == 2)
	 * then Left-Left or Left-Right takes place based on comparison
	 * between inserting data and root left node data.
	 * similarly for right side if Balance factor < -1 (i.e, == -2)
	 * then Right-Right or Right-Left rotation takes place
	 * </p>
	 */
	private Node<T> insert(Node<T> root, T data) {
		if(root == null) {
			++size;
			return new Node<T>(data);
		}
		if(compare(root.data, data) > 0) 
			root.left = insert(root.left, data);
		
		else if(compare(root.data, data) < 0)
			root.right = insert(root.right, data);
		
		if(getBalance(root) == 2) {
			if(compare(root.left.data, data) < 0)
				root = SLeftRotation(root);
			else
				root = DLeftRotation(root);
		} 
		else if(getBalance(root) == -2) {
			if(compare(data, root.right.data) > 0)
				root = SRightRotation(root);
			else
				root = DRightRotation(root);
		}
		return root;
	}
	/**
	 * 
	 * Default Constructor for tree
	 */
	public AvlTree() {
		this.size = 0;
		this.root = null;
		this.comparator = null;
	}
	/**
	 * 
	 * @param root takes a node as parameter
	 * @return height difference of both node i.e, Balance Factor
	 *  height(left) - height(right)
	 */
	private int getBalance(Node<T> root) {
		return getHeight(root.left)-getHeight(root.right);
	}
	/**
	 * @param Node
	 * @return returns Height of the Node
	 */
	private int getHeight(Node<T> root) {
		if(root == null) return -1;
		return 1+Math.max(getHeight(root.left), getHeight(root.right));
	}
	/**
	 * print in-order traversal of tree
	 */
	public void inorder() {
		inorderUtil(root);
	}
	/**
	 * @param root in-order call this method with parameter root.
	 *  to print inorder traversal.
	 */
	/**
	 * Helper method to print in-order traversal
	 * @param root
	 */
	private void inorderUtil(Node<T> root) {
		if(root == null) return;
		inorderUtil(root.left);
		System.out.print(" "+root.data.toString());
		inorderUtil(root.right);
	}
	/**
	 * Left-Left rotation case
	 * @param root to be rotate
	 * @return modified node
	 */
	private Node<T> SLeftRotation(Node<T> root) {
		Node<T> _tmp = root.left;
		root.left = _tmp.right;
		_tmp.right = root;
		return _tmp;
	}
	/**
	 * Right-Right rotation case
	 * @param root to be rotate
	 * @return modified node
	 */
	private Node<T> SRightRotation(Node<T> root) {
		Node<T> _tmp = root.right;
		root.right = _tmp.left;
		_tmp.left = root;
		return _tmp;
	}
	/**
	 * Left-Right rotation case
	 * @param root to be rotate
	 * @return modified node
	 */
	private Node<T> DLeftRotation(Node<T> root) {
		root.left = SRightRotation(root.left);
		root = SLeftRotation(root);
		return root;
	}
	/**
	 * Right-Left rotation case
	 * @param root to be rotate
	 * @return modified node
	 */
	private Node<T> DRightRotation(Node<T> root) {
		root.right = SLeftRotation(root.right);
		root = SRightRotation(root);
		return root;
	}
	/**
	 * @return Size of the tree
	 */
	public int getSize() {
		return size;
	}
	/**
	 * 
	 * @param x first generic parameter 
	 * @param y second generic parameter
	 * @return compares both data if comparator is null
	 * then compares default comparison
	 * otherwise compares according to user-defined comparator
	 */
	private int compare(T x, T y) {
		if(comparator == null)
			return x.compareTo(y);
		else
			return comparator.compare(x, y);
	}
	/**************************
	 *  Variable Declaration  *
	 **************************/
	private int size;
	private Node<T> root;
	private Comparator<T> comparator;
	/**
	 * 
	 * @author Rajmani Arya
	 * Node class of a Generic AVL Tree
	 * @param <T>
	 */
	@SuppressWarnings("hiding")
	class Node <T> {
		T data;
		Node<T> left, right;
		/**
		 * constructor for Node
		 * @param data
		 * @param left
		 * @param right
		 */
		Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		Node(T data) {
			this(data, null, null);
		}
		/**
		 * @return String format of data
		 */
		@Override
		public String toString() {
			return data.toString();
		}
	}
}
