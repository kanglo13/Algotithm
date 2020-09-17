package daily;

import unionFind.UF;

/**
 * @author kanglo
 * @create 2020-09-2020/9/17 8:40
 */

public class FindRedundantDirectedConnection {
    public int[] findRedundantDirectedConnection(int[][]edges){
        int len = edges.length;
        int[]indegrees = new int[len+1];
        for (int[]edge : edges){
            indegrees[edge[1]]++;
        }

        for (int i = len-1;i >= 0;i--){
            if (indegrees[edges[i][1]] == 2){
                if (judgeCircle(edges,len,i))
                    return edges[i];
            }
        }
        for (int i = len-1;i >= 0;i--){
            if (indegrees[edges[i][1]] == 1){
                if (judgeCircle(edges,len,i))
                    return edges[i];
            }
        }
        return new int[0];
    }
    private boolean judgeCircle(int[][]edges,int len,int removeEdgeIndex){
        UF uf = new UF(len + 1);
        for (int i = 0;i < len;i++){
            if (i == removeEdgeIndex)
                continue;
            if (!uf.connected(edges[i][0],edges[i][1])){
                uf.union(edges[i][0],edges[i][1]);
            }
            else
                return true;
        }
        return false;
    }
    class UF{
        private int count;
        private int[]parent;
        private int[]size;

        public UF(int n){
            this.count = n;
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0;i < n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int count(){
            return this.count;
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
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            if (size[rootP] > size[rootQ]){
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
            }
            else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
        public boolean connected(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

    }
}
