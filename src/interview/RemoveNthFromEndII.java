package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/16 20:56
 */
public class RemoveNthFromEndII {
    public ListNode removeNthFromEnd(ListNode head,int n){
        if (head == null)
            return head;
        ListNode fast = head;
        while (n-- > 0)
            fast = fast.next;
        if (fast == null)
            return head.next;
        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
