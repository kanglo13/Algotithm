package daily;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head){
        if (head == null)
            return null;
        Set<Integer>set= new HashSet<>();
        ListNode pre = head;
        ListNode cur = head.next;
        set.add(pre.val);
        while (cur != null){
            if (set.contains(cur.val)){
                pre.next = cur.next;
                cur = cur.next;
            }
            else {
                set.add(cur.val);
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

}
