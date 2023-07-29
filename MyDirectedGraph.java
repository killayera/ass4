import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MyDirectedGraph<Vertex> {
    private Map<Vertex, List<Vertex>> adjacencyList;

    public MyDirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex from, Vertex to) {
        validateVertex(from);
        validateVertex(to);
        adjacencyList.get(from).add(to);
    }

    private void validateVertex(Vertex vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex + " is out of range");
        }
    }

    public void removeEdge(Vertex from, Vertex to) {
        validateVertex(from);
        validateVertex(to);
        adjacencyList.get(from).remove(to);
    }

    public boolean hasEdge(Vertex from, Vertex to) {
        validateVertex(from);
        validateVertex(to);
        List<Vertex> neighbors = adjacencyList.get(from);
        return neighbors != null && neighbors.contains(to);
    }

    public List<Vertex> getNeighbors(Vertex vertex) {
        validateVertex(vertex);
        return adjacencyList.getOrDefault(vertex, new LinkedList<>());
    }

    public void DFS(Vertex startVertex) {
        validateVertex(startVertex);
        Map<Vertex, Boolean> visited = new HashMap<>();
        for (Vertex vertex : adjacencyList.keySet()) {
            visited.put(vertex, false);
        }
        DFS(startVertex, visited);
    }

    private void DFS(Vertex vertex, Map<Vertex, Boolean> visited) {
        visited.put(vertex, true);
        System.out.print(vertex + " ");
        for (Vertex neighbor : adjacencyList.get(vertex)) {
            if (!visited.get(neighbor)) {
                DFS(neighbor, visited);
            }
        }
    }

    public void BFS(Vertex startVertex) {
        validateVertex(startVertex);

        Map<Vertex, Boolean> visited = new HashMap<>();
        for (Vertex vertex : adjacencyList.keySet()) {
            visited.put(vertex, false);
        }

        Queue<Vertex> queue = new LinkedList<>();
        visited.put(startVertex, true);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (Vertex neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.get(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void printGraph() {
        for (Map.Entry<Vertex, List<Vertex>> entry : adjacencyList.entrySet()) {
            Vertex vertex = entry.getKey();
            System.out.print("Vertex " + vertex + " points to: ");
            List<Vertex> neighbors = entry.getValue();
            for (Vertex neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}