package interview;

import java.util.List;

/**
 * @author kanglo
 * @create 2020-10-2020/10/29 9:45
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[]list){
        if (list == null || list.length == 0)
            return null;
        return merge(list,0,list.length-1);
    }
    private ListNode merge(ListNode[]list,int left,int right){
        if (left > right)
            return null;
        if (left == right)
            return list[left];
        int mid = (left +right) >>> 1;
        ListNode leftNode = merge(list,left,mid);
        ListNode rightNode = merge(list,mid+1,right);
        return merge(leftNode,rightNode);
    }
    private ListNode merge(ListNode l1,ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}
