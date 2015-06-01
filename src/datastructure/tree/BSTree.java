package datastructure.tree;

/**
 * @see mailto:arajmani@student.nitw.ac.in
 * @author rajmani arya
 */
public class BSTree {
    node root;
    /**
     * @param root give root of tree
     * @param data take parameter data
     * @return root of tree after inserting data recursively
     */
    private node insert1(node root, int data){
        if(root == null){
            root= new node();
            root.data = data;
            return root;
        }
        if(data < root.data){
            root.left = insert1(root.left, data);
        }
        else if(data > root.data){
            root.right = insert1(root.right, data);
        }
        return root;
    }
    /**
     * 
     * @param root print in-order traversal of root
     */
    private void print(node  root){
        if(root == null) return;
        print(root.left);
        System.out.print(" "+root.data);
        print(root.right);
    }
    /**
     * 
     * @param root takes parameter root of tree
     * @return height of tree
     */
    private int height1(node root){
        if(root == null) return 0;
        return 1+Math.min(height1(root.left),height1(root.right));
    }
    /**
     * 
     * @param root
     * @param lev prints given root level-by-level
     */
    private void printLevel(node root, int lev){
        if(root == null) return;
        if(lev==0)
            System.out.print(" "+root.data);
        else{
            printLevel(root.left, lev-1);
            printLevel(root.right, lev-1);
        }
    }
    /**
     * 
     * @param root
     * @return min valued node
     */
    private node  minLeft(node  root){
        node  tmp=root;
        if(tmp.left != null)
            tmp = tmp.left;
        return tmp;
    }
    /**
     * 
     * @param root recursive function for deleting the data
     * @param data
     * @return root
     */
    private node delete1(node root, int data){
        if(root == null) return null;
        if(root.data > data)
            root.left = delete1(root.left, data);
        else if(root.data < data)
            root.right = delete1(root.right, data);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            node  tmp = minLeft(root.right);
            root.data = tmp.data;
            root.right = delete1(root.right, tmp.data); 
        }
        return root;
    }
    /**
     * default constructor
     */
    public BSTree() { root = null; }
    /**
     * 
     * @param data inserts the data into the tree
     */
    public final void insert(int data){
        root = insert1(root, data);
    }
    /**
     * prints in-order traversal of tree 
     * note : this is sorted
     */
    public void inorder(){
        print(root);
    }
    /**
     * 
     * @return heights of the Tree
     */
    public int height(){
        int h = height1(root);
        return h;
    }
    
    /**
     * function prints the node of the tree level by level
     * recursively
     */
    public void levelorder(){
        int h = height1(root);
        for(int i=0; i<=h; i++){
            System.out.println("");
            printLevel(root, i);
        }
    }
    /**
     * 
     * @param data function delete the data if it is present in the tree
     */
    public final void remove(int data){
        root = delete1(root, data);
    }
    /**
     * 
     * @param args  no use of parameter arguments so don't give this parameter
     */
    public static void main(String[] args) {
        BSTree b = new BSTree();
        b.insert(7);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(8);
        b.insert(12);
        b.inorder();
        b.levelorder();
    }
}
