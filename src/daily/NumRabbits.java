package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kanglo
 * @create 2021-04-2021/4/4 9:59
 */
public class NumRabbits {
    public int numRabbits(int[]answers){
        Map<Integer,Integer>map = new HashMap<>();
        int result = 0;
        for (int answer: answers){
            if (map.containsKey(answer) && map.get(answer) > 0){
                map.put(answer,map.get(answer)-1);
            }
            else {
                result += answer + 1;
                map.put(answer,answer);
            }
        }
        return result;
    }
}
