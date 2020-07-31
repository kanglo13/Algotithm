package List.reverse;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head,int k){
        if (head == null)
            return head;
        ListNode a = head, b = head;
        for (int i = 0;i < k;i++){
            if (b == null)
                return head;
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }
    public ListNode reverse(ListNode a,ListNode b){
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
