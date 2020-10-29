package daily;

/**
 * @author kanglo
 * @create 2020-10-2020/10/29 8:32
 */
public class SumNumbers {
    private int sum;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    private void dfs(TreeNode node,int temp){
        if (node == null)
            return;
        temp = temp * 10 + node.val;
        if (isLeaf(node)){
            sum += temp;
            return;
        }
        dfs(node.left,temp);
        dfs(node.right,temp);

    }
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
