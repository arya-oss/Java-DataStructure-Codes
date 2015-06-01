package datastructure.stack;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class ParenthesisCheck {
    private Stack_LinkedList<Character> S;
    /**
     * default constructor
     */
    public ParenthesisCheck() {
        S = new Stack_LinkedList<>();
    }
    /**
     * 
     * @param s takes string as parameter only check 
     * () {} [] <>
     * @return whether parenthesis is valid or not
     */
    public boolean isValid(String expression){
        S.clear();
        char[] str = expression.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if(str[i] == '(' || str[i] == '{' || str[i] == '['  || str[i] == '<' )
                S.push(str[i]);
            else{
                switch(str[i]){
                    case ')':
                        if(S.peek().equals('('))
                            S.pop();
                        else return false;
                        break;
                    case '}':
                        if(S.peek().equals('{'))
                            S.pop();
                        else return false;
                        break;
                    case ']':
                        if(S.peek().equals('['))
                            S.pop();
                        else return false;
                        break;
                    case '>':
                        if(S.peek().equals('<'))
                            S.pop();
                        else return false;
                        break;
                    default:
                }
            }
        }
        return S.empty();
    }
    public static void main(String[] args) {
        ParenthesisCheck ps = new ParenthesisCheck();
        String[] ss = { "<>{()[]]}()", "<><><<><>>", "<<>>{(}{)}", "[({{}<>})]"};
        for (String s : ss) {
            if (ps.isValid(s)) {
                System.out.println(s + " is Valid !");
            } else {
                System.out.println(s + " is NOT Valid !");
            }
        }
    }
}
