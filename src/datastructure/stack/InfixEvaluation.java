package datastructure.stack;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class InfixEvaluation {
    /**
     * 
     * @param expression give valid infix expression
     * @return equivalent result
     */
    public static int evaluate(String expression){
        int result=0;
        char[] str = expression.toCharArray();
        /**
         * Take Two Stack One for number and another for Operator
         */
        Stack_LinkedList<Integer> Sint = new Stack_LinkedList<>();
        Stack_LinkedList<Character> Schar = new Stack_LinkedList<>();
        for(char ch:str){
            if(Character.isAlphabetic(ch) || Character.isDigit(ch))
                Sint.push((int)ch-48); //converts into number
            else
                Schar.push(ch);
        }
        return result;
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
    }
}
