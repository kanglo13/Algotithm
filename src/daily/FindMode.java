package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-09-2020/9/24 8:49
 */
public class FindMode {
    private List<Integer>list = new ArrayList<>();
    private int prev;
    private int curTimes,maxTimes;

    public int[] findMode(TreeNode root){
        inorder(root);
        int n = list.size();
        int[]result = new int[n];
        for (int i = 0;i < n;i++){
            result[i] = list.get(i);
        }
        return result;
    }
    private void inorder(TreeNode root){
        if (root != null){
            inorder(root.left);
            if (prev == root.val){
                curTimes++;
            }
            else {
                prev = root.val;
                curTimes = 1;
            }
            if (curTimes == maxTimes){
                list.add(root.val);
            }
            else if (curTimes > maxTimes){
                maxTimes = curTimes;
                list.clear();
                list.add(root.val);
            }
            inorder(root.right);
        }
    }
}
