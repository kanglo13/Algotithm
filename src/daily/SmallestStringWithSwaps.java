package daily;

import java.util.*;

/**
 * @author kanglo
 * @create 2021-01-2021/1/11 12:30
 */
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>>pairs){
        if (pairs.size() == 0)
            return s;
        int n = s.length();
        UF uf = new UF(n);
        for (List<Integer>pair : pairs){
            uf.union(pair.get(0),pair.get(1));
        }
        Map<Integer,PriorityQueue<Character>>map = new HashMap<>();
        for (int i = 0;i < n;i++){
            int root = uf.find(i);
            if (map.containsKey(root)){
                map.get(root).offer(s.charAt(i));
            }
            else {
                PriorityQueue<Character>heap = new PriorityQueue<>();
                heap.offer(s.charAt(i));
                map.put(root,heap);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < n;i++){
            int root = uf.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
    class UF{
        private int count;
        private int[]parent;
        private int[]size;
        public UF(int n){
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0;i < n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int x){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
            }
            return x;
        }
        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            if (size[rootP] > size[rootQ]){
                parent[rootQ] = rootP;
                size[rootP] += rootQ;
            }
            else {
                parent[rootP] = rootQ;
                size[rootQ] += rootP;
            }
            count--;
        }
        public int count (){
            return count;
        }
        public boolean connected(int p,int q){
            return find(p) == find(q);
        }
    }
}
