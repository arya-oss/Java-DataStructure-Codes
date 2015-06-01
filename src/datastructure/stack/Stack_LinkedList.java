package datastructure.stack;

/**
 * @see mailto:arajmani@student.nitw.ac.in
 * @author rajmani
 */
public class Stack_LinkedList <T>{
    class node{
        T data;
        node next;
        node(){ next = null; }
    }
    node head;
    
    public Stack_LinkedList() { head = null; }
    /**
     * 
     * @param data push a data into stack
     */
    public void push(T data){
        node tmp;
        tmp = new node();
        tmp.data = data;
        if(head == null) head = tmp;
        else{
            tmp.next = head;
            head = tmp;
        }
    }
    /**
     * pop out top elements from stack
     */
    public void pop(){
        if(empty())
            throw new UnsupportedOperationException("Stack Underflow !");
        head = head.next;
    }
    /**
     * 
     * @return top element from stack 
     */
    public T peek(){
        if(empty())
            throw new UnsupportedOperationException("Stack Underflow !");
        return head.data;
    }
    /**
     * tells whether the stack is empty or not
     * @return true or false
     */
    public boolean empty(){
        return head == null;
    }
    /**
     * clears the stack
     */
    public void clear(){
        head = null;
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Stack_LinkedList<String> S = new Stack_LinkedList<>();
        S.push("Hello");
        S.push("Arya");
        S.push("Mani");
        S.push("Raj");
        while(!S.empty()){
            System.out.println(S.peek());
            S.pop();
        }
    }
}
