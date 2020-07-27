package slidingWindow;

public class CharacterReplacement {
    public int characterReplacement(String s,int k){
        int[]window = new int[26];
        int left = 0,right = 0;
        int maxCount = 0;
        int result = 0;
        while (right < s.length()){
            window[s.charAt(right)-'A']++;
            maxCount = Math.max(maxCount,window[s.charAt(right)-'A']);
            while (right-left+1 - maxCount > k){
                window[s.charAt(left)-'A']--;
                left++;
            }
            result = Math.max(result,right-left+1);
            right++;
        }
        return result;
    }
}
