package datastructure.sorting;

/**
 * @see www.rajmani1995.blogspot.com
 * @author rajmani arya
 */
public class BinarySearch {
    /**
     * 
     * @param A     reference of array
     * @param start starting index of array
     * @param end   ending index of array
     * @param num   number which is to be searched
     * @return      true or false
     */
    public static boolean binarysearch(int[] A, int start, int end, int num){
        if(start > end) return false;
        int mid=(start+end)/2;
        return (A[mid]==num)|| binarysearch(A, start, mid-1, num) 
                ||binarysearch(A, mid+1, end, num);
    }
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        int [] A = { 5, 1, 3, 9, 0, 8, 2, 7, 4, 6};
        BubbleSort.bubblesort(A, A.length);
        for(int i:A)
            System.out.print(i+" ");
        System.out.println(binarysearch(A, 0, A.length-1, 15));
    }

}
