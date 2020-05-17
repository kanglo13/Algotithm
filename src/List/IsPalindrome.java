package List;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null)
            slow = slow.next;
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null){
            if (right.val != left.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
