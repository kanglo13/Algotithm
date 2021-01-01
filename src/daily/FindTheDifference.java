package daily;

import java.util.*;

/**
 * @author kanglo
 * @create 2020-12-2020/12/18 12:17
 */
public class FindTheDifference {
    public char findTheDifference(String s,String t){
        int[]hash = new int[128];
        int[]map = new int[128];
        for (char ch : s.toCharArray())
            hash[ch]++;
        for (char ch : t.toCharArray())
            map[ch]++;
        for (int i = 0;i < 128;i++){
            if (hash[i] != map[i])
                return (char) i;
        }
        return ' ';
    }
}
