package dynamicProgramming.breakInteger;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.List;

public class NumSquares {
    public int numSquares(int n){
        List<Integer> list = generateSquares(n);
        int[]dp = new int[n+1];
        for (int i = 1;i <= n;i++){
            int min = Integer.MAX_VALUE;
            for (int square : list){
                if (i < square)
                    break;
                min = Math.min(min,dp[i-square] + 1);
            }
        }
        return dp[n];
    }
    private List<Integer> generateSquares(int n){
        List<Integer> list = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n){
            list.add(square);
            square += diff;
            diff += 2;
        }
        return list;
    }
}
