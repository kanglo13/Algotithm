package search.dfs;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInorderAndPostorder {
    private int[]postOrder;
    private Map<Integer,Integer> map;

    public TreeNode buildTree(int[]inorder,int[]postOrder){
        int postLen = postOrder.length;
        int inLen = inorder.length;
        if (postLen != inLen){
            throw new RuntimeException("Incorrect input data");
        }
        this.postOrder = postOrder;
        map = new HashMap<>();
        for (int i = 0;i < inLen;i++){
            map.put(inorder[i],i);
        }
        return buildTree(0,postLen-1,0,inLen-1);
    }
    private TreeNode buildTree(int postLeft,int postRight,int inLeft,int inRight){
        if (inLeft > inRight || postLeft > postRight)
            return null;
        int pivot = postOrder[postRight];
        int pivotIndex = map.get(pivot);
        TreeNode root = new TreeNode(pivot);
        root.left = buildTree(postLeft,postRight+pivotIndex-inRight-1,inLeft,pivotIndex-1);
        root.right = buildTree(postRight+pivotIndex-inRight,postRight-1,pivotIndex+1,inRight);
        return root;
    }
}
