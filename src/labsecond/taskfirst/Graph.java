package labsecond.taskfirst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    private final Map<String, ArrayList<String>> adjList = new HashMap<>();
    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1,String vertex2){
        if(adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);

            if(!isDirected) {
                adjList.get(vertex2).add(vertex1);
            }
            return true;
        }
        return false;
    }

    public void printGraph() {
        System.out.println(adjList);
    }

}

