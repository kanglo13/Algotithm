package List;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[]lists){
        if (lists == null || lists.length == 0)
            return null;
        return merge(lists,0,lists.length-1);
    }
    private ListNode merge(ListNode[]lists,int left,int right){
        if (left == right)
            return lists[left];
        int mid = left + (right - left) / 2;
        ListNode leftNode = merge(lists,left,mid);
        ListNode rightNode = merge(lists,mid+1,right);
        return merge(leftNode,rightNode);
    }
    private ListNode merge(ListNode list1,ListNode list2){
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val){
            list1.next = merge(list1.next,list2);
            return list1;
        }
        else {
            list2.next = merge(list1,list2.next);
            return list2;
        }
    }
}
