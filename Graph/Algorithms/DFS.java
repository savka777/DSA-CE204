package Graph.Algorithms;

import Graph.Edge;
import Graph.Vertex;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    public static void dfs(Vertex start) {
        Stack<Vertex> stack = new Stack<>();
        HashSet<Vertex> visited = new HashSet<>();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            Vertex curr = stack.pop();
            System.out.println(curr.getData());

            for (Edge e : curr.getEdges()) {
                Vertex neighbor = e.getEnd();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
    }
}
