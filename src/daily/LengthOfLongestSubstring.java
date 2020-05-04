package daily;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() == 0)
            return 0;
        int[] window = new int[256];
        int left = 0,right = 0;
        int maxLen = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            window[ch]++;
            right++;
            while (window[ch] > 1){
                char ch1 = s.charAt(left);
                window[ch1]--;
                left++;

            }
            maxLen = Math.max(maxLen,right-left);
        }
        return maxLen;
    }
}
