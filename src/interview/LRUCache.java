package interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author kanglo
 * @create 2020-10-2020/10/11 21:21
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        cache.put(5,5);
        System.out.println(cache.get(5));

    }
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
           list.remove((Integer)key);
           list.addLast(key);
           return cache.get(key);
       }
       return -1;
   }
   public void put(int key,int value){
      if (!cache.containsKey(key)){
          list.addLast(key);
          cache.put(key,value);
      }
      else {
          if (capacity == list.size()){
              cache.remove(list.removeFirst());
              list.add(key);
              cache.put(key,value);
          }
          else {
              list.remove((Integer)key);
              list.addLast(key);
              cache.put(key,value);
          }
      }
   }
}
