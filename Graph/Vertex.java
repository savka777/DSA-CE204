package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Vertex {
    // instance variables
    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String data){
        this.data = data;
        this.edges = new ArrayList<Edge>();
    }

    // add a outNeighbour
    public void addEdge(Vertex endVertex, Integer weight){
        this.edges.add(new Edge(this,endVertex,weight));
    }

    // removes a outNeighbour
    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }

    public String getData(){
        return this.data;
    }

    // return the edges that a vertex has (out neighbours)
    public ArrayList<Edge> getEdges(){
        return this.edges;
    }

    public void print(boolean isWeighted, HashSet<String> printedEdges) {
        if (this.edges.size() == 0) {
            System.out.println(this.data + " --> [No connections]");
            return;
        }

        for (Edge edge : this.edges) {
            String edgeId = System.identityHashCode(this) + "-" + System.identityHashCode(edge.getEnd());
            String reverseEdgeId = System.identityHashCode(edge.getEnd()) + "-" + System.identityHashCode(this);

            if (!printedEdges.contains(edgeId) && !printedEdges.contains(reverseEdgeId)) {
                printedEdges.add(edgeId);

                System.out.print(this.data + " --> " + edge.getEnd().getData());
                if (isWeighted) {
                    System.out.print(" (" + edge.getWeight() + ")");
                }
                System.out.println();
            }
        }
    }



}
