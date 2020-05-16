package List;

public class ReverseList {
    public ListNode reverseList(ListNode head){
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
    public ListNode reverseList(ListNode a,ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        ListNode next = a;
        while (cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
