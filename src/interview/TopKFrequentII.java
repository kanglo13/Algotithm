package interview;

import java.util.*;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 17:27
 */
public class TopKFrequentII {
    public List<String>topKFrequent(String[]words,int k){
        Map<String,Integer>map = new HashMap<>();
        PriorityQueue<String>priorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o1) == map.get(o2) ? o1.compareTo(o2) : map.get(o2)-map.get(o1));
        for (String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        priorityQueue.addAll(map.keySet());
        List<String>result = new ArrayList<>();
        while (k-- >0){
            result.add(priorityQueue.poll());
        }
        return result;
    }
}
