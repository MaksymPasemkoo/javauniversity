package labsecond.taskfirst;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(false);
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
