package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

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

        Graph numbers = new Graph(false, true);

        Vertex one = numbers.addVertex("1");
        Vertex two = numbers.addVertex("2");
        Vertex three = numbers.addVertex("3");
        Vertex four = numbers.addVertex("4");
        Vertex five = numbers.addVertex("5");
        Vertex six = numbers.addVertex("6");
        Vertex seven = numbers.addVertex("7");

        numbers.addEdge(one, two, 0);
        numbers.addEdge(one, three, 0);
        numbers.addEdge(three, four, 0);
        numbers.addEdge(four, five, 0);
        numbers.addEdge(five, six, 0);
        numbers.addEdge(six, seven, 0);

        // DFS
        Stack<Vertex> stack = new Stack<>();
        HashSet<Vertex> visited = new HashSet<>();

        stack.push(one);
        visited.add(one);

        while(!stack.isEmpty()){
            Vertex curr = stack.pop();
            for(Edge e : curr.getEdges()){
                if(!visited.contains(e.getEnd())){
                    visited.add(e.getEnd());
                    stack.push(e.getEnd());
                }
            }
        }

        for(Vertex v : visited){
            System.out.println(v.getData());
        }
    }
}
