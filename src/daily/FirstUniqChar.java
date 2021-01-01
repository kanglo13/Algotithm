package daily;

/**
 * @author kanglo
 * @create 2020-12-2020/12/23 10:02
 */
public class FirstUniqChar {
    public int firstUniqChar(String s){
        int[]hash = new int[26];
        for (char ch : s.toCharArray())
            hash[ch-'a']++;
        for (int i = 0;i < s.length();i++){
            if (hash[s.charAt(i)-'a'] == 1)
                return i;
        }
        return -1;
    }
}
