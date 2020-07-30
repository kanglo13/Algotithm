package unionFind;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[]nums){
        Set<Integer>set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int result = 0;
        for (int num : nums){
            if (set.contains(num-1))
                continue;
            int right = num;
            while (set.contains(right+1))
                right++;
            result = Math.max(result,right-num+1);
        }
        return result;
    }
}
