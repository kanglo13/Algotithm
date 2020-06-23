package List;

import java.util.List;

public class HasCycle {
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null)
            return false;
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}