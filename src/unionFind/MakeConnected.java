package unionFind;

public class MakeConnected {
    public int makeConnectted(int n,int[][] connections){
        if (connections.length < n -1)
            return -1;
        UF uf = new UF(n);
        for (int[]connection : connections){
            uf.union(connection[0],connection[1]);
        }
        int result = 0;
        for (int i = 0;i < n;i++){
            if (i == uf.find(i))
                result++;
        }
        return result-1;
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
                size[rootP] += rootQ;
            }
            else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }
        public boolean connected(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
        public int count(){
            return count;
        }
    }
}
