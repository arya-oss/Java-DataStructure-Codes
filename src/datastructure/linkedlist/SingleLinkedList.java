package datastructure.linkedlist;

/**
 * @param <T>
 * @see www.rajmani1995.blogspot.com
 * @author rajmani
 */
public class SingleLinkedList <T> implements LinkedListOps<T>{
    lnode<T> head;
    int length;
    public SingleLinkedList() {
        head = null;
        length = 0;
    }
    /**
     * Function that prints each element of Linked List
     */
    @Override
    public void print(){
        lnode tmp=head;
        System.out.println("The Given List is :- ");
        while (tmp != null) {            
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
    }
    /**
     * 
     * @param data inserted in front of List
     */
    @Override
    public void pushFront(T data){
        lnode<T> t = new lnode<>(data);
        if(head == null)
            head = t;
        else{
            t.next = head;
            head = t;
        }
        ++length;
    }
    /**
     * 
     * @param data inserted at end of Linked List
     */
    @Override
    public void pushEnd(T data){
        lnode tmp = head;
        lnode<T> t = new lnode<>(data);
        if(head == null){
            head = t; ++length;
            return;
        }
        while(tmp.next != null)
            tmp = tmp.next;
        tmp.next = t;
        ++length;
    }
    /**
     * 
     * @return front element from linked list
     * @throws Exception 
     */
    @Override
    public T popFront() throws Exception{
        T tmp;
        if(head == null){
            throw new Exception("Head is Null, Can't Popped !");
        }
        tmp = head.data;
        head = head.next;
        --length;
        return tmp;
    }
    /**
     * @return end elements from linked list
     * @throws Exception 
     */
    @Override
    public T popEnd() throws Exception{
        T tmp; lnode<T> t = head;
        if(head == null){
            throw new Exception("Head is Null, Can't Popped !");
        }
        if(head.next == null){
            tmp = head.data;
            head = null;
            --length;
            return tmp;
        }
        while(t.next.next != null)
            t = t.next;
        tmp = (T) t.data;
        t.next = null;
        --length;
        return tmp;
    }
    /**
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        SingleLinkedList<Integer> L = new SingleLinkedList<>();
        L.pushFront(5);
        L.pushFront(4);
        L.pushFront(3);
        L.pushEnd(2);
        L.insert(1, 2);
        L.print();
    }
    /**
     * @param data
     * @param pos
     * @throws Exception 
     */
    @Override
    public void insert(T data, int pos) throws Exception {
        if(pos > length || pos < 1)
            throw new Exception("List size is less than given position");
        else{
            lnode<T> tmp=head;
            while(pos-- != 1)
                tmp = tmp.next;
            lnode<T> t = new lnode<>(data);
            t.next=tmp.next;
            tmp.next=t;
        }
    }
    /**
     * @param pos
     * @throws Exception 
     */
    @Override
    public void delete(int pos) throws Exception {
        
    }
    /**
     * @param pos
     * @return 
     * @throws Exception
     */
    @Override
    public T get(int pos) throws Exception{
        T tmp=null;
        if(pos > length || pos < 0)
            throw new Exception("List size is less than given position");
        else{
            lnode<T> t=head;
            while(pos-- != 1)
                t = t.next;
            tmp=t.data;
        }
        return tmp;
    }
}
