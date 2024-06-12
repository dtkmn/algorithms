package leetcode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/course-schedule-ii/">...</a>
 *
 */
public class CourseScheduleII {

    // N == Number of courses (Vertices)
    // D == Number of dependencies (Edges)
    int[] findOrder(int numCourses, int[][] prerequisites) {

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

    int[] findOrder_2024(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> preToCourses = new HashMap<>();
        for (int[] p: prerequisites) {
            int pre = p[1];
            int post = p[0];
            indegrees[post]++;
            preToCourses.computeIfAbsent(pre, v -> new ArrayList<>()).add(post);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int[] ans = new int[numCourses];
        int pos = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans[pos++] = curr;
            if (preToCourses.containsKey(curr)) {
                for (int to : preToCourses.get(curr)) {
                    if (--indegrees[to] == 0) queue.offer(to);
                }
            }
        }
        if (pos == numCourses) return ans;
        return new int[0];
    }

}
