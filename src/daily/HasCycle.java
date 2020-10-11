package daily;

import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/9 11:07
 */
public class HasCycle {
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null)
            return false;
        ListNode slow = head,fast = head;
        while (fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
    public ListNode detectCycle(ListNode head){
        ListNode fast = head,slow = head;
        while (true){
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast== slow)
                break;
        }
        slow = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
