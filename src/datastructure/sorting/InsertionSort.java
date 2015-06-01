package datastructure.sorting;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class InsertionSort {
    /**
     * 
     * @param A reference to array
     * @param size size of array
     */
    public static void insertionsort(int[] A, int size){
        int j,k;
        for (int i = 1; i < size; i++) {
            k = A[i]; j=i-1;
            while( j>=0 && k < A[j]){
                A[j+1]=A[j]; j--;
            }
            A[j+1] = k;
        }
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        int [] A = { 5, 1, 3, 9, 0, 8, 2, 7, 4, 6};
        insertionsort(A, A.length);
        for(int i:A)
            System.out.print(i+" ");
    }
}
