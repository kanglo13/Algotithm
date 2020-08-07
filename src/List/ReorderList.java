package List;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList {
    public void reorderList(ListNode head){
        Deque<ListNode>deque = new LinkedList<>();
        ListNode cur = head;
        while(cur != null){
            deque.addLast(cur);
        }
        while (!deque.isEmpty()){
            if(cur ==  null){
                cur = deque.pollFirst();
                cur = cur.next;
            }else {
                cur.next = deque.pollFirst();
                cur = cur.next;
            }
            cur.next = deque.pollLast();
            cur = cur.next;
        }
        if (cur != null)
            cur.next = null;
    }
}
