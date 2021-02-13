package daily;

/**
 * @author kanglo
 * @create 2021-02-2021/2/10 19:16
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1,String s2){
        if (s1 == null || s1.length() == 0)
            return true;
        int[]needs = new int[26];
        int[]window = new int[26];
        for (char ch : s1.toCharArray()){
            needs[ch-'a']++;
        }
        int num = 0;
        for (int val : needs){
            if (val > 0)
                num++;
        }
        int left = 0,right = 0,valid = 0;
        while (right < s2.length()){
            char ch1 = s2.charAt(right);
            window[ch1-'a']++;
            if (needs[ch1-'a'] > 0 && window[ch1-'a'] == needs[ch1-'a'])
                valid++;
            while (right-left+1 == s1.length()){
                if (valid == num)
                    return true;
                char ch2 = s2.charAt(left);
                if (needs[ch2-'a']  > 0 && window[ch2-'a'] == needs[ch2-'a'])
                    valid--;
                window[ch2-'a']--;
                left++;
            }
            right++;
        }
        return false;
    }
}
