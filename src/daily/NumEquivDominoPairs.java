package daily;

import java.util.*;

/**
 * @author kanglo
 * @create 2021-01-2021/1/26 10:48
 */
public class NumEquivDominoPairs {
    public int numEquivDominoPairs(int[][]dominoes){
        int n = dominoes.length;
        UF uf = new UF(9);
        int result = 0;
        Set<int[]> set = new HashSet<>(Arrays.asList(dominoes));
        for (int[]domino : set){
            if (uf.connected(domino[0],domino[1]))
                result++;
            uf.union(domino[0],domino[1]);
        }
        return result;
    }
    class UF{
        private int count;
        private int[]size;
        private int[]parent;
        public UF(int n){
            count = n;
            size = new int[n];
            parent = new int[n];
            for (int i = 0;i < n;i++){
                size[i] = 1;
                parent[i] = i;
            }
        }
        public int find(int x){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int p,int q){
            int rootP = find(p);
            int rootQ= find(q);
            if (rootP == rootQ)
                return;
            if (rootP > rootQ){
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            else {
                parent[rootP] = rootQ;
                size[rootQ] += rootP;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
        public boolean connected(int p,int q){
            return find(p) == find(q);
        }
    }
}
