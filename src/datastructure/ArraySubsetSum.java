package datastructure;

/**
 *
 * @author Rajmani Arya
 */
public class ArraySubsetSum {
    public static boolean isSubsetSum(int[] A,int size, int sum) {
        if(size<1)
            return false;
        if(sum == 0) return true;
        if(sum > A[size-1])
            return isSubsetSum(A, size-1, sum);
        else if(sum < A[size-1])
            return isSubsetSum(A, size-1, sum-A[size-1])||isSubsetSum(A, size-1, sum);
        else
            return true;
    }
    public static void main(String[] args) {
        int A[]={1, 5, 9, 4, 17};
        if(isSubsetSum(A, 5, 26)){
            System.out.println("Sum is present");
        } else 
            System.out.println("Sum is not present");
    }
}
