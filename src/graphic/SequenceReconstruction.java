package graphic;

import List.ListNode;

import java.util.*;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[]org, List<List<Integer>>seqs){
        if (org == null || org.length == 0 || seqs.size() == 0)
            return false;
        int n = org.length;
        Set<Integer>set = new HashSet<>();
        for (List<Integer>seq : seqs){
            for (int num : seq){
                if (num <= 0 || num > n)
                    return false;
                set.add(num);
            }
        }
        if (set.size() < n)
            return false;
        List<Integer>[]graphic = new List[n+1];
        for (int i = 1;i <= n;i++){
            graphic[i] = new ArrayList<>();
        }
        for (int i = 0;i < seqs.size();i++){
            List<Integer>seq = seqs.get(i);
            for (int j = 0;j < seq.size()-1;j++){
                graphic[seq.get(j)].add(seq.get(j+1));
            }
        }
        int[]indegrees = new int[n+1];
        for (int i = 1;i <= n;i++){
            for (int j = 0;j < graphic[i].size();j++){
                int w = graphic[i].get(j);
                indegrees[w]++;
            }
        }
        Queue<Integer>queue = new LinkedList<>();
        for (int i = 1;i <= n;i++){
            if (indegrees[i] == 0)
                queue.offer(i);
        }
        if (queue.size() != 1)
            return false;
        int index = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int cur = queue.poll();
                if (cur != org[index++])
                    return false;
                int start = 0;
                for (int next : graphic[cur]){
                    if (--indegrees[next] == 0){
                        if (++start > 1)
                            return false;
                        queue.offer(next);
                    }

                }
            }
        }
        return index == n;
    }
}
