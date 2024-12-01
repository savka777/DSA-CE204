package Graph;

public class Edge implements Comparable<Edge> {
    private Vertex start;
    private Vertex end;
    private Integer weight;

    public Edge(Vertex s, Vertex e, Integer w){
        this.start = s;
        this.end = e;
        this.weight = w;
    }

    public Vertex getStart(){
        return this.start;
    }

    public Vertex getEnd(){
        return this.end;
    }

    public Integer getWeight(){
        return this.weight;
    }

    public int compareTo(Edge other){
        return Integer.compare(this.weight, other.weight);
    }
}
