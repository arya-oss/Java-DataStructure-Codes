package datastructure.tree;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class TreeTraversal extends BSTree {

    public TreeTraversal() {
        super();
    }
    /**
     * 
     * @param root print in-order traversal
     */
    private void inorder1(node root){
       if(root == null) return;
        inorder1(root.left);
        System.out.print(" "+root.data);
        inorder1(root.right);
    }
    /**
     * 
     * @param root print in-order traversal
     */
    private void preorder1(node root){
       if(root == null) return;
        System.out.print(" "+root.data);
        preorder1(root.left);
        preorder1(root.right);
    }
    /**
     * 
     * @param root print in-order traversal
     */
    private void postorder1(node root){
       if(root == null) return;
        postorder1(root.left);
        postorder1(root.right);
        System.out.print(" "+root.data);
    }
    /**
     * this method calls in-order1(@param root)
     * and print in-order traversal
     */
    @Override
    public void inorder(){
        inorder1(this.root);
    }
    /**
     * this method calls pre-order1(@param root)
     * and print pre-order traversal
     */
    public void preorder(){
        preorder1(this.root);
    }
    /**
     * this method calls post-order1(@param root)
     * and print post-order traversal
     */
    public void postorder(){
        postorder1(this.root);
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
       TreeTraversal t = new TreeTraversal();
       t.insert(7);
       t.insert(4);
       t.insert(6);
       t.insert(2);
       t.insert(10);
       t.insert(8);
       t.insert(12);
       System.out.print("\nInorder Traversal : ");
       t.inorder();
       System.out.print("\nPreorder Traversal : ");
       t.preorder();
       System.out.print("\nPostorder Traversal : ");
       t.postorder();
    }
}
