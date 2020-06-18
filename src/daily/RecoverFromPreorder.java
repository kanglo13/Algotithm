package daily;

public class RecoverFromPreorder {
    int cur = 0, curD = 0;
    public TreeNode recoverFromPreorder(String  s){
        char[]nodes = s.toCharArray();
        return dfs(0,nodes);
    }
    public TreeNode dfs(int depth,char[]nodes){
        int val = 0;
        for (;cur < nodes.length && nodes[cur] != '-';cur++){
            val = val * 10 + nodes[cur] - '0';
        }
        curD = 0;
        for (;cur < nodes.length && nodes[cur] == '-';cur++,curD++);
        TreeNode r = new TreeNode(val);
        if (curD > depth) r.left = dfs(curD,nodes);
        if (curD > depth)  r.right = dfs(curD,nodes);
        return r;
    }
}
