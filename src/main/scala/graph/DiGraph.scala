package main.scala.graph

import scala.collection.mutable

/**
 * Created by mayur.pandya on 12/21/14.
 */
class DiGraph() {
  val adjacencyList:mutable.HashMap[Node, Seq[Edge]] = new mutable.HashMap[Node, Seq[Edge]]();

  def addDirectedEdge(edge:Edge):Unit = {
    val adjacentList:Seq[Edge] = adjacencyList.get(edge.startNode) match {
      case Some(existingList) => existingList
      case None => Seq[Edge]()
    }
    adjacencyList.put(edge.startNode, adjacentList:+edge)
  }

  def getEdges(node:Node): Option[Seq[Edge]] = {
    adjacencyList get node
  }

}