package daily;

import java.util.Arrays;

/**
 * @author kanglo
 * @create 2021-01-2021/1/27 10:57
 */
public class MaxNumEdgesToRemove {
    public int maxNumEdgesToRemove(int n,int[][]edges){
        Arrays.sort(edges,(o1, o2) -> o2[0]-o1[0]);
        int len = edges.length;
        int result = 0;
        UF uf1 = new UF(n);
        UF uf2 = new UF(n);
        for (int[]edge : edges){
            if (edge[0] == 3){
                if (uf1.find(edge[1]-1) == uf1.find(edge[2]-1))
                    result++;
                else {
                    uf1.union(edge[1]-1,edge[2]-1);
                    uf2.union(edge[1]-1,edge[2]-1);
                }
            }else if (edge[0] == 2){
                if (uf2.find(edge[1]-1) == uf2.find(edge[2]-1))
                    result++;
                else
                    uf2.union(edge[1]-1,edge[2]-1);
            }else if (edge[0] ==1){
                if (uf1.find(edge[1]-1) == uf1.find(edge[2]-1))
                    result++;
                else
                    uf1.union(edge[1]-1,edge[2]-1);
            }
        }
        if (uf1.count == 1 && uf2.count == 1)
            return result;
        return -1;
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
            int rootP = find(p),rootQ = find(q);
            if (rootP == rootQ)
                return;
            if (rootP > rootQ){
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
        public boolean connected(int p,int q){
            return find(p) == find(q);
        }

        public int getCount() {
            return count;
        }
    }
}
