package hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer,Integer>cache;
    private LinkedList<Integer>list;
    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        list = new LinkedList<>();
    }
    public int get(int key){
        if (cache.containsKey(key)){
            list.remove(key);
            list.addLast(key);
            return cache.get(key);
        }
        return -1;
    }
    public void put(int key,int value){
        if (cache.containsKey(key)){
            list.remove(key);
            list.addLast(key);
            cache.put(key,value);
            return;
        }
        if (list.size() == capacity){
            cache.remove(list.removeFirst());
            cache.put(key,value);
            list.addLast(key);
        }
        else {
            cache.put(key,value);
            list.addLast(key);
        }
    }
}
