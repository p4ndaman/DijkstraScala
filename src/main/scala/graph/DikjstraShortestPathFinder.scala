package main.scala.graph

import scala.collection.mutable
import scala.collection.immutable
import scala.math.Ordering.Implicits._

/**
 * Created by mayur.pandya on 1/4/15.
 */
class DikjstraShortestPathFinder(val graph:DiGraph) {
  var cameFrom:mutable.HashMap[Node,Edge] = new mutable.HashMap[Node,Edge]()
  var frontier:mutable.PriorityQueue[(Node,Int)] = new mutable.PriorityQueue[(Node,Int)]()(Ordering.by((v:(Node,Int)) => v._2))
  var costSoFar:mutable.HashMap[Node,Int] = new mutable.HashMap[Node,Int]()

  def findShortestPath(start: Node, goal: Node): Seq[Edge] = {
    cameFrom.clear()
    costSoFar.clear()
    frontier.enqueue((start, 0))
    costSoFar.put(start, 0)

    while (!frontier.isEmpty) addEligibleNeighbors(frontier.dequeue()_1)

    unravelPath(goal)
  }

  def addEligibleNeighbors(node:Node):Unit = {
    graph.getEdges(node) filter (determineEligibility(_)) foreach ( addNeighbor(_) )
  }

  def determineEligibility(edge:Edge):Boolean = {
    costSoFar get edge.endNode match {
      case Some(previousCost) => costSoFarToEnd(edge) < previousCost
      case None => true
    }
  }

  def addNeighbor(edge:Edge):Unit = {
    val costSoFarTilEnd = costSoFarToEnd(edge)
    cameFrom.put(edge.endNode, edge)
    costSoFar.put(edge.endNode, costSoFarTilEnd)
    frontier.enqueue((edge.endNode, costSoFarTilEnd))
  }

  def costSoFarToEnd(edge:Edge):Int = edge.cost + costSoFar.get(edge.startNode).get

  def unravelPath(node:Node):Seq[Edge] = {
    cameFrom get node match {
      case Some(edge) => unravelPath(edge.startNode):+edge
      case None => Seq.empty
    }
  }
}
