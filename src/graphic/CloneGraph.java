package graphic;

import java.util.*;

public class CloneGraph {
    private Map<Node,Node>map = new HashMap<>();
    public Node cloeGraph(Node node){
        return dfs(node);
    }
    private Node dfs(Node node){
        if (node == null)
            return null;
        if (map.containsKey(node))
            return node;
        Node clone = new Node(node.val,new ArrayList<>());
        map.put(node,clone);
        for (Node next : node.neighbors){
            clone.neighbors.add(dfs(next));
        }
        return clone;
    }
    private Node bfs(Node node){
        if (node == null)
            return null;
        Map<Node,Node>map = new HashMap<>();
        Node clone = new Node(node.val,new ArrayList<>());
        map.put(node,clone);
        Queue<Node>queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            for (Node next : cur.neighbors){
                if (!map.containsKey(next)){
                    map.put(next,new Node(next.val,new ArrayList<>()));
                    queue.offer(next);
                }
                map.get(cur).neighbors.add(map.get(next));
            }
        }
        return clone;
    }
}
