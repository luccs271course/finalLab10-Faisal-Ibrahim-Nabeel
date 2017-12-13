/*
 * (C) Copyright 2017-2017, by Dimitrios Michail and Contributors.
 *
 * JGraphT : a free Java graph-theory library
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */
package org.jgrapht.alg.scoring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;
import org.jgrapht.*;
import org.jgrapht.alg.interfaces.*;
import org.jgrapht.graph.*;
import org.junit.*;

/**
 * Unit tests for {@link Coreness}.
 *
 * @author Dimitrios Michail
 */
public class CorenessTest {
  @Test
  public void testGraph() {
    SimpleGraph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

    Graphs.addAllVertices(g, Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));
    g.addEdge("b", "c");
    g.addEdge("c", "d");
    g.addEdge("c", "e");
    g.addEdge("e", "f");
    g.addEdge("e", "g");
    g.addEdge("e", "h");
    g.addEdge("f", "g");
    g.addEdge("f", "h");
    g.addEdge("g", "h");

    Coreness<String, DefaultEdge> pr = new Coreness<String, DefaultEdge>(g);

    assertEquals(Integer.valueOf(0), pr.getVertexScore("a"));
    assertEquals(Integer.valueOf(1), pr.getVertexScore("b"));
    assertEquals(Integer.valueOf(1), pr.getVertexScore("c"));
    assertEquals(Integer.valueOf(1), pr.getVertexScore("d"));
    assertEquals(Integer.valueOf(3), pr.getVertexScore("e"));
    assertEquals(Integer.valueOf(3), pr.getVertexScore("f"));
    assertEquals(Integer.valueOf(3), pr.getVertexScore("g"));
    assertEquals(Integer.valueOf(3), pr.getVertexScore("h"));

    assertEquals(3, pr.getDegeneracy());
  }

  @Test
  public void testAnotherGraph() {
    SimpleGraph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

    Graphs.addAllVertices(g, Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
    g.addEdge("b", "c");
    g.addEdge("c", "d");
    g.addEdge("c", "e");
    g.addEdge("e", "f");
    g.addEdge("e", "g");
    g.addEdge("e", "h");
    g.addEdge("f", "g");
    g.addEdge("f", "h");
    g.addEdge("f", "i");
    g.addEdge("g", "h");
    g.addEdge("i", "j");
    g.addEdge("i", "k");
    g.addEdge("j", "k");

    Coreness<String, DefaultEdge> pr = new Coreness<String, DefaultEdge>(g);

    assertEquals(Integer.valueOf(0), pr.getVertexScore("a"));
    assertEquals(Integer.valueOf(1), pr.getVertexScore("b"));
    assertEquals(Integer.valueOf(1), pr.getVertexScore("c"));
    assertEquals(Integer.valueOf(1), pr.getVertexScore("d"));
    assertEquals(Integer.valueOf(3), pr.getVertexScore("e"));
    assertEquals(Integer.valueOf(3), pr.getVertexScore("f"));
    assertEquals(Integer.valueOf(3), pr.getVertexScore("g"));
    assertEquals(Integer.valueOf(3), pr.getVertexScore("h"));
    assertEquals(Integer.valueOf(2), pr.getVertexScore("i"));
    assertEquals(Integer.valueOf(2), pr.getVertexScore("j"));
    assertEquals(Integer.valueOf(2), pr.getVertexScore("k"));

    assertEquals(3, pr.getDegeneracy());
  }

  @Test
  public void testSingletonGraph() {
    SimpleGraph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

    Graphs.addAllVertices(g, Arrays.asList("a"));

    Coreness<String, DefaultEdge> pr = new Coreness<String, DefaultEdge>(g);

    assertEquals(Integer.valueOf(0), pr.getVertexScore("a"));
    assertEquals(0, pr.getDegeneracy());
  }

  @Test
  public void testEmptyGraph() {
    SimpleGraph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

    VertexScoringAlgorithm<String, Integer> pr = new Coreness<>(g);

    assertTrue(pr.getScores().isEmpty());
  }

  @Test
  public void testNonExistantVertex() {
    SimpleGraph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

    g.addVertex("a");

    VertexScoringAlgorithm<String, Integer> pr = new Coreness<>(g);

    try {
      pr.getVertexScore("unknown");
      fail("No!");
    } catch (IllegalArgumentException e) {
    }
  }

  @Test
  public void testBadParameters() {
    try {
      new Coreness<>(null);
      fail("No!");
    } catch (NullPointerException e) {
    }
  }
}
