package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-01-2021/1/10 9:59
 */
public class SummaryRanges {
    public List<String>summaryRanges(int[]nums){
        List<String>results = new ArrayList<>();
        for (int i = 0,j = 0;j < nums.length;){
            while (j+1 < nums.length && nums[j+1] == nums[j]+1)
                j++;
            if (i == j)
                results.add(nums[i] + "");
            else
                results.add(nums[i] + "->" + nums[j]);
            i = j + 1;
            j = i;
        }
        return results;
    }
}
