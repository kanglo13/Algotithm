package unionFind;

public class LargestComponentSize {
    public int largestComponentSize(int[]A){
        int maxVal = 0;
        for (int val : A){
            maxVal = Math.max(val,maxVal);
        }
        UF uf = new UF(maxVal+1);

        for (int val : A){
            double upBound = Math.sqrt(val);
            for (int i = 2;i <= upBound;i++){
                if (val % i == 0){
                    uf.union(val,i);
                    uf.union(val,val/i);
                }
            }
        }
        int[]cnt = new int[maxVal+1];
        int result = 0;
        for (int val : A){
            int root = uf.find(val);
            cnt[root]++;
            result = Math.max(result,cnt[root]);
        }
        return result;
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
        public void union(int p, int q){
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
        public int count(){
            return count;
        }
        public boolean connected(int p,int q){
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
}
