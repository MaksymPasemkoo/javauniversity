package lab2.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph<T> {

    private final Map<T, ArrayList<T>> adjList = new HashMap<>();
    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public void addVertex(T vertex) {
        adjList.computeIfAbsent(vertex, k -> new ArrayList<>());
    }

    public void addEdge(T vertex1, T vertex2){
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            if(!isDirected) {
                adjList.get(vertex2).add(vertex1);
            }
        }
    }

    public void printGraph() {
        System.out.println(adjList);
    }

}

