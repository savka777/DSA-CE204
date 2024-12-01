package Graph.Algorithms;

import Graph.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Kruskal {
    private static HashMap<Vertex,Vertex> parents = new HashMap<>();
    private static HashMap<Vertex,Integer> sizes = new HashMap<>();

    private static Vertex find(Vertex x){
        while(parents.get(x) != x){
            x = parents.get(x);
        }
        return x;
    }

    private static void union(Vertex x, Vertex y){
        Vertex xRoot = find(x);
        Vertex yRoot = find(y);

        if(xRoot != yRoot){
            if(sizes.get(yRoot) < sizes.get(xRoot)){
                parents.put(yRoot, xRoot);
                sizes.put(xRoot, sizes.get(xRoot) + sizes.get(yRoot));
            }else{
                parents.put(xRoot,yRoot);
                sizes.put(yRoot, sizes.get(yRoot) + sizes.get(xRoot));
            }
        }
    }

    public static Graph makeMST(Graph g){

        // get edges and store them in a sorted list
        ArrayList<Edge> edges = new ArrayList<>();
        ArrayList<Vertex> vertices = g.getVertices();
        Graph mst = new Graph(true,false);

        // making sure sets are unique
        HashSet<Edge> uniqueEdges = new HashSet<>();
        for( Vertex v : vertices){
            uniqueEdges.addAll(v.getEdges());
        }

        edges.addAll(uniqueEdges);
        Collections.sort(edges);

        HashSet<String> addedEdges = new HashSet<>();

        // union-find (naive approach in O(n)
        for(Vertex v : vertices){
            parents.put(v,v); // each vertex is its own subset and parent upon init
            sizes.put(v, 1);
        }

        for(Edge e : edges){
            Vertex start = e.getStart();
            Vertex end = e.getEnd();

            // making sure duplicate edges are not added
            String edgeId = System.identityHashCode(start) + "-" + System.identityHashCode(end);
            String reverseEdgeId = System.identityHashCode(end) + "-" + System.identityHashCode(start);

            if(find(start) != find(end) && !addedEdges.contains(edgeId) && !addedEdges.contains(reverseEdgeId)){
                Vertex tmp1 = start;
                Vertex tmp2 = start;
                tmp1 = mst.addVertex(start.getData());
                tmp2 = mst.addVertex(end.getData());
                mst.addEdge(tmp1,tmp2,e.getWeight());

                addedEdges.add(edgeId);
                addedEdges.add(reverseEdgeId);
                union(start,end);
            }
        }

        return mst;
    }
}
