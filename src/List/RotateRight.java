package List;

import java.util.List;

public class RotateRight {
    public ListNode rotateRight(ListNode head,int k){
        if (head == null || head.next == null || k == 0)
            return head;
        int n = 1;
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            n++;
        }
        k%=n;
        if(k == 0)
            return head;
        cur.next = head;
        for (int i = 0;i < n - k;i++){
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }
}
