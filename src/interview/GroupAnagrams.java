package interview;

import java.util.*;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 11:12
 */
public class GroupAnagrams {
    public List<List<String>>groupAnagrams(String[]strs){
        List<List<String>>result = new ArrayList<>();
        Map<String,List<String>>map = new HashMap<>();
        if (strs == null || strs.length == 0)
            return result;
        for (String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String str1 = Arrays.toString(temp);
            List<String> list;
            if (map.containsKey(str1)){
                list = map.get(str1);
            }
            else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(str1,list);
        }
        result.addAll(map.values());
        return result;
    }
}
