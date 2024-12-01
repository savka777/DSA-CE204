package Graph;

import Graph.Algorithms.DFS;
import static Graph.Algorithms.Kruskal.makeMST;


public class Main {
    public static void main(String[] args) {
//        Graph essexCities = new Graph(true, false);
//
//        Vertex chelmsford = essexCities.addVertex("Chelmsford");
//        Vertex colchester =  essexCities.addVertex("Colchester");
//        Vertex southend = essexCities.addVertex("Southend");
//
//
//        // undirected
//        essexCities.addEdge(chelmsford, colchester, 45);
//        essexCities.addEdge(colchester, southend, 30);
//
//        essexCities.print();

        Graph numbers = new Graph(true, false);

        Vertex one = numbers.addVertex("1");
        Vertex two = numbers.addVertex("2");
        Vertex three = numbers.addVertex("3");
        Vertex four = numbers.addVertex("4");
        Vertex five = numbers.addVertex("5");
        Vertex six = numbers.addVertex("6");
        Vertex seven = numbers.addVertex("7");

        numbers.addEdge(one, two, 3);
        numbers.addEdge(one, three, 5);
        numbers.addEdge(three, four, 2);
        numbers.addEdge(four, five, 1);
        numbers.addEdge(five, six, 4);
        numbers.addEdge(six, seven, 6);
        numbers.addEdge(two, four, 3);

//        DFS.dfs(one);
        Graph mst = makeMST(numbers);
        mst.print();

    }
}
