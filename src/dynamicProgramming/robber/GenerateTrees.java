package dynamicProgramming.robber;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n){
        List<TreeNode>res = new ArrayList<>();
        if (n == 0)
            return res;
        return generateTrees(1,n);

    }
    private List<TreeNode> generateTrees(int start,int end){
        List<TreeNode>res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }
        if (start == end){
            TreeNode node = new TreeNode(start);
            res.add(node);
            return res;
        }
        for (int i = start;i <= end;i++){
            List<TreeNode>leftSubtrees = generateTrees(start,i-1);
            List<TreeNode>rightSubtrees = generateTrees(i+1,end);
            for (TreeNode left : leftSubtrees){
                for (TreeNode right : rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left =left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
    public List<TreeNode>generateTreesII(int n){
        List<TreeNode>[]dp = new ArrayList[n+1];
        dp[0] = new ArrayList<>();
        if (n == 0)
            return dp[0];
        dp[0].add(null);
        for (int len = 1;len <= n;len++){
            dp[len] = new ArrayList<>();
            for (int root = 1;root <= len;root++){
                int left = root-1;
                int right = len - root;
                for (TreeNode leftTree : dp[left]){
                    for (TreeNode rightTree : dp[right]){
                        TreeNode rootTree = new TreeNode(root);
                        rootTree.left = leftTree;
                        rootTree.right = clone(rightTree,root);
                        dp[left].add(rootTree);
                    }
                }
            }
        }
        return dp[n];
    }
    private TreeNode clone(TreeNode n,int offset){
        if (n == null)
            return null;
        TreeNode node = new TreeNode(n.val+offset);
        node.left = clone(n.left,offset);
        node.right = clone(n.right,offset);
        return node;
    }
}
