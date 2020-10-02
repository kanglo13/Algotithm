package daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kanglo
 * @create 2020-10-2020/10/2 9:57
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String J,String S){
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (char ch : J.toCharArray()){
            set.add(ch);
        }
        for (char ch : S.toCharArray()){
            if (set.contains(ch))
                result++;
        }
        return result;
    }
}
