package slidingWindow;

public class Minw {
    public String minWindow(String S,String T){
        int[]window = new int[26];
        int[]needs = new int[26];
        int left = 0,right = 0;
        int valid = 0;
        int Window = S.length() + 1;
        String result = "";
        for (char ch : T.toCharArray()){
            needs[ch-'a']++;
        }
        while (right < S.length()){
            int ch = S.charAt(right) - 'a';
            window[ch]++;
            if (needs[ch] > 0 && needs[ch] >= window[ch])
                valid++;
            while (valid == T.length()){
                ch = S.charAt(left) - 'a';
                if (needs[ch] > 0 && needs[ch] >= window[ch])
                    valid--;
                if (right - left + 1 < Window){
                    Window = right - left + 1;
                    result = S.substring(left,right+1);
                }
                window[ch]--;
                left++;
            }
            right++;
        }
        return result;

    }
}
