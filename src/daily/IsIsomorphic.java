package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2020-12-2020/12/27 9:44
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s,String t){
        if (s == null && t == null)
            return true;
        else if (s == null || t == null)
            return false;
        else if (s.length() != t.length())
            return false;
        Map<Character,Character> map= new HashMap<>();
        for (int i = 0;i < s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                if (map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i),t.charAt(i));
            }
            else {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
