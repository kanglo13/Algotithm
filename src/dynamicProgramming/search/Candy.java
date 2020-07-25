package dynamicProgramming.search;

import java.util.Arrays;

public class Candy {
    public int candy(int[]ratings){
        int n = ratings.length;
        int[]candies = new int[n];
        Arrays.fill(candies,1);

        for (int i = 0; i < n-1;i++){
            if (ratings[i] < ratings[i+1])
                candies[i+1] = candies[i] + 1;
        }
        for (int i = n - 1;i > 0;i--){
            if (ratings[i] < ratings[i-1]){
                if (candies[i-1] <= candies[i]){
                    candies[i-1] = candies[i] = 1;
                }
            }
        }
        int result = 0;
        for (int candy : candies)
            result += candy;
        return result;
    }
}
