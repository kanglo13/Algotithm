package List;

public class Partition {
    public ListNode partition(ListNode head,int x){
        ListNode dummyHead1 = new ListNode(-1);
        ListNode dummyHead2 = new ListNode(-1);
        ListNode cur1 = dummyHead1;
        ListNode cur2 = dummyHead2;
        while(head != null){
            if (head.val < x){
                cur1.next = head;
                head = head.next;
                cur1 = cur1.next;
                cur1.next = null;
            }
            else {
                cur2.next = head;
                head = head.next;
                cur2 = cur2.next;
                cur2.next = null;
            }
        }
        cur1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
