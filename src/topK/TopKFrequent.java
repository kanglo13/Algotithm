package topK;

import List.ListNode;
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[]nums,int k){
        Map<Integer,Integer>map =new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer>heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        for (Integer key : map.keySet()){
            if (heap.size() < k)
                heap.add(key);
            else if (map.get(key) > map.get(heap.peek())){
                heap.poll();
                heap.add(key);
            }
        }
        int[]res = new int[k];
        int index = 0;
        while (!heap.isEmpty()){
            res[index++] = heap.poll();
        }
        return res;
    }
    public List<String> topKFrequent(String[]words,int k){
        Map<String,Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1) == map.get(o2) ?o1.compareTo(o2) :map.get(o1) - map.get(o2);
            }
        });
        for (String key : map.keySet()){
            if (heap.size() < k){
                heap.add(key);
            }
            else if (map.get(key)  > map.get(heap.peek())){
                heap.poll();
                heap.add(key);
            }
        }
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()){
            res.add(heap.poll());
        }
        Collections.sort(res, (o1,o2)-> (
                map.get(o2)-map.get(o1)==0?o1.compareTo(o2):map.get(o2)-map.get(o1)
        ));

        return res;
    }


}
