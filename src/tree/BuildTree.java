package tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    private int[]preorder;
    private Map<Integer,Integer>inorderIdx = new HashMap<>();
    public TreeNode biuldTree(int[]preorder,int[]inorder){
        int inLen = inorder.length;
        int preLen = preorder.length;
        if (inLen != preLen)
            return null;
        this.preorder = preorder;
        for(int i = 0;i < inLen;i++){
            inorderIdx.put(inorder[i],i);
        }
        return buildTree(0,preLen-1,0,inLen-1);
    }
    private TreeNode buildTree(int preLeft,int preRight,int inLeft,int inRight){
        if (preLeft > preRight || inLeft > inRight)
            return null;
        int povit = preorder[preLeft];
        TreeNode root = new TreeNode(povit);
        int povitIdx = inorderIdx.get(povit);
        root.left = buildTree(preLeft+1,preLeft+povitIdx-inLeft,inLeft,povitIdx-1);
        root.right = buildTree(preLeft+povitIdx-inLeft+1,preRight,povitIdx+1,inRight);
        return root;
    }
}
