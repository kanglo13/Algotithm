package string;

import java.util.HashSet;
import java.util.Set;

public class NumJewelsInStones {
    public int numJewelsInStones(String J,String S){
        Set<Character>set = new HashSet<>();
        int result = 0;
        for (Character ch : J.toCharArray()){
            set.add(ch);
        }
        for (Character ch : S.toCharArray()){
            if (set.contains(ch))
                result++;
        }
        return result;
    }
}
