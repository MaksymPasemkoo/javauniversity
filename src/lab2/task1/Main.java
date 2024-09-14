package lab2.task1;

public class Main {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>(true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A","B");
        graph.addEdge("B","C");
        graph.addEdge("C","D");
        graph.addEdge("D","A");
        graph.printGraph();
    }
}
