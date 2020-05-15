package search.dfs;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromPreAndInOrder {
    private int[]preorder;
    private Map<Integer,Integer> map;
    public TreeNode buildTree(int[]preorder,int[]inorder){
        int inLen = inorder.length;
        int preLen = preorder.length;
        if (inLen != preLen){
            throw new RuntimeException("Incorrect input data");
        }
        this.preorder = preorder;
        map = new HashMap<>();
        for (int i = 0;i < inLen;i++){
            map.put(inorder[i],i);
        }
        return buildTree(0,preLen-1,0,inLen-1);
    }
    private TreeNode buildTree(int preLeft,int preRight,int inLeft,int inRight){
        if (preLeft > preRight || inLeft > inRight)
            return null;
        int pivot = preorder[preLeft];
        TreeNode root = new TreeNode(pivot);
        int pivotIndex = map.get(pivot);
        root.left = buildTree(preLeft+1,preLeft+pivotIndex-inLeft,inLeft,pivotIndex-1);
        root.right = buildTree(preLeft+pivotIndex-inLeft+1,preRight,pivotIndex+1,inRight);
        return root;

    }
}
