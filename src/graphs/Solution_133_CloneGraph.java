package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution_133_CloneGraph {
  public Node cloneGraph(Node node) {
    if (node == null) return node;

    HashMap<Node, Node> map = new HashMap<>();

    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    map.put(node, new Node(node.val));

    while (!queue.isEmpty()) {
      Node curr = queue.poll();

      for (Node neighbor : curr.neighbors) {
        if (!map.containsKey(neighbor)) {
          map.put(neighbor, new Node(neighbor.val));
          queue.add(neighbor);
        }
        map.get(curr).neighbors.add(map.get(neighbor));
      }
    }
    return map.get(node);
  }
}
