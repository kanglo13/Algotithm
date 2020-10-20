package interview;

/**
 * @author kanglo
 * @create 2020-10-2020/10/18 14:30
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null){
            ListNode start = cur.next;
            ListNode end = cur.next.next;
            cur.next = end;
            start.next = end.next;
            end.next = start;
            cur = start;

        }
        return dummyHead.next;
    }
}
