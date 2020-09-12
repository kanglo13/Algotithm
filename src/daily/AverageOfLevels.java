package daily;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author kanglo
 * @create 2020-09-2020/9/12 9:04
 */
public class AverageOfLevels {
    public List<Double>averageOfLevels(TreeNode root){
        List<Double>result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode>queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size() ;
            List<Integer> list = new ArrayList<>();
            while (size-- > 0){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            int n = list.size();
            if (n > 0){
                double sum = 0;
                for (int val : list)
                    sum += val;
                double average = sum / n;
                result.add(average);
            }
        }
        return result;
    }
}
