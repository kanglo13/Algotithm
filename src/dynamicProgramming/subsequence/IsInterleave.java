package dynamicProgramming.subsequence;
/*
其实和递归本质上是一样的，解法一中压栈到末尾最后一个字符的时候，再次压栈，就会进入 if (i == s1.length() && j == s2.length() && k == s3.length()) 这里，然后就开始一系列的出栈过程。

而动态规划就是利用一个 dp 数组去省去压栈，所谓空间换时间。这里的话，我们也不模仿递归从尾部开始了，我们直接从开头开始，思想是一样的。

我们定义一个 boolean 二维数组 dp [ i ] [ j ] 来表示 s1[ 0, i ) 和 s2 [ 0, j ） 组合后能否构成 s3 [ 0, i + j )，注意不包括右边界，主要是为了考虑开始的时候如果只取 s1，那么 s2 就是空串，这样的话 dp [ i ] [ 0 ] 就能表示 s2 取空串。

状态转换方程也很好写了，如果要求 dp [ i ] [ j ] 。

如果 dp [ i - 1 ] [ j ] == true，并且 s1 [ i - 1 ] == s3 [ i + j - 1]， dp [ i ] [ j ] = true 。

如果 dp [ i ] [ j - 1 ] == true，并且 s2 [ j - 1 ] == s3 [ i + j - 1]， dp [ i ] [ j ] = true 。

否则的话，就更新为 dp [ i ] [ j ] = false。

如果 i 为 0，或者 j 为 0，那直接判断 s2 和 s3 对应的字母或者 s1 和 s3 对应的字母即可。

 */
public class IsInterleave {
    public boolean isInterleave(String s1,String s2,String s3){
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length())
            return false;
        boolean[][] dp = new boolean[m+1][n+1];
        for (int i = 0;i <= m;i++){
            for (int j = 0;j <= n;j++){
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (i == 0){
                    dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
                }
                else if (j == 0){
                    dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1);
                }
                else {
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                }
            }
        }
        return dp[m][n];
    }
}
