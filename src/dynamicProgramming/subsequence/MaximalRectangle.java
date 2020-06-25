package dynamicProgramming.subsequence;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {
    public int maximalRectangle(int[][]matrix){
        if (matrix.length == 0)
            return 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[]heights = new int[c];
        int maxArea = 0;
        for(int i = 0;i < r;i++){
            for (int j = 0;j < c;j++){
                if (matrix[i][j] == 1)
                    heights[j] += 1;
                else
                    heights[j] = 0;
            }
            maxArea = Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }
    private int largestRectangleArea(int[]heights){
        int n = heights.length;
        if (n == 0)
            return 0;
        else if (n == 1)
            return heights[0];
        int[]newHeights = new int[n+2];
        int res = 0;
        newHeights[0] = 0;
        System.arraycopy(heights,0,newHeights,1,n);
        newHeights[n+1] = 0;
        n += 2;
        Deque<Integer>stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = 1;i < n;i++){
            while (newHeights[i] < newHeights[stack.peekLast()]){
                int curHeight = newHeights[stack.pollLast()];
                int curWidth = i - stack.peekLast() -1;
                res = Math.max(res,curHeight*curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }
}
