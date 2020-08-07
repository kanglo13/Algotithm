package List;

public class RemoveElements {
    public ListNode removeElements(ListNode head,int val){
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode cur = dummyHead;
            while(cur.next != null){
                if(cur.next.val == val){
                    cur.next = cur.next.next;
                }
                else {
                    cur = cur.next;
                }
            }
            return dummyHead.next;
    }
}
