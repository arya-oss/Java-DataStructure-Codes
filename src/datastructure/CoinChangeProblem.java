package datastructure;

/**
 * Problem Statement :- 
 * Minimum no. of coin required to get the price
 * where coins are given from 1 to N
 * 
 * @see www.rajmani1995.github.io
 * @author Rajmani Arya
 */
public class CoinChangeProblem {
    
    public static void main(String[] args) {
        int N = 35;
        final int M=4;
        int S[] = {1, 2, 5, 10};
        int look_up[] = new int[N+1];
        look_up[0]=1;
        for(int i=0; i<M; i++) {
            for(int j=S[i]; j<=N; j++) {
                look_up[j] = look_up[j-S[i]];
            }
        }
        System.out.println(look_up[N]);
    }
}
