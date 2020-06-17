package slidingWindow;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0)
            return 0;
        int left = 0,right = 0;
        int res = 0;
        int[]window = new int[128];
        while (right < s.length()){
            char ch = s.charAt(right);
            window[ch]++;
            while (window[ch] > 1){
                char ch1 = s.charAt(left);
                window[ch1]--;
                left++;
            }
            res = Integer.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
