package daily;

import java.util.Arrays;
import java.util.List;

public class SmallestRange {
    public int[] smallestRange(List<List<Integer>>nums){
        int n = 0;
        for (List<Integer>num : nums)
            n += num.size();
        int[][]ordered = new int[n][2];
        int i = 0, j = 0;
        for (List<Integer>num : nums){
            for (int val : num){
                ordered[i][0] = val;
                ordered[i++][1] = j;
            }
            j++;
        }
        Arrays.sort(ordered,(o1, o2) -> o1[0]-o2[0]);

        int[] result = new int[2];
        int[]window = new int[j];
        int left = 0, right = 0;
        while (right < n){
            window[ordered[right][1]]++;
            while (width(window) >= j){
                if ((result[0] == 0 && result[1] == 0) || result[1] - result[0] > ordered[right][0] -ordered[left][0]){
                    result[0] = ordered[left][0];
                    result[1] = ordered[right][0];
                }
                window[ordered[left][1]]--;
                left++;
            }
            right++;
        }
        return result;
    }
    private int width(int[]window){
        int result = 0;
        for (int val : window){
            if (val > 0)
                result++;
        }
        return result;
    }
}
