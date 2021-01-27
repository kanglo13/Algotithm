package daily;

/**
 * @author kanglo
 * @create 2021-01-2021/1/25 10:39
 */
public class RegionsBySlashes {
    public int regionsBySlashes(String[]grid){
        int n = grid.length;
        UF uf = new UF(4*n*n);
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                int start = 4 *(i * n + j);
                switch (grid[i].charAt(j)){
                    case ' ':
                        uf.union(start,start+1);
                        uf.union(start,start+2);
                        uf.union(start+2,start+3);
                        break;
                    case '/':
                        uf.union(start,start+3);
                        uf.union(start+1,start+2);
                        break;
                    case '\\':
                        uf.union(start,start+1);
                        uf.union(start+2,start+3);
                        break;
                }
                if (i > 0){
                    uf.union(start,start-4*n+2);
                }
                if (j > 0){
                    uf.union(start+3,start-3);
                }
            }
        }
        return uf.count;
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
            return find(p) == find(q);
        }
        public int getCount(){
            return count;
        }
    }
}
