package datastructure;
/**
 *
 * @author Rajmani Arya
 */
public class CuttingTheRod {
    
    public static void main(String[] args) {
        int cost_table[] = {0 , 1, 5, 8, 9, 10, 17, 17, 20};
        int no_of_parts = 8;
        int[] look_up_table = new int[cost_table.length];
        for(int i=1; i <= no_of_parts; i++) {
            findcost(cost_table, look_up_table, i);
        }
        for(int i=1; i<look_up_table.length; i++) {
            System.out.printf("no. of part %d and max cost %d \n", i, look_up_table[i]);
        }
    }
    static void findcost(int[] cost_table, int[] look_up_table, int parts) {
        int max = 0, sum;
        for (int i = 1; i <= parts; i++) {
            if(i != parts)
                sum = cost_table[i] + look_up_table[parts-i];
            else
                sum = cost_table[i];
            if(sum > max)
                max = sum;
        }
        look_up_table[parts] = max;
    }
}
