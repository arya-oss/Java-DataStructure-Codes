package datastructure.linkedlist;

/**
 * node of doubly Linked List
 * @see www.rajmani1995.blogspot.com
 * @author rajmani
 */
public class dnode <T> extends lnode{
    dnode prev;
    public dnode() {
        prev = null;
    }

    public dnode(T data) {
        super(data);
        prev = null;
    }

    public dnode(dnode prev, T data, lnode next) {
        super(data, next);
        this.prev = prev;
    }
    
    
}
