package edu.luc.cs.cs271.lab2;

import org.jgrapht.*;
import org.jgrapht.graph.*;

public class Main {

  public static void main(final String[] args) {

    UndirectedGraph<String, DefaultEdge> g =
        new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
    CountryCodes map = new CountryCodes(g);
    g = (UndirectedGraph<String, DefaultEdge>) map.Map();
    System.out.println(g);

    System.out.println("\nSearching by Breadth-First Algorithm");
    map.BreadthFirstIterator();
    System.out.println("\nSearching by Closest-First Algorithm");
    map.ClosestFirstIterator();
    System.out.println("\nSearching by Depth-First Algorithm");
    map.DepthFirstIterator();
    System.out.println("\nSearching by Random-Walk Algorithm");
    map.RandomWalkIterator();

    System.out.println("\nColoring Algorithm");
    map.Coloring();
  }
}
