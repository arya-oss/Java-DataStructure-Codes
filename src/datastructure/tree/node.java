package datastructure.tree;
/**
 * node of tree
 */
public class node {
    int data;
    node left,right;
    node(){
        left = right = null;
    }
    node(int data){
        left = right = null;
        this.data = data;
    }

}