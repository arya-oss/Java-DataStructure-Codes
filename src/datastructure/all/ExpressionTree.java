package datastructure.all;
import datastructure.stack.*;
import java.util.Stack;
/**
 * @see www.rajmani1995.github.io
 * @author Rajmani Arya
 * @version 1.0.0.1
 */
public class ExpressionTree {
    
    public static void main(String[] args) {
        ExpressionTree et = new ExpressionTree();
        String expression="2*3+4/2+5-2*8";
        et.evaluate(expression);
        et.inorder();
        System.out.println(et.eval());
    }
    public void evaluate(String expression) {
        Stack<Node> stack = new Stack<>();
        Node _tmp, _tmp1, _tmp2;
        expression = intopost.convert(expression);
         System.out.println(expression);
         for(int i=0; i<expression.length(); i++) {
             char ch = expression.charAt(i);
             if(!Character.isLetterOrDigit(ch)){
                 _tmp1 = stack.pop();
                 _tmp2 = stack.pop();
                 _tmp = new Node(ch);
                 _tmp.left = _tmp2;
                 _tmp.right = _tmp1;
                 stack.push(_tmp);
             } else {
                 stack.push(new Node(ch));
             }
         }
         head = stack.pop();
    }
    public void inorder() {
        System.out.println("Infix expression of Tree :-> ");
        inorder(head);
        System.out.println("");
    }
    private void inorder(Node head) {
        if(head == null) return;
        inorder(head.left);
        System.out.print(head.data);
        inorder(head.right);
        
    }
    public int eval() {
        System.out.print("Value of Expression : ");
        return evaluate(head);
    }
    private int evaluate(Node head) {
        if(head != null) {
            if(Character.isDigit(head.data)) {
                return (int)head.data-48;
            } else {
                return operate(evaluate(head.left), head.data, evaluate(head.right));
            }
        }
        return 0;
    }
    class Node {
        char data;
        Node left, right;
        Node(char data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    int operate(int opd1,char opr,int opd2)
    {
        switch(opr){
        case '+':
            opd1 = opd1+opd2;
            break;
        case '-':
            opd1 = opd1-opd2;
            break;
        case '*':
            opd1 = opd1*opd2;
            break;
        case '/':
            if(opd2!=0)
                opd1 = opd1/opd2;
            break;
        }
        return opd1;
    }
    // Variable Declaration
    private final InfixToPostfix intopost = new InfixToPostfix();
    private Node head;
}
