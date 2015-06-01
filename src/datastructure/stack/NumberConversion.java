package datastructure.stack;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class NumberConversion {
    /**
     * 
     * @param num takes decimal number as parameter
     * @return binary equivalent
     */
    static String decimalToBinary(int num){
        String tmp="";
        StackArray s = new StackArray();
        while(num != 0) {
            s.push(num%2);
            num /= 2;
        }
        while(!s.empty())
            tmp += s.pop();

        return tmp;
    }
    /**
     * 
     * @param num takes decimal number as parameter
     * @return octal equivalent
     */
    static String decimalToOctal(int num){
        String tmp="";
        StackArray s = new StackArray();
        while(num != 0) {
            s.push(num%8);
            num /= 8;
        }
        while(!s.empty()){
            tmp += s.pop();
        }
        return tmp;
    }
    /**
     * 
     * @param num takes decimal number as parameter
     * @return Hexadecimal equivalent
     */
    static String decimalToHex(int num){
        String tmp="";  int choice;
        StackArray s = new StackArray();
        while(num != 0) {
            s.push(num%16);
            num /= 16;
        }
        while(!s.empty()){
            choice = s.pop();
            if(choice < 10)
                tmp += choice;
            else
            switch(choice) {
                case 10:
                    tmp += 'A';
                    break;
                case 11:
                    tmp += 'B';
                    break;
                case 12:
                    tmp += 'C';
                    break;
                case 13:
                    tmp += 'D';
                    break;
                case 14:
                    tmp += 'E';
                    break;
                case 15:
                    tmp += 'F';
                default:
            }
        }
        return tmp;
    }
    
    public static void main(String[] args) {
        int num = 255;
        System.out.println("Given Decimal Number is "+num);
        System.out.println("Binary Equvalent : "+decimalToBinary(num));
        System.out.println("Hexadecimal Equvalent : "+decimalToHex(num));
        System.out.println("Octal Equvalent : "+decimalToOctal(num));
    }
}
