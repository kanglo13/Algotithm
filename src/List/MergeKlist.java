package List;

public class MergeKlist {
    public ListNode mergeKLists(ListNode[]lists){
        if (lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists,0,lists.length-1);
    }
    private ListNode mergeKLists(ListNode[]lists,int left,int right){
        if (left == right)
            return lists[left];
        int mid = (left + right) >>> 1;
        ListNode leftHead = mergeKLists(lists,left,mid);
        ListNode rightHead = mergeKLists(lists,mid+1,right);
        return merge(leftHead,rightHead);
    }

    private ListNode merge(ListNode l1,ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}
