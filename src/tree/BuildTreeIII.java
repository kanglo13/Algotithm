package tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeIII {
    private Map<Integer,Integer>map = new HashMap<>();
    private int[]preorder;
    public TreeNode constructFromPrePost(int[]preorder,int[]postorder){
        int preLen = preorder.length;
        int postLen = postorder.length;
        if (preLen != postLen)
            return null;
        this.preorder = preorder;
        for (int i = 0;i < postLen;i++)
            map.put(postorder[i],i);
        return buildTree(0,preLen-1,0,postLen-1);
    }
    private TreeNode buildTree(int preLeft,int preRight,int postLeft,int postRight){
        if (preLeft > preRight || postLeft > postRight)
            return null;
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int povitIndex = map.get(preorder[preLeft+1]);
        root.left = buildTree(preLeft+1,preLeft+povitIndex-postLeft+1,postLeft,povitIndex);
        root.right = buildTree(preLeft+ povitIndex-postLeft+2,preRight,povitIndex+1,postRight-1);
        return root;
    }
}
