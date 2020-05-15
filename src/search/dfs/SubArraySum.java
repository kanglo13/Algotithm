package search.dfs;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subArraySum(int[]nums,int k){
        Map<Integer,Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0,1);
        int preSum = 0;
        int count = 0;
        for (int num : nums){
            preSum += num;
            if (preSumFreq.containsKey(preSum-k)){
                count += preSumFreq.get(preSum-k);
            }
            preSumFreq.put(preSum,preSumFreq.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
