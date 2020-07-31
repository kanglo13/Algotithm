package List.reverse;

public class ReverseBetween {
    private ListNode successor = null;
    public ListNode reverseBetween(ListNode head,int m,int n){
        if (m == 1)
            return reverseN(head,n);
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }
    private ListNode reverseN(ListNode head,int n){
        if (n == 1){
            successor = head.next;
            return head;
        }
        ListNode next = reverseN(head.next,n-1);
        head.next.next = next;
        head.next = successor;
        return head;
    }
    public ListNode reverseBetweenII(ListNode head,int m,int n){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;
        for (int i = 0;i < m - 1;i++){
            g = g.next;
            p = p.next;
        }
        for (int i = 0;i < n - m;i++){
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }
}
