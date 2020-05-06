package daily;

public class MinCostTickets {
    public int minCostTickets(int[]days,int[]costs){
        int len = days.length;
        int last= days[len-1];
        int[]dp = new int[last+1];
        int pos = 0;
        for (int i = 1;i <= last;i++){
            if (i == days[pos]){
                int day1 = i -1;
                int day2 = i - 7 > 0 ? i -7 : 0;
                int day3 = i - 30 > 0 ? i - 30 : 0;
                dp[i] = Math.max(dp[day1] + costs[0],Math.max(dp[day2] + costs[1],dp[day3] + costs[2]));
                pos++;
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        return dp[last];

    }
}
