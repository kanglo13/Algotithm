package List;

public class ReverseList {
    private ListNode successor = null;
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
    public ListNode reverse(ListNode head){
        if (head == null)
            return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    public ListNode reverseN(ListNode head,int N){
        if (N == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,N-1);
        head.next.next = head;
        head.next = successor;
        return last;
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
