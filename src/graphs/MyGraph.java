package graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MyGraph {
  public Map<Integer, List<Integer>> graph;

  public MyGraph() {
    graph = new HashMap<>();
  }
  
  public void addEdge(int from, int to) {
    graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
  }

  public List<Integer> bfs(int start) {
    ArrayList<Integer> result = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      if (!visited.contains(curr)) {
        visited.add(curr);
        for (int neighbor : graph.get(curr)) {
          if (!visited.contains(neighbor)) queue.add(neighbor);
        }
        result.add(curr);
      }
    }
    return result;
  }

  public List<Integer> dfsIterative(int start) {
    // 1. Iterative Version
    ArrayList<Integer> result = new ArrayList<>();
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    HashSet<Integer> visited = new HashSet<>();
    stack.add(start);

    while (!stack.isEmpty()) {
      int curr = stack.pop();

      if (!visited.contains(curr)) {
        visited.add(curr);
        for (int neighbor : graph.get(curr)) {
          if (!visited.contains(neighbor)) stack.add(neighbor);
        }
        result.add(curr);
      }
    }
    return result;
  }

  public List<Integer> dfsRecursive(int start) {
    // 2. Recursive Version
    ArrayList<Integer> result = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();
    dfsHelper(start, visited, result);
    return result;
  }
  
  private void dfsHelper(int node, HashSet<Integer> visited, ArrayList<Integer> result) {
    if (visited.contains(node)) return;

    visited.add(node);
    result.add(node);

    for (int neighbor : graph.get(node)) {
      dfsHelper(neighbor, visited, result);
    }
  }
}
