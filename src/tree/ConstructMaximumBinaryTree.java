package tree;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[]nums){
        return buildTree(nums,0,nums.length-1);
    }
    private TreeNode buildTree(int[]nums,int start,int end){
        if (start > end)
            return null;
        int maxIndex = findMax(nums,start,end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums,start,maxIndex-1);
        root.right = buildTree(nums,maxIndex+1,end);
        return root;
    }
    private int findMax(int[]nums,int start,int end){
        int maxIndex = start;
        for (int i = start + 1;i <= end;i++){
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
}
