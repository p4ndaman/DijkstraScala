package test.scala.graph

import java.io.File

import main.scala.graph.{Edge, DiGraphFileParser, DiGraph, Node}
import org.scalatest.WordSpec
import test.scala.graph.TestUtil.getFile

/**
 * Created by mayur.pandya on 12/22/14.
 */
class DiGraphFileParserSpec extends WordSpec {

  "An adjacency list structured file" should {
    "should parse to the following directional graph" in {
      val diGraph:DiGraph = new DiGraphFileParser() parseFile getFile("graph0.txt")
      val node1Edges:Seq[Edge] = diGraph getEdges Node("1")
      assert(node1Edges.size == 3)
      assertResult(Edge(Node("1"),Node("2"),5)) {node1Edges(0)}
      assertResult(Edge(Node("1"),Node("3"),8)) {node1Edges(1)}
      assertResult(Edge(Node("1"),Node("4"),7)) {node1Edges(2)}

      val node2Edges:Seq[Edge] = diGraph getEdges Node("2")
      assert(node2Edges.size == 3)
      assertResult(Edge(Node("2"),Node("3"),6)) {node2Edges(0)}
      assertResult(Edge(Node("2"),Node("5"),3)) {node2Edges(1)}
      assertResult(Edge(Node("2"),Node("4"),10)) {node2Edges(2)}

      val node3Edges:Seq[Edge] = diGraph getEdges Node("3")
      assert(node3Edges.size == 1)
      assertResult(Edge(Node("3"),Node("1"),8)) {node3Edges(0)}

      val node4Edges:Seq[Edge] = diGraph getEdges Node("4")
      assert(node4Edges.size == 2)
      assertResult(Edge(Node("4"),Node("2"),11)) {node4Edges(0)}
      assertResult(Edge(Node("4"),Node("3"),5)) {node4Edges(1)}
    }
  }
}
