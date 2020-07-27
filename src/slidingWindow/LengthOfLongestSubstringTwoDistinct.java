package slidingWindow;

public class LengthOfLongestSubstringTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s){
        int[]window = new int[128];
        int left = 0, right = 0;
        int result = 0;
        while (right < s.length()){
            window[s.charAt(right)]++;
            while (countDistinct(window) > 2){
                window[s.charAt(left)]--;
                left++;
            }
            result = Math.max(result,right-left+1);
            right++;
        }
        return result;
    }
    private int countDistinct(int[]window){
        int count = 0;
        for (int val : window){
            if (val > 0)
                count++;
        }
        return count;
    }
}
