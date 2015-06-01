package datastructure.linkedlist;
/**
 * node of a Singly Linked List
 * @author rajmani arya
 * @param <T> 
 */
public class lnode<T>{
    T data;
    lnode next;

    public lnode() {
        next = null;
    }

    public lnode(T data, lnode next) {
        this.data = data;
        this.next = next;
    }
    public lnode(T data) {
        this.data = data;
        this.next = null;
    }
}