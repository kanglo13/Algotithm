package unionFind;

public class FindRedundantConnection {
    public int[]findRedundantConnection(int[][]edges){
        UF uf = new UF(edges.length+1);
        for (int[]edge : edges){
            if (!uf.connected(edge[0],edge[1]))
                uf.union(edge[0],edge[1]);
            else
                return edge;
        }
        return new int[0];
    }
    class UF{
        private int count;
        private int[]parent;
        private int[]size;
        public UF(int n){
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0;i < n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int count(){
            return count;
        }
        public  int find(int x){
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
                size[rootP] += rootQ;
            }
            else {
                parent[rootP] = rootQ;
                size[rootQ] += rootP;
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
