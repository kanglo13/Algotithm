package string;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>>groupAnagrams(String[]strs){
        Map<String,List<String>>map = new HashMap<>();
        List<List<String>>result = new ArrayList<>();
        for(String str : strs){
            char[]chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if (!map.containsKey(temp)){
                map.put(temp,new ArrayList<>());
            }
            map.get(temp).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
