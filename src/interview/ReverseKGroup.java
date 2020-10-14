package interview;

import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/13 20:42
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head,int k){
        ListNode a,b;
        a = b = head;
        for (int i = 0;i < k;i++){
            if (b == null)
                return head;
            b = b.next;
        }
        ListNode newHead = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newHead;
    }
    private ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        ListNode next;
        while (cur.next != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
