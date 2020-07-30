package unionFind;

public class EquationsPossible {
    public boolean equationsPossible(String[]equations){
        UF uf = new UF(26);
        for (String equation : equations){
            if (equation.charAt(1) == '='){
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                uf.union(x-'a',y-'a');
            }
        }
        for (String equation : equations){
            if (equation.charAt(1) == '!'){
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                if (uf.connected(x-'a',y-'a'))
                    return false;
            }
        }
        return true;
    }
    class UF {
        private int count;
        private int[]size;
        private int[]parent;

        public UF(int n){
            this.count = n;
            size = new int[n];
            parent = new int[n];
            for (int i = 0;i < n;i++){
                parent[i] = i;
                size[i] = 1;
            }
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
        private int find(int x){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public int count(){
            return count;
        }
    }

}
