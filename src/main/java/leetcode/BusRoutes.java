package leetcode;


import java.util.*;

/**
 * <a href="https://leetcode.com/problems/bus-routes/">...</a>
 *
 */
public class BusRoutes {

    public static int numBusesToDestination(int[][] routes, int source, int target) {

        if (source == target) return 0;

        Map<Integer, List<Integer>> routesMap = new HashMap<>();
        // routes[0] = [1,2,7], routes[1] = [3,6,7]
        for (int i = 0; i < routes.length; i++) {
            // Loop through each stop from each route
            for (int stop: routes[i]) {
                // Apply the stop as key, routes as values
                List<Integer> list = routesMap.getOrDefault(stop, new ArrayList<>());
                list.add(i);
                routesMap.put(stop, list);
            }
        }

        List<Integer> sourceRoutes = routesMap.get(source);
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[routes.length];
        for (int s: sourceRoutes) {
            q.add(s);
            visited[s] = 1;
        }

        int busCount = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            // We need to go through the own queue here cuz they are all belong to the same bus route
            for (int i = 0; i < size; i++) {
                Integer route = q.remove();
                for (int stop : routes[route]) {
                    if (target == stop) return busCount;
                    List<Integer> rList = routesMap.get(stop);
                    for (int r : rList) {
                        if (visited[r] == 0) {
                            visited[r] = 1;
                            q.add(r);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(
            numBusesToDestination(
                new int[][]{
                        {1,2,3},
                        {2,4,6}
                },
                1,
                6
            )
        );
    }

}
