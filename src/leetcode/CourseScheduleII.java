package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 *
 */
public class CourseScheduleII {

    // N == Number of courses (Vertices)
    // D == Number of dependencies (Edges)
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) return new int[] {};
        int totalDeps = prerequisites.length;

        // Space Complexity: O(N)
        int[] indegrees = new int[numCourses];
        // Space Complexity: O(N)
        Map<Integer, List<Integer>> courses = new HashMap<>();

        // relation[1] -> relation[0]
        // Time Complexity: O(D)
        for (int[] relation: prerequisites) {
            int pre = relation[1];
            List<Integer> nextCourses =
                courses.containsKey(pre) ? courses.get(pre) : new ArrayList<>();
            nextCourses.add(relation[0]);
            courses.put(pre, nextCourses);
            indegrees[relation[0]]++;
        }

        // Start putting only 'sources' in list
        // i.e. no incoming flow
        Queue<Integer> nodeList = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) nodeList.add(i);
        }

        // Count how many edges (dependencies) get removed
        int removeEdges = 0;
        List<Integer> orderCourse = new ArrayList<>();
        // Loop through each source in list
        while (!nodeList.isEmpty()) {
            int c = nodeList.poll();
            orderCourse.add(c);
            // Get the courses depend on this source
            List<Integer> nextCourses = courses.getOrDefault(c, new ArrayList<>());
            for (int next: nextCourses) {
                // Remove the edges (dependencies)
                indegrees[next]--;
                removeEdges++;
                if (indegrees[next] == 0) {
                    nodeList.add(next);
                }
            }
        }

        // Make sure the count of remove edges equals to the dependencies
        // i.e. no cycle in this graph
        if (totalDeps == removeEdges) {
            int[] res = new int[orderCourse.size()];
            int count = 0;
            for (int course: orderCourse) {
                res[count++] = course;
            }
            return res;
        }

        // Otherwise, return empty list
        return new int[] {};

    }

    public static void main(String[] args) {
//        System.out.println(canFinish(6, new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 3 } }));
//        System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
        System.out.println(Arrays.toString(findOrder(2, new int[][] { { 1, 0 } })));
    }

}
