package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-09-2020/9/26 10:07
 */
public class PathSum {
    public List<List<Integer>>pathSum(TreeNode root,int sum){
        List<List<Integer>>pathes = new ArrayList<>();
        if (root == null)
            return pathes;
        backtracking(root,sum,pathes,new ArrayList<>());
        return pathes;
    }
    private void backtracking(TreeNode root,int sum,List<List<Integer>>pathes,List<Integer>pathList){
        if (root == null)
            return;
        pathList.add(root.val);
        if (root.left == null && root.right == null && sum == root.val){
            pathes.add(new ArrayList<>(pathList));
        }
        backtracking(root.left,sum-root.val,pathes,pathList);
        backtracking(root.right,sum-root.val,pathes,pathList);
        pathList.remove(pathList.size()-1);

    }
}
