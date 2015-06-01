package datastructure.all;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @version 1.0.0.1
 * @author Rajmani Arya
 */
public class HufffmanCoding {
    
    class Node {
        char data;
        int frequency;
        Node left, right;
        public Node(char data, int frequency) {
            this.data = data;
            this.frequency = frequency;
            this.left = this.right = null;
        }
    }
    public HufffmanCoding() {
        this.head = null;
    }
    public void Demo() {
        char words [] = { 'r', 'a', 'm', 's', 'k', 'n', 'p', 'e', 'd'};
        int frequency [] = { 2, 25, 3, 1, 7, 4, 9, 15, 17};
        ArrayList<Node> list;
        Node _tmp1, _tmp2, _tmp;
        list = new ArrayList<>();
        for(int i=0; i<9; i++) {
            list.add(new Node(words[i], frequency[i]));
        }
        while (list.size()!=1) {            
            _tmp1 = Collections.min(list, comp);
            list.remove(_tmp1);
            _tmp2 = Collections.min(list, comp);
            list.remove(_tmp2);
            _tmp = new Node('$',_tmp1.frequency+_tmp2.frequency);
            if(_tmp1.frequency < _tmp2.frequency){
                _tmp.left = _tmp1;
                _tmp.right = _tmp2;
            } else {
                _tmp.left = _tmp2;
                _tmp.right = _tmp1;
            }
            list.add(_tmp);
        }
        head = list.get(0);
    }
    /**
     * prints the huffmann code of each character
     */
    public void inorder() {
        int codes[] = new int[10];
        inorder(head, codes, 0);
    }
    
    private void inorder(Node T,int[] codes,int top) {
        if(T == null) return;
        if(T.left != null) {
            codes[top] = 0;
            inorder(T.left, codes, top+1);
        }
        
        if(T.left==null && T.right == null){
            System.out.print(T.data+" -> ");
            for(int i=0; i<top; i++)
                System.out.print(codes[i]);
            System.out.println("");
        }
        if(T.right != null) {
            codes[top]=1;
            inorder(T.right, codes, top+1);
        }
    }
    public static void main(String[] args) {
        HufffmanCoding hc = new HufffmanCoding();
        hc.Demo();
        hc.inorder();
    }
    private final Comparator<Node> comp = new Comparator<Node>() {

        @Override
        public int compare(Node t, Node t1) {
            if(t.frequency < t1.frequency)
                return -1;
            else if(t.frequency > t1.frequency)
                return 1;
            return 0;
        }
    };
    private Node head;
}
