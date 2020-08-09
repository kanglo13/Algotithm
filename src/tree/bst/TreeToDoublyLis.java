package tree.bst;

public class TreeToDoublyLis {
    Node pre = null,head = null;

    public Node treeToDoublyList(Node root){
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    private void inorder(Node root){
        if (root == null)
            return;
        inorder(root.left);
        root.left = pre;
        if(pre != null)
            pre.right = root;
        else
            head = pre;
        pre = root;
        inorder(root.right);

    }
}
