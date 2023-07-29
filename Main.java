public class Main {
    public static void main(String[] args) {

        MyDirectedGraph<Integer> graph = new MyDirectedGraph<>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        System.out.println("Graph:");
        graph.printGraph();
        System.out.println("Graph has edge from 1 to 2: " + graph.hasEdge(1, 2));
        System.out.println("Graph has edge from 3 to 2: " + graph.hasEdge(3, 2));

        System.out.print("Neighbors of vertex 1: ");
        graph.getNeighbors(1).forEach(vertex -> System.out.print(vertex + " "));
        System.out.println();

        System.out.print("DFS starting from vertex 1: ");
        graph.DFS(1);
        System.out.println();

        System.out.print("BFS starting from vertex 1: ");
        graph.BFS(1);
        System.out.println();

        graph.removeEdge(1, 3);

        System.out.println("Updated Graph:");
        graph.printGraph();
    }
}

