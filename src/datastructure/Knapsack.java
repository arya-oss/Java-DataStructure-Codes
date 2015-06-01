package datastructure;

import java.util.Arrays;

/**
 * We have n objects, each with weight wi and profit pi.
 * The knapsack has capacity M. maximize the profit
 * @author Rajmani Arya
 */
public class Knapsack {
    
    public static void main(String[] args) {
        Item[] item = {new Item(2,4), new Item(4, 6), new Item(2, 5), new Item(3, 5)};
        double projectSet[] = new double[item.length];
        int capacity = 7;
        int i;
        Arrays.sort(item);
        for(i=0; i<item.length; i++){
            projectSet[i]=0.0;
            if(item[i].weight > capacity)
                break;
            projectSet[i]=1.0;
            capacity -= item[i].weight;
        }
        if(i < item.length)
            projectSet[i] = (double)capacity/item[i].weight;
        
        double profit=0.0;
        for(i=0;i<item.length; i++)
            profit += projectSet[i]*item[i].profit;
        
        System.out.println("Profit : "+profit);
    }
    static class Item implements Comparable{
        int weight;
        int profit;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
        public double ratio(){
            return (double)profit/weight;
        }

        @Override
        public int compareTo(Object obj) {
            Item i = (Item)obj;
            if(ratio() == i.ratio())
                return 0;
            return ratio()>i.ratio() ? -1 : 1;
        }
        @Override
        public String toString(){
            return weight+ " "+profit;
        }
    }
}
