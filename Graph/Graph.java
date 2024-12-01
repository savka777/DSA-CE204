package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Graph {

    private ArrayList<Vertex> vertices;
    private boolean isWeighted;
    private boolean isDirected;

    public Graph(boolean isWeighted, boolean isDirected){
        this.vertices = new ArrayList<Vertex>();
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }


    public Vertex addVertex(String data){
        Vertex vertex = new Vertex(data);
        vertices.add(vertex);
        return vertex;
    }

    public void addEdge(Vertex start, Vertex end, Integer w){
        if(!this.isWeighted){
           w = null;
        }

        start.addEdge(end,w);

        if(!this.isDirected){
            end.addEdge(start,w);
        }
    }

    public void removeEdge(Vertex start, Vertex end){
        start.removeEdge(end);

        if(!isDirected){
            end.removeEdge(start);
        }
    }
    public void removeVertex(Vertex v){
        this.vertices.remove(v);
    }

    public ArrayList<Vertex> getVertices(){
        return this.vertices;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public Vertex getVertexByValue(String value){
        for(Vertex v : this.vertices){
            if(v.getData() == value){
                return v;
            }
        }
        return null;
    }
    public void print() {
        HashSet<String> printedEdges = new HashSet<>();
        for (Vertex v : this.vertices) {
            v.print(this.isWeighted, printedEdges);
        }
    }

}
