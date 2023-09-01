package leetcode;

import java.util.*;

class CourseSchedule_207 {

    /* test 1 */
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    // Map<Integer, List<Integer>> graph = new HashMap<>();

    // for (int[] c : prerequisites) {
    // graph.computeIfAbsent(c[1], k -> new ArrayList<>()).add(c[0]);
    // }

    // boolean[] visited = new boolean[numCourses];
    // boolean[] visiting = new boolean[numCourses];

    // for (int i = 0; i < numCourses; i++) {
    // if (!visited[i] && hasCycle(i, graph, visited, visiting)) {
    // return false;
    // }
    // }

    // return true;
    // }

    // private boolean hasCycle(int course, Map<Integer, List<Integer>> graph,
    // boolean[] visited, boolean[] visiting) {
    // if (visiting[course])
    // return true;
    // if (visited[course])
    // return false;

    // visiting[course] = true;

    // if (graph.containsKey(course)) {
    // for (int dependency : graph.get(course)) {
    // if (hasCycle(dependency, graph, visited, visiting)) {
    // return true; // cycle chain
    // }
    // }
    // }

    // visiting[course] = false;
    // visited[course] = true;

    // return false;
    // }
}