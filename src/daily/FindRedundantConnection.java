package daily;

/**
 * @author kanglo
 * @create 2021-01-2021/1/13 10:35
 */
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][]edges){
        int n = edges.length;
        UF uf = new UF(n);
        for (int[]edge : edges){
            if (uf.connected(edge[0],edge[1]))
                return edge;
            uf.union(edge[0],edge[1]);
        }
        return new int[0];
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
                size[i] = 1 ;
            }
        }
        public int count(){
            return count;
        }
        public int find(int x,int[] parent){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public void union(int p,int q){
            int rootP = find(p,parent);
            int rootQ = find(q,parent);
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
        public boolean connected(int p,int q){
            return find(p,parent) == find(q,parent);
        }
    }
}
