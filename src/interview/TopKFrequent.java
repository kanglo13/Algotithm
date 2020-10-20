package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 17:03
 */
public class TopKFrequent {
    public int[] topKFrequent(int[]nums,int k){
        int[]result = new int[k];
        Map<Integer,Integer>map = new HashMap<>();
        PriorityQueue<Integer>priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o2)-map.get(o1));
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        priorityQueue.addAll(map.keySet());
        int index = 0;
        while (index < k){
            result[index++] = priorityQueue.poll();
        }
        return result;
    }
}
