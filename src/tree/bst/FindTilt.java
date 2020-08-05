package tree.bst;

public class FindTilt {
    int tilt = 0;
    public int findTilt(TreeNode root){
        if(root != null){
            tilt += Math.abs(sum(root.right)-sum(root.left));
            findTilt(root.left);
            findTilt(root.right);
        }
        return tilt;

    }
    private int sum(TreeNode root){
        if (root == null)
            return 0;
        int sum = root.val;;
        sum += sum(root.left);
        sum += sum(root.right);
        return sum;
    }

}
