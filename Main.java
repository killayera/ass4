public class Main {
    public static void main(String[] args) {

        MyDirectedGraph<Integer> graph = new MyDirectedGraph<>();

        // Add vertices to the graph
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
    }
}