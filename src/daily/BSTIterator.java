package daily;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author kanglo
 * @create 2021-03-2021/3/28 10:46
 */
public class BSTIterator {
    List<Integer>list;
    Iterator<Integer>it;
    public  BSTIterator(TreeNode root){
        list = new ArrayList<>();
        dfs(root);
        it = list.iterator();
    }
    public int next(){
        return it.next();
    }
    public boolean hasNext(){
        return it.hasNext();
    }
    private void dfs(TreeNode root){
        if (root == null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
