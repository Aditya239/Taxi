import java.util.*;
class Dijkstra
{
    
    /*{
    MySet<vertex> nodes;
    MySet<edge> connex;
    MySet<vertex> visited;
    MySet<vertex> unvisited;
    public Dijkstra(graph g)
    {
        nodes=g.vertices;
        connex=g.edges;
    }
    public int findshortest(vertex s,vertex d)
    {
        vertex source=s;
        vertex destination =d;
        HashMap<vertex, Integer> dist = new HashMap<vertex, Integer>();
        dist.put(source,0);
    }
}*/

  public MySet<vertex> nodes;
  public MySet<edge> edges;
  public MySet<vertex> settledNodes;
  public MySet<vertex> unSettledNodes;
  public HashMap<vertex, vertex> predecessors;
  public HashMap<vertex, Integer> distance;
  public Dijkstra(graph graphs) 
  {
    this.nodes = graphs.vertices;
    this.edges = graphs.edges;
  }
  
  public void execute(vertex source) {
    settledNodes = new MySet<vertex>();
    unSettledNodes = new MySet<vertex>();
    distance = new HashMap<vertex, Integer>();
    predecessors = new HashMap<vertex, vertex>();
    distance.put(source, 0);
    unSettledNodes.addElement(source);
    while (unSettledNodes.total > 0) {
      vertex node = getMinimum(unSettledNodes);
      settledNodes.addElement(node);
      unSettledNodes.Delete(node);
      findMinimalDistances(node);
    }
  }

  public void findMinimalDistances(vertex node) {
    MySet<vertex> adjacentNodes = getNeighbors(node);
    Node<vertex> fishtail=adjacentNodes.myset_in_list.tail;
     while(fishtail!=null){
         vertex target=fishtail.getter_data();
      if (getShortestDistance(target) > getShortestDistance(node)
          + getDistance(node, target)) {
        distance.put(target, getShortestDistance(node)
            + getDistance(node, target));
        predecessors.put(target, node);
        unSettledNodes.addElement(target);
      }
      fishtail=fishtail.getter_link();
    }

  }

  public int getDistance(vertex node, vertex target) {
    Node<edge> ladder=edges.myset_in_list.tail;
      while(ladder!=null) 
    {
      if (  (ladder.getter_data().v1.id.equals(node.id) && ladder.getter_data().v2.id.equals(target.id))  ||
            (ladder.getter_data().v2.id.equals(node.id) && ladder.getter_data().v1.id.equals(target.id))    ) 
      {
        return ladder.getter_data().weight;
      }
      ladder=ladder.getter_link();
    }
    throw new RuntimeException("Should not happen");
  }

  public MySet<vertex> getNeighbors(vertex node) {
    MySet<vertex> neighbors = new MySet<vertex>();
    Node<vertex> leto=node.return_neighbours().myset_in_list.tail;
    while(leto!=null) 
    {
      if (!isSettled(leto.getter_data())) {
        neighbors.addElement(leto.getter_data());
      }
      leto=leto.getter_link();
    }
    return neighbors;
  }
  
  public vertex getMinimum(MySet<vertex> v) {
    vertex minimum = null;
    Node<vertex> decoc=v.myset_in_list.tail;
    while(decoc!=null){
      vertex verte=decoc.getter_data();
      if (minimum == null) {
        minimum = verte;
      } else {
        if (getShortestDistance(verte) < getShortestDistance(minimum)) 
          minimum = verte;
      }
      decoc=decoc.getter_link();
    }
    return minimum;
  }

  public boolean isSettled(vertex ve) {
    return settledNodes.IsMember(ve);
  }

  public int getShortestDistance(vertex destination) {
    Integer d = distance.get(destination);
    if (d == null) {
      return Integer.MAX_VALUE;
    } else {
      return d;
    }
  }

  /*
   * This method returns the path from the source to the selected target and
   * NULL if no path exists*/
   
  public MyLinkedList<vertex> getPath(vertex target) {
    MyLinkedList<vertex> path = new MyLinkedList<vertex>();
    vertex step = target;
    // check if a path exists
    if (predecessors.get(step) == null) {
      return null;
    }
    path.Insert_node_in_list(step);
    while (predecessors.get(step) != null) {
      step = predecessors.get(step);
      path.Insert_node_in_list(step);
    }
    // Put it into the correct order
    return path;
  }
  
} 