package interview;

import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/13 20:16
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null && cur.next != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode reverseBetween(ListNode head,int m,int n){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead.next;
        ListNode g = dummyHead;
        for (int i = 0;i < m - 1;i++){
            p = p.next;
            g = g.next;
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
