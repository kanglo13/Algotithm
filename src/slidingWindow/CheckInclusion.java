package slidingWindow;

public class CheckInclusion {
    public boolean checkInclusion(String s1,String s2){
        if(s1 == null || s1.length() == 0)
            return true;
        int[]needs = new int[128];
        int[]window = new int[128];
        for (char c : s1.toCharArray()){
            needs[c]++;
        }
        int num = 0;
        for (int val : needs){
            if (val > 0)
                num++;
        }
        int left = 0,right = 0,valid = 0;
        while (right < s2.length()){
            char ch1 = s2.charAt(right);
            window[ch1]++;
            if (needs[ch1] > 0 && window[ch1] == needs[ch1]){
                valid++;
            }
            while (right - left + 1 == s1.length()){
                if (valid == num)
                    return true;
                char ch2 = s2.charAt(left);
                if (needs[ch2] > 0 && window[ch2] == needs[ch2]){
                    valid--;
                }
                window[ch2]--;
                left++;
            }
            right++;
        }
        return false;
    }
}
