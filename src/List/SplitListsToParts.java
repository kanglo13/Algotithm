package List;

public class SplitListsToParts {
    public ListNode[] splitListToParts(ListNode root,int k){
        ListNode cur = root;
        int n = 0;
        while (cur != null){
            n++;
            cur = cur.next;
        }
        int size = n / k;
        int mode = n % k;
        ListNode[]ret = new ListNode[k];
        cur = root;
        for (int i = 0;i < k && cur != null ;i++){
            ret[i] = cur;
            int curSize = size + (mode-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize -1;j++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ret;
    }
}
