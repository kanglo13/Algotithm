package daily;

import java.util.List;

public class ReverseKGroups {
    public ListNode reverseKGroup(ListNode head,int k){
        if (head == null)
            return head;
        ListNode a = head;
        ListNode b = head;
        for (int i = 0;i < k;i++){
            if (b == null)
                return head;
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        newHead.next = reverseKGroup(b,k);
        return newHead;
    }
    private ListNode reverse(ListNode a,ListNode b){
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
