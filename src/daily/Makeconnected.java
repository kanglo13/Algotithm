package daily;

/**
 * @author kanglo
 * @create 2021-01-2021/1/23 10:12
 */
public class Makeconnected {
    public int makeConnected(int n,int[][]connections){
        if (connections.length < n - 1)
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
            return  x;
        }
        public void union(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;
            if (rootP > rootQ){
                parent[rootQ] = rootP;
                size[rootP] += rootQ;
            }
            else {
                parent[rootP] = rootQ;
                size[rootQ] += rootP;
            }
        }
        public boolean connected(int p,int q){
            return find(p) == find(q);
        }
    }
}
