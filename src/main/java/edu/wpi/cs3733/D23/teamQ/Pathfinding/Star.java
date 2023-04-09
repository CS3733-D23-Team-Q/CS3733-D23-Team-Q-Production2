package edu.wpi.cs3733.D23.teamQ.Pathfinding;

import edu.wpi.cs3733.D23.teamQ.db.obj.Edge;
import edu.wpi.cs3733.D23.teamQ.db.obj.Node;
import java.util.ArrayList;

public class Star extends Edge {

  public Star() {
    super();
  }

  /*public static double calculateHeuristic(Node n, Node target) {
    int dx = Math.abs(n.getXCoord() - target.getYCoord());
    int dy = Math.abs(n.getYCoord() - target.getYCoord());
    int D = Math.max(dx, dy);
    return D;
  }*/

  public static ArrayList<Node> aStar(Node start, Node target) {
    ArrayList<Node> closedList = new ArrayList<Node>();
    ArrayList<Node> openList = new ArrayList<Node>();
    ArrayList<Node> deadList = new ArrayList<Node>();
    String targetFloor = target.getFloor();
    openList.add(start);
    while (openList.isEmpty() == false) {
      if (openList.get(0).equals(target)) {
        closedList.add(openList.get(0)); // line to add current node to closed list
        return closedList;
      }
      Node currentNode = openList.get(0);
      if (currentNode.getEdges().size() == 0) { // check for edgeless nodes
        System.out.println("The node " + currentNode.getNodeID() + " has no edges.");
      }
      int bestWeight =
          1000000000; // setting some temp variables used to calculate and find the best weight
      // (shortest distance)
      int relativeWeight = 100000;
      Edge bestEdge = null;
      //  List<Edge> edgeClone = currentNode.getEdges();
      // ArrayList<Edge> trueClone = new ArrayList<Edge>();
      Node deadNode = null;
      // loop to create duplicate arraylist of edges contained in currentNode
      // trueClone.addAll(edgeClone);
      for (Edge thisEdge : currentNode.getEdges()) {
        /*  if (!thisEdge.getEndNode().getFloor().equalsIgnoreCase(targetFloor)) {
          continue;
        }*/
        int relativeXDist = Math.abs(thisEdge.getStartNode().getXCoord() - target.getXCoord());
        int relativeYDist = Math.abs(thisEdge.getStartNode().getYCoord() - target.getYCoord());
        relativeWeight =
            (int) Math.sqrt(relativeXDist * relativeXDist + relativeYDist * relativeYDist);
        if (relativeWeight < bestWeight
            && !deadList.contains(thisEdge.getEndNode())
            && !closedList.contains(thisEdge.getEndNode())) {
          bestWeight = relativeWeight;
          bestEdge = thisEdge;
          System.out.println("I picked node " + bestEdge.getEndNode());
          System.out.println("The current node has edges" + currentNode.getEdges());
        }
      }
      if (currentNode.getEdges().size() == 0) {
        deadNode = currentNode;
        deadList.add(deadNode);
        openList.add(closedList.get(closedList.size() - 1));
      }
      /* if (bestEdge == null) {
        bestEdge = currentNode.getEdges().get(0);
      }*/
      // I need a fallback process that gets any untraversed node if no good node has been found, to
      // avoid an infinite loop of two nodes choosing each other
      for (Edge chosen : currentNode.getEdges()) {
        if (!closedList.contains(chosen)) {
          bestEdge = chosen;
        }
      }
      closedList.add(
          bestEdge.getStartNode()); // at this point, the best weight has been found, now we need to
      // match the edge
      openList.remove(currentNode);
      openList.add(bestEdge.getEndNode());
    }

    return closedList;
  }
}
