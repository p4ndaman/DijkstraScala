package test.scala.graph

import main.scala.graph.{Node, Edge, DiGraphFileParser, DiGraph}

/**
 * Created by mayur.pandya on 12/24/14.
 */
object DiGraphMain {
  def main (args: Array[String]) {
    val diGraph:DiGraph = new DiGraphFileParser() parseFile "resource/test0.txt"
    val edges:Seq[Edge] = diGraph.getEdges(Node("1")).get

  }
}
