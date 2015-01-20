package main.scala.graph

import java.io.File

import scala.io.Source
import main.scala.utility.extractors.Int

/**
 * Assumes file is structured as adjacency list.
 * Each line starts with node ID, followed by edges that start form node (delimited by ',')
 * Edge definition contains destination node and cost, delimited by ':'
 * Example:
 * 1,2:5,3:8,5:7
 * Node 1 has edges to 2, 3, and 5 with costs 5, 8, and 7 respectively.
 *
 * Created by mayur.pandya on 12/24/14.
 */
class DiGraphFileParser {
  lazy val digraph:DiGraph = new DiGraph();

  def parseFile(file:File):DiGraph = {
    Source.fromFile(file).getLines() foreach (line =>
      (line.split(','):Seq[String]) match {
        case startNodeId+:rest => parseEdges(startNodeId, rest);
      })
    digraph
  }

  def parseEdges(startNodeId:String, edgeDefs:Seq[String]):Unit = {
    val startNode:Node = Node(startNodeId)
    (edgeDefs flatMap (edgeDef => parseEdge(startNode,edgeDef))) foreach {
      digraph addDirectedEdge _
    }

  }

  def parseEdge(startNode:Node, edgeDef:String):Option[Edge] = {
    edgeDef.split(':') match {
      case Array(endNodeId, Int(cost)) => Some(new Edge(startNode, Node(endNodeId), cost))
    }
  }
}


