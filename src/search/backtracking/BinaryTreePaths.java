package search.backtracking;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
        public List<String> binaryTreePaths(TreeNode root){
            List<String> paths = new ArrayList<>();
            if (root == null)
                return paths;
            List<Integer> values = new ArrayList<>();
            backtracking(root,paths,values);
            return  paths;
        }
        private void backtracking(TreeNode node,List<String>paths,List<Integer>values){
            if (node == null)
                return;
            values.add(node.val);
            if (isLeaf(node)){
                paths.add(buildPath(values));
            }
            else {
                backtracking(node.left,paths,values);
                backtracking(node.right,paths,values);
            }
            values.remove(values.size()-1);
        }
        private boolean isLeaf(TreeNode node){
            return node.left == null && node.right == null;
        }
        private String buildPath(List<Integer> values){
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < values.size();i++){
                sb.append(values.get(i));
                if (i != values.size()-1)
                    sb.append("->");
            }
            return sb.toString();
        }
}
