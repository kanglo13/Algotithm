package interview;

import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 11:39
 */
public class Partition {
    public ListNode partition(ListNode head,int x) {
        ListNode head1 = new ListNode(-1);
        ListNode l1 = head1;
        ListNode head2 = new ListNode(-1);
        ListNode l2 = head2;
        ListNode cur = head;
        while (cur != null){
            if (cur.val < x){
                l1.next = cur;
                l1 = l1.next;
            }
            else {
                l2.next = cur;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        l2.next = null;
        l1.next = head2.next;
        return head1.next;

    }
}