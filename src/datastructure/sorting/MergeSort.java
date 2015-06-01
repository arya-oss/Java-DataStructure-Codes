package datastructure.sorting;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class MergeSort {
    /**
     * 
     * @param A reference to array
     * @param size size of array
     */
    public static void mergesort(int[] A, int low, int high){
        int mid;
        if(low < high){
            mid = (low+high)/2;
            mergesort(A, low, mid);
            mergesort(A, mid+1, high);
            merge(A, low, mid, high);
        }
        return;
    }
    /**
     * 
     * @param A reference to array which is to be merged
     * @param low lower index of first part
     * @param mid higher index of first part
     * @param high higher index of second part
     */
    private static void merge(int[] A,int low, int mid, int high){
        int i = low;
        int k = low;
        int j = mid+1;
        int [] tmp = new int[50];
        while( i<= mid && j <= high){
            if(A[i] < A[j])
                tmp[k++] = A[i++];
            else
                tmp[k++] = A[j++];
        }
        while(i <= mid)
            tmp[k++] = A[i++];
        while( j<= high)
            tmp[k++] = A[j++];
        System.arraycopy(tmp, low, A, low, k - low);
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        int [] A = { 5, 1, 3, 9, 0, 8, 2, 7, 4, 6};
        mergesort(A, 0, A.length-1);
        for(int i:A)
            System.out.print(i+" ");
    }
}
