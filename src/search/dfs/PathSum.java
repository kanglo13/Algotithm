package search.dfs;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        // 递归求解路径总和
        path(root, sum, ans, tmp);
        return ans;
    }

    // 传入4个参数来完成路径的存放和搜索
    private void path(TreeNode root, int sum, List<List<Integer>> ans, ArrayList<Integer> tmp) {
        if (root == null) {
            return;
        }
        tmp.add(root.val);
        // 如果只有根节点或只有叶子结点，则直接放入 ans 中
        if (root.left == null && root.right == null && sum == root.val) {
            // 这里使用 new 的形式是因为初始化后,传进来的数据每次都是更新后的 tmp
            ans.add(new ArrayList<>(tmp));
        }
        path(root.left, sum - root.val, ans, tmp);
        path(root.right, sum - root.val, ans, tmp);
        // 这里利用了回溯的思想:每次回退上一个节点再寻找另一条边的节点作为新路径
        tmp.remove(tmp.size() - 1);
    }
}
