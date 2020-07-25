package search.dfs;

public class SortedListToBST {
    public TreeNode sortetListToBST(ListNode head){
        if (head == null)
            return null;
        return build(head,null);
    }
    private TreeNode build(ListNode head,ListNode tail){
        if (head == tail)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = build(head,slow);
        root.right = build(slow.next,tail);
        return root;
    }
}
