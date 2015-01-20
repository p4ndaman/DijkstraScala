# DijkstraScala

An implementation of Dijkstra's algorithm using (mostly) functional Scala.

I attempted to incorporate some core Scala/functional concepts such as pattern matching, value extractors, case classes, etc.

Some of the imperative parts come from struggling with mutable.PriorityQueue API, which favors imperative handling.

I was inspired by http://www.redblobgames.com/pathfinding/a-star/introduction.html. Great write up of path-finding in x-y coordinate space and neat examples with which you can play!
Note that I did not implement A*, which requires an admissable heuristic function evaluated for each node.

Feel free to comment! I just hacked this out to give Scala a whirl. It could probably use improvement and more coverage :)
