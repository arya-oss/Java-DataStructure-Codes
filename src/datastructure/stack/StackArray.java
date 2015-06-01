package datastructure.stack;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class StackArray {
    
    private int [] element;
    private int top;
    private final int MAX_SIZE=100;

    public StackArray() {
        element = new int[MAX_SIZE];
        top = -1;
    }
    
    public boolean empty(){
        return top == -1;
    }
    
    public void push(int data){
        if( top == MAX_SIZE-1 ){
            throw new Error("Stack Overflow !");
        }
        element[++top] = data;
    }
    
    public int pop(){
        if(empty()){
            throw new Error("Stack Underflow !");
        }
        return element[top--];
    }
    
    public int peek(){
        if(empty()){
            throw new Error("Stack Underflow !");
        }
        return element[top];
    }
    
    public static void main(String[] args) {
        StackArray s = new StackArray();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.empty()) {            
            System.out.print(" "+s.pop());
        }
    }
}
