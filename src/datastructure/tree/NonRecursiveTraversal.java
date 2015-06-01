package datastructure.tree;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */

public class NonRecursiveTraversal {
    
    static void preorder(node root){
        node t;
        Stack<node> S=new Stack<>();
        S.push(root);
        while (!S.empty()) {            
            t = S.pop();
            System.out.print(" "+t.data);
            if(t.right != null) S.push(t.right);
            if(t.left != null) S.push(t.left);
        }
    }
    static void inorder(node root){
        node t;
        Stack<node> S=new Stack<>();
        t = root;
        while(true){
            if(t != null){
                S.push(t);
                t = t.left;
            }else{
                if(!S.empty()){
                    t = S.pop();
                    System.out.print(" "+t.data);
                    t = t.right;
                }else
                    break;
            }
        }
    }
    static void postorder(node root){
        node t = root;
        Stack<node> s = new Stack<>();
        while(true){
            while(t != null){
                if(t.right != null)
                    s.push(t.right);
                s.push(t);
                t = t.left;
            }
            t = s.pop();
            if(t.right != null && !s.empty() && s.peek() == t.right ){
                s.pop();
                s.push(t);
                t = t.right;
            }else{
                System.out.print(" "+t.data);
                t = null;
            }
            if(s.empty())
                break;
        }
    }
    static void levelorder(node root){
        node t=root;
        ArrayList<node> q=new ArrayList<>();
        q.add(t);
        while(!q.isEmpty()){
            t = q.remove(0);
            System.out.print(" "+t.data);
            if(t.left != null)
                q.add(t.left);
            if(t.right != null)
                q.add(t.right);
        }
    }
    public static void main(String[] args) {
        BSTree b = new BSTree();
        /**
         *       7
         *     /   \
         *    4    10
         *   / \   / \
         *  2   6 8  12
         */
        b.insert(7);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(8);
        b.insert(12);
        System.out.println("Inorder Traversal ");
        inorder(b.root);
        System.out.println("\nPreorder Traversal ");
        preorder(b.root);
        System.out.println("\nPostorder Traversal ");
        postorder(b.root);
        System.out.println("\nLevel order Traversal ");
        levelorder(b.root);
    }
    
}
