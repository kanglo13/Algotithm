package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length())
            return res;
        int[]needs = new int[128];
        int[]window = new int[128];
        for (char c : p.toCharArray()){
            needs[c]++;
        }
        int num = 0;
        for (int val : needs){
            if (val > 0)
                num++;
        }
        int left = 0,right = 0,valid = 0;
        while (right < s.length()){
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && window[ch] == needs[ch]){
                valid++;
            }
            while (right - left + 1 == p.length()){
                if (valid == num){
                    res.add(left);
                }
                char ch1 = s.charAt(left);
                if (needs[ch1] > 0 && window[ch1] == needs[ch1]){
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
