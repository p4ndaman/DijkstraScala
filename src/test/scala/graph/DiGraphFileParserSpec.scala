package test.scala.graph

import main.scala.graph.{Edge, DiGraphFileParser, DiGraph, Node}
import org.scalatest.WordSpec

/**
 * Created by mayur.pandya on 12/22/14.
 */
class DiGraphFileParserSpec extends WordSpec {

  "A adjacency list structured file" should {
    "should parse to the following graph" in {
      //TODO: find a way to parse relative path
      val diGraph:DiGraph = new DiGraphFileParser() parseFile "/Users/mayur.pandya/workspace/competency/src/test/scala/graph/resource/test0.txt"
      val edges:Seq[Edge] = diGraph.getEdges(Node("1")).get
      assert(edges.size == 3)
    }
  }

}
