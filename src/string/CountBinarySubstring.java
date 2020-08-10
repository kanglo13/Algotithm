package string;

public class CountBinarySubstring {
    public int countBinarySubstring(String s){
        int last = 0, result = 0,cur = 1;
        for (int i = 1;i < s.length();i++){
            if(s.charAt(i) == s.charAt(i-1))
                cur++;
            else {
                last = cur;
                cur = 1;
            }
            if (last >= cur)
                result++;
        }

        return result;
    }
}
