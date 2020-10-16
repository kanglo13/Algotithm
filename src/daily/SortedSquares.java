package daily;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 9:38
 */
public class SortedSquares {
    public int[]sortedSquares(int[]A){
        int left = 0,right = A.length-1;
        int[]result = new int[right+1];
        int index = right;
        while (left <= right){
            if (A[left] * A[left] > A[right] * A[right]){
                result[index--] = A[left] * A[left];
                left++;
            }
            else {
                result[index--] = A[right] * A[right];
                right--;
            }
        }
        return result;
    }
}
