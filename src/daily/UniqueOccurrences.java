package daily;

import java.util.*;

/**
 * @author kanglo
 * @create 2020-10-2020/10/28 11:33
 */
public class UniqueOccurrences {
    public boolean  uniqueOccurrences(int[]arr){
        Map<Integer,Integer>map = new HashMap<>();
        for (int val : arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        Set<Integer>set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}
