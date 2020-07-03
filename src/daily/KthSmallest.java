package daily;

import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[][]matrix,int k){
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                maxHeap.add(matrix[i][j]);
            }
        }
        int len = n * n;
        for (int i = 0;i < len - k;i++){
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
    public int kthSmallestII(int[][]matrix,int k){
        int n = matrix.length - 1;
        int left = matrix[0][0];
        int right = matrix[n][n];
        while (left < right){
            int mid = (left + right) >>> 1;
            int count = countLess(matrix,mid,n);
            if (count < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    private int countLess(int[][]matrix,int mid,int n){
        int count = 0;
        int x = 0, y = n;
        while (x <= n && y >= 0){
            if (matrix[y][x] <= mid ){
                count += y + 1;
                x++;
            }
            else {
                y--;
            }
        }
        return count;
    }
}
