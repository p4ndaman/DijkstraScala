package test.scala.graph

import main.scala.graph.{Node, Edge, DiGraphFileParser, DiGraph, DikjstraShortestPathFinder}
import org.scalatest.WordSpec
import test.scala.graph.TestUtil.getFile

import scala.io.Source

/**
 * Created by mayur.pandya on 1/13/15.
 */
class DikjstraShortestPathFinderSpec extends WordSpec {

  "An adjacency list structured file representing a digraph" should {
    "should have the following shortest path" in {
      runTest("graph1", Node("1"), Node("10"))
    }
  }

  def runTest(testName:String, startNode:Node, endNode:Node):Unit = {
    val expectedFile = getFile(testName + "-shortestPath.txt")
    val expectedLines:Iterator[String] = Source.fromFile(expectedFile).getLines()

    val diGraph:DiGraph = new DiGraphFileParser() parseFile getFile(testName + ".txt")
    val pathFinder:DikjstraShortestPathFinder = new DikjstraShortestPathFinder(diGraph)
    val path:Seq[Edge] = pathFinder.findShortestPath(startNode, endNode)

    assertResult(expectedLines.next()) {
      pathToString(path)
    }
    assertResult(expectedLines.next().toInt) {
      pathCost(path)
    }
  }

  def pathToString(path:Seq[Edge]):String = {
    path match {
      case Seq(edge) => edge.startNode.id + "->" + edge.endNode.id
      case edge+:rest => edge.startNode.id + "->" + pathToString(rest)
    }
  }

  def pathCost(path:Seq[Edge]):Int = {
    path match {
      case Seq(edge) => edge.cost
      case edge+:rest => edge.cost + pathCost(rest)
    }
  }
}
