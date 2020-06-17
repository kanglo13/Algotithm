package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public String minWindow(String s,String t){
        String res = "";
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length())
            return res;
        int[]needs = new int[128];
        int[]window = new int[128];
        for (char c : t.toCharArray()){
            needs[c]++;
        }
        int num = 0;
        for (int val : needs){
            if (val > 0)
                num++;
        }
        int left = 0,right = 0,valid = 0;
        int len = s.length() + 1;
        while (right < s.length()){
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && window[ch] >= needs[ch]){
                valid++;
            }
            while (valid == num){
                if (right - left + 1 < len){
                    len = right - left + 1;
                    res = s.substring(left,right+1);
                }
                char ch1 = s.charAt(left);
                if (needs[ch1] > 0 && window[ch1] >= needs[ch1]){
                    valid--;
                }
                window[ch1]--;
                left++;
            }
            right++;
        }
        return res;
    }
}
