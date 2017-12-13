package edu.luc.cs.cs271.lab2;

import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.RandomWalkIterator;

public class CountryCodes {
  int count;
  static final String NV = "Nevada";
  static final String CA = "California";
  static final String OR = "Oregon";
  static final String ID = "Idaho";
  static final String UT = "Utah";
  static final String AZ = "Arizona";

  Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);

  public CountryCodes(Graph<String, DefaultEdge> myMap) {
    this.myMap = myMap;
  }

  public Graph<String, DefaultEdge> Map() {

    myMap.addVertex(NV);
    myMap.addVertex(CA);
    myMap.addVertex(OR);
    myMap.addVertex(ID);
    myMap.addVertex(UT);
    myMap.addVertex(AZ);

    myMap.addEdge(NV, CA);
    myMap.addEdge(NV, OR);
    myMap.addEdge(NV, ID);
    myMap.addEdge(NV, UT);
    myMap.addEdge(NV, AZ);
    myMap.addEdge(CA, OR);
    myMap.addEdge(CA, AZ);
    myMap.addEdge(OR, ID);
    myMap.addEdge(ID, UT);
    myMap.addEdge(UT, AZ);

    return myMap;
  }

  public void BreadthFirstIterator() {
    final Iterator<String> bf = new BreadthFirstIterator(myMap, NV);

    for (count = 0; count < 6; count++) {
      if (bf.hasNext()) {
        final String country = bf.next();
        System.out.println(country);

      } else return;
    }
  }

  public void ClosestFirstIterator() {
    final Iterator<String> cf = new ClosestFirstIterator(myMap, NV);
    for (count = 0; count < 6; count++) {
      if (cf.hasNext()) {
        final String country = cf.next();
        System.out.println(country);
      } else return;
    }
  }

  public void DepthFirstIterator() {
    final Iterator<String> df = new DepthFirstIterator(myMap, NV);
    for (count = 0; count < 6; count++) {
      if (df.hasNext()) {
        final String country = df.next();
        System.out.println(country);
      } else return;
    }
  }

  public void RandomWalkIterator() {
    final Iterator<String> rw = new RandomWalkIterator<>(myMap, NV);
    for (count = 0; count < 6; count++) {
      if (rw.hasNext()) {
        final String country = rw.next();
        System.out.println(country);
      } else return;
    }
  }

  public void Coloring() {
    GreedyColoring<String, DefaultEdge> color = new GreedyColoring<>(myMap);
    System.out.println(color.getColoring());
  }
}
