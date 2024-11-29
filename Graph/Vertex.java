package Graph;

import java.util.ArrayList;

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

    public void print(boolean isWeighted) {
        if (this.edges.size() == 0) {
            System.out.println(this.data + " --> [No connections]");
            return;
        }

        StringBuilder message = new StringBuilder();
        message.append(this.data).append(" --> ");

        for (int i = 0; i < this.edges.size(); i++) {
            message.append(this.edges.get(i).getEnd().data); // Add the target vertex

            if (isWeighted) {
                message.append(" (").append(this.edges.get(i).getWeight()).append(")"); // Add weight if applicable
            }

            if (i != this.edges.size() - 1) {
                message.append(" -> "); // Add arrow for better visualization
            }
        }

        System.out.println(message);
    }


}
