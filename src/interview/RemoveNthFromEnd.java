package interview;

import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/2 10:48
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode slow = head, fast = head;
        while (n-- > 0){
            fast = fast.next;
        }
        if (fast == null)
            return head.next;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
