package List;

public class DetectCycle {
    public ListNode detectCycle(ListNode head){
        if (head == null || head.next == null)
            return null;
        ListNode slow = head,fast = head;
        while (true){
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
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
