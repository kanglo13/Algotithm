package List;

import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode middleNode = middleNode(head);
        ListNode rightHead = middleNode.next;
        middleNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        return mergerList(left,right);
    }
    private ListNode middleNode(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode mergerList(ListNode l1,ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val){
            l1.next = mergerList(l1.next,l2);
            return l1;
        }
        else {
            l2.next = mergerList(l1,l2.next);
            return l2;
        }

    }

}
