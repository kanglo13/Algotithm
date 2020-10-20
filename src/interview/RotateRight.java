package interview;

import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 20:36
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head,int k){
        int n = 1;
        ListNode cur = head;
        while (cur.next != null){
            n++;
            cur = cur.next;
        }
        k %= n;
        if (k == 0)
            return head;
        cur.next = head;
        for (int i = 0;i < n -k;i++){
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;

    }
}
