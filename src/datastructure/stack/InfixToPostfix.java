package datastructure.stack;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 * @since 01 Jan 2015
 */
public class InfixToPostfix {
    private Stack_LinkedList<Character> S;
    /**
     * Default Constructor
     */
    public InfixToPostfix() {
        S = new Stack_LinkedList<>();
    }
    /**
     * 
     * @param args do not give any arguments
     */
    public static void main(String[] args) {
        InfixToPostfix i = new InfixToPostfix();
        String s = "2*3-4/2";
        System.out.println(i.convert(s));
    }
    /**
     * 
     * @param infix takes parameter as valid infix string
     * @return equivalent postfix of expression
     */
    public String convert(String infix){
        S.clear();
        S.push('#');
        String post="";
        char [] str = infix.toCharArray();
        for(char ch : str){
            if(isalnum(ch)){
                post += ch;
            }
            else if(ch == ')'){
                while(!S.peek().equals('(')){
                    post += S.peek();
                    S.pop();
                }
                S.pop();
            }
            else{
                if(precedence(ch) > precedence(S.peek()))
                    S.push(ch);
                else{
                    post += S.peek();
                    S.pop();
                    S.push(ch);
                }
            }
        }
        while(!S.peek().equals('#')){
            post += S.peek();
            S.pop();
        }
        return post;
    }
    private int precedence(char ch){
        switch(ch){
            case '(':
                return 5;
            case '#':
                return 1;
            case '^':
                return 4;
            case '*':
            case '/':
                return 3;
            case '+':
            case '-':
                return 2;
            default:
                return 0;
        }
    }
    /**
     * 
     * @param ch character
     * @return whether it is alpha numeric or not
     */
    private boolean isalnum(char ch) {
        return (ch >= 48 && ch <= 57) || (ch >=65 && ch<=90) || (ch >= 97 && ch<=122);
    }
    
}
