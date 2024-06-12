package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/reconstruct-itinerary/description/">...</a>
 *
 */
public class ReconstructItinerary {

    Map<String, LinkedList<String>> airportMap;
    Map<String, boolean[]> visited;
    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        int numOfTickets = tickets.size();
        airportMap = new HashMap<>();
        visited = new HashMap<>();
        for (List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            airportMap.computeIfAbsent(from, k -> new LinkedList<>()).add(to);
        }

//        for (Map.Entry<String, LinkedList<String>> entry: airportMap.entrySet()) {
//            Collections.sort(entry.getValue());
//            System.out.println(key + ": " + values);
//            visited.putIfAbsent(key, new boolean[values.size()]);
//        }
        for (String key: airportMap.keySet()) {
            LinkedList<String> values = airportMap.get(key);
            Collections.sort(values);
            System.out.println(key + ": " + values);
            visited.putIfAbsent(key, new boolean[values.size()]);
        }

        LinkedList<String> path = new LinkedList<>();
        String current = "JFK";
        path.add(current);
        backtrack(path, current, numOfTickets + 1);
        return ans;
    }

    boolean backtrack(LinkedList<String> path, String current, int expectedSize) {
        if (path.size() == expectedSize) {
            ans = new ArrayList<>(path);
            return true;
        }
        if (airportMap.containsKey(current) && !airportMap.get(current).isEmpty()) {
            boolean[] flightTaken = visited.get(current);
            int pos = 0;
            for (String neighbour: airportMap.get(current)) {
                if (!flightTaken[pos]) {
                    path.add(neighbour);
                    flightTaken[pos] = true;
                    boolean result = backtrack(path, neighbour, expectedSize);
                    if (result) return true;
                    path.removeLast();
                    flightTaken[pos] = false;
                }
                pos++;
            }
        }
        return false;
    }

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary_hierholzer(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();

        // Create the graph
        for (List<String> ticket : tickets) {
            flights.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        // Perform the visit from "JFK"
        visit("JFK");
        return path;
    }

    private void visit(String airport) {
        while (flights.containsKey(airport) && !flights.get(airport).isEmpty()) {
            String next = flights.get(airport).poll();
            visit(next);
        }
        // Add to the path as we backtrack
        path.addFirst(airport);
    }



    public static void main(String[] args) {
        /**
         *  Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
         *  Output: ["JFK","MUC","LHR","SFO","SJC"]
         */
        List<String> ans = new ReconstructItinerary().findItinerary(
                List.of(
                        List.of("JFK", "SFO"),
                        List.of("JFK", "ATL"),
                        List.of("ATL", "JFK"),
                        List.of("SFO", "ATL"),
                        List.of("ATL", "SFO")
                )
        );
        System.out.println(ans);
    }
}
