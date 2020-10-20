package daily;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/20 9:31
 */
public class ReorderList {
    public void reorderList(ListNode head){
        Deque<ListNode>deque = new LinkedList<>();
        ListNode cur = head;
        while (cur != null){
            deque.addLast(cur);
            cur = cur.next;
        }
        while (!deque.isEmpty()){
            if (cur == null){
                cur = deque.pollFirst();
            }
            else {
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
