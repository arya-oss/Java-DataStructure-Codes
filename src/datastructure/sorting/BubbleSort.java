package datastructure.sorting;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class BubbleSort {
    /**
     * 
     * @param A reference to integer array
     * @param size size of array
     */
    public static void bubblesort(int[] A, int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1-i; j++) {
                /**
                 * if previous element is greater then swap it
                 */
                if(A[j] > A[j+1]){
                    int t = A[j];
                    A[j] = A[j+1];
                    A[j+1] = t;
                }
            }
        }
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        int [] A = { 5, 1, 3, 9, 0, 8, 2, 7, 4, 6};
        bubblesort(A, A.length);
        for(int i:A)
            System.out.print(i+" ");
    }
}
