package daily;

import java.util.List;

/**
 * @author kanglo
 * @create 2021-03-2021/3/18 20:01
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head,int left,int right){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 1;i < left;i++)
            pre = pre.next;
        head = pre.next;
        for (int i = left;i < right;i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummyHead.next;
    }
}
