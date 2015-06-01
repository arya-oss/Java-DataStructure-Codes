package datastructure.sorting;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class SelectionSort {
    /**
     * 
     * @param A    reference to an integer array
     * @param size size of array
     */
    public static void selectionsort(int[] A, int size){
        int pos=0;
        for (int i = 0; i < size; i++) {
            pos=i;
            for (int j = i+1; j < size; j++) {
                if(A[pos] > A[j])
                    pos = j;
            }
            if(pos != i){
                int t=A[pos];
                A[pos] = A[i];
                A[i]=t;
            }
        }
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        int [] A = { 5, 1, 3, 9, 0, 8, 2, 7, 4, 6};
        selectionsort(A, A.length);
        for(int i:A)
            System.out.print(i+" ");
    }
}
