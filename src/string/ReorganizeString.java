package string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S){
        Map<Character,Integer>map = new HashMap<>();
        for (Character ch : S.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character>heap = new PriorityQueue<>((o1, o2) -> map.get(o2)-map.get(o1));
        heap.addAll(map.keySet());
        StringBuilder stringBuilder = new StringBuilder();
        while (heap.size() > 1){
            char top = heap.poll();
            char next = heap.poll();
            stringBuilder.append(top).append(next);
            map.put(top,map.get(top)-1);
            map.put(next,map.get(next)-1);
            if (map.get(top) > 0)
                heap.offer(top);
            if (map.get(next) > 0)
                heap.offer(next);
        }
        if (!heap.isEmpty()){
            char ch = heap.poll();
            if (map.get(ch) > 1)
                return "";
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
    public String reorganizwStrings(String S){
        int[]hash = new int[26];
        for (char ch : S.toCharArray()){
            hash[ch-'a']++;
        }
        PriorityQueue<Integer>heap = new PriorityQueue<>((o1, o2) -> hash[o2]-hash[o1]);
        for (int i = 0;i < hash.length;i++){
            if (hash[i] > 0)
                heap.add(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (heap.size() > 1){
            int top = heap.poll();
            int next =  heap.poll();
            stringBuilder.append((char)(top+'a')).append((char)(next+'a'));
            if (--hash[top] > 0)
                heap.add(top);
            if (--hash[next] > 0)
                heap.add(next);
        }
        if (!heap.isEmpty()){
            int last = heap.poll();
            if (hash[last] > 1)
                return "";
            stringBuilder.append((char)(last+'a'));
        }
        return stringBuilder.toString();
    }
}
