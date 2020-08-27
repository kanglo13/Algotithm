package daily;

import java.util.*;

/**
 * @author kanglo
 * @create 2020-08-2020/8/27 8:10
 */
public class FindItinerary {
    public List<String>findItinerary(List<List<String>>tickets){
        LinkedList<String>result = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return result;
        Map<String, PriorityQueue<String>>graph = new HashMap<>();
        for (List<String> ticket : tickets){
            PriorityQueue<String> queue = graph.computeIfAbsent(ticket.get(0),k -> new PriorityQueue<>());
            queue.add(ticket.get(1));
        }
        dfs(graph,"JFK",result);
        return result;
    }
    private void dfs(Map<String,PriorityQueue<String>>graph,String src,LinkedList<String>result){
        PriorityQueue<String>queue = graph.get(src);
        while (!queue.isEmpty()){
            String cur = queue.poll();
            dfs(graph,cur,result);
        }
        result.add(0,src);
    }

}
