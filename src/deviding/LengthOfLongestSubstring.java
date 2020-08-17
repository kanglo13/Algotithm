package deviding;

/*
    @author kanglo
    @create 2020-08-2020/8/16 15:59
*/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s){
        if (s == null || s.length() ==0)
            return 0;
        int[]window = new int[128];
        int left = 0,right = 0;
        int result = 0;
        while (right < s.length()){
            char ch = s.charAt(right);
            window[ch]++;
            right++;
            while(window[ch] > 1){
                char ch1 = s.charAt(left);
                window[ch1]--;
                left++;

            }
            result = Math.max(result,right-left);

        }
        return result;
    }
}
