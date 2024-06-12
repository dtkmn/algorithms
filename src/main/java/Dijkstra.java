
import java.util.*;

// Implement Dijkstra algorithms
public class Dijkstra {

  private Map<String, Map<String, Integer>> graphs = new HashMap<>();
  private Map<String, Integer> costs = new HashMap<>();
  private Map<String, String> parents = new HashMap<>();
  private List<String> processed = new ArrayList<>();

  public Dijkstra() {
    initSecondCase();
  }

  public void initFirstCase() {
    costs.put("a", 6);
    costs.put("b", 2);
    costs.put("fin", Integer.MAX_VALUE);

    parents.put("a", "start");
    parents.put("b", "start");
    parents.put("fin", null);

    Map<String, Integer> costForNeighboursForStart = new HashMap<>();
    costForNeighboursForStart.put("a", 6);
    costForNeighboursForStart.put("b", 2);
    Map<String, Integer> costForNeighboursForA = new HashMap<>();
    costForNeighboursForA.put("fin", 1);
    Map<String, Integer> costForNeighboursForB = new HashMap<>();
    costForNeighboursForB.put("a", 3);
    costForNeighboursForB.put("fin", 5);

    graphs.put("start", costForNeighboursForStart);
    graphs.put("a", costForNeighboursForA);
    graphs.put("b", costForNeighboursForB);
    graphs.put("fin", null);
  }

  public void initSecondCase() {
    costs.put("a", 5);
    costs.put("b", 2);
    costs.put("c", Integer.MAX_VALUE);
    costs.put("d", Integer.MAX_VALUE);
    costs.put("fin", Integer.MAX_VALUE);

    parents.put("a", "start");
    parents.put("b", "start");
    parents.put("c", null);
    parents.put("d", null);
    parents.put("fin", null);

    Map<String, Integer> costForNeighboursForStart = new HashMap<>();
    costForNeighboursForStart.put("a", 5);
    costForNeighboursForStart.put("b", 2);
    Map<String, Integer> costForNeighboursForA = new HashMap<>();
    costForNeighboursForA.put("c", 4);
    costForNeighboursForA.put("d", 2);
    Map<String, Integer> costForNeighboursForB = new HashMap<>();
    costForNeighboursForB.put("a", 8);
    costForNeighboursForB.put("d", 7);
    Map<String, Integer> costForNeighboursForC = new HashMap<>();
    costForNeighboursForC.put("d", 6);
    costForNeighboursForC.put("fin", 3);
    Map<String, Integer> costForNeighboursForD = new HashMap<>();
    costForNeighboursForD.put("fin", 1);

    graphs.put("start", costForNeighboursForStart);
    graphs.put("a", costForNeighboursForA);
    graphs.put("b", costForNeighboursForB);
    graphs.put("c", costForNeighboursForC);
    graphs.put("d", costForNeighboursForD);
    graphs.put("fin", null);
  }

  public void run() {
    // Find the node with lowest cost
    String lowestNode = findLowestCostNode();
    while (lowestNode != null) {
      int cost = costs.get(lowestNode);
      Map<String, Integer> neighbourCosts = graphs.get(lowestNode);
      if(neighbourCosts != null) {
        // Go through the neighbours of this lowest node
        for (String n : neighbourCosts.keySet()) {
          // New cost from current lowest node to this neighbour
          int newCost = neighbourCosts.get(n) + cost;
          if (newCost < costs.get(n)) {
            costs.put(n, newCost);
            parents.put(n, lowestNode);
          }
        }
      }
      processed.add(lowestNode);
      lowestNode = findLowestCostNode();
    }
  }

  public static void main(String[] args) {
    Dijkstra d = new Dijkstra();
    d.run();
    d.printRoute();
  }

  public void printRoute() {
    String endNode = "fin";
    while (endNode != null) {
      System.out.println(" > " + endNode);
      endNode = parents.get(endNode);
    }
  }

  public String findLowestCostNode() {
    int min = Integer.MAX_VALUE;
    String node = null;
    for(String n: costs.keySet()) {
      int cost = costs.get(n);
      if(cost < min && !processed.contains(n)) {
        min = cost;
        node = n;
      }
    }
    return node;
  }

}
