package tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeII {
    private int[]postorder;
    private Map<Integer,Integer>map = new HashMap<>();
    public TreeNode buildTree(int[]inorder,int[]postorder){
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen)
            return null;
        this.postorder = postorder;
        for (int i = 0;i < inLen;i++){
            map.put(inorder[i],i);
        }
        return buildTree(0,postLen-1,0,inLen-1);
    }
    private TreeNode buildTree(int postLeft,int postRight,int inLeft,int inRight){
        if (postLeft > postRight || inLeft > inRight)
            return null;
        int povit = postorder[postRight];
        TreeNode root = new TreeNode(povit);
        int povitIdex = map.get(povit);
        root.left = buildTree(postLeft,postRight-1+povitIdex-inRight,inLeft,povitIdex-1);
        root.right = buildTree(postRight+povitIdex-inRight,postRight-1,povitIdex+1,inRight);
        return root;
    }
}
