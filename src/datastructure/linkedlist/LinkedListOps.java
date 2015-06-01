package datastructure.linkedlist;

/**
 * @param <T>
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public interface LinkedListOps <T> {

    public void pushFront(T data);
    public void pushEnd(T data);
    public T popFront() throws Exception;
    public T popEnd() throws Exception;
    public void insert(T data, int pos) throws Exception;
    public void delete(int pos) throws Exception;
    public T get(int pos) throws Exception;
    public void print();
}
