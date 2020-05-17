package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 */
public class CourseSchedule {

    // (E) Edges    == number of dependencies
    // (V) Vertices == number of courses
    // Time Complexity: O(E + V)
    // Space Complexity: O(E + V)
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courses = new HashMap<>();
        int[] indegrees = new int[numCourses];
        int totalDep = prerequisites.length;

        // relation[0] depends on relation[1]
        // Or relation[1] -> relation[0]
        // Using HashMap to store all dependencies
        // Time Complexity: O(E)
        for (int[] relation: prerequisites) {

            List<Integer> outwards = courses.containsKey(relation[1]) ?
                courses.get(relation[1]) : new ArrayList<>();

            outwards.add(relation[0]);
            courses.put(relation[1], outwards);
            // Using array to save indegrees on each node
            indegrees[relation[0]]++;

        }

        // Add node with zero indegree value
        // Time Complexity: O(V)
        Queue<Integer> nodeList = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) nodeList.add(i);
        }

        // Time Complexity: O(V)
        int removeEdges = 0;
        while (!nodeList.isEmpty()) {
            Integer poll = nodeList.poll();
            System.out.println("Poll: " + poll);
            List<Integer> deps = courses.getOrDefault(poll, new ArrayList<>());
            for (Integer nextCourse: deps) {
                indegrees[nextCourse]--;
                removeEdges++;
                if (indegrees[nextCourse] == 0) {
                    nodeList.add(nextCourse);
                }
            }
        }

        return (removeEdges == totalDep);

    }

    public static void main(String[] args) {
        System.out.println(canFinish(6, new int[][] { { 1, 0 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 3 } }));

//        System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
    }

}
