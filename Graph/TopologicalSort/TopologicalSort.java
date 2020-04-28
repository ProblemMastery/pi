package Graph.TopologicalSort;

import java.util.*;

public class TopologicalSort {

    /**
     * Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
     * Output: Following are the two valid topological sorts for the given graph:
     * 1) 3, 2, 0, 1
     * 2) 3, 2, 1, 0
     */
    /**
     * Solution :
     * 1. create adjacency list -> map of vertices to list of its neighbours
     * 2. create another map of vertices with indgree.
     * 3. add the vertices with zero indegrees to a queue
     * 4. Poll the queue and for each vertex go to its neighbours.
     */
    public static List<Integer> sort(int vertices, int[][] edges) {

        List<Integer> sortedList = new ArrayList<>();

        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Map<Integer, Integer> verticesToInDegree = new HashMap<>();
        Queue<Integer> sourceQueue = new LinkedList<>();

        // a. Initialize the graph
        for (int i = 0; i < vertices; i++) {
            verticesToInDegree.put(i, 0);
            adjMap.put(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            List<Integer> nbrs = adjMap.get(parent);
            nbrs.add(child);
            adjMap.put(parent, nbrs);
            verticesToInDegree.put(child, verticesToInDegree.getOrDefault(child, 0) + 1);
        }

        for (int source : verticesToInDegree.keySet()) {
            if (verticesToInDegree.get(source) == 0)
                sourceQueue.add(source);
        }

        while (!sourceQueue.isEmpty()) {

            int vertex = sourceQueue.poll();
            sortedList.add(vertex);
            List<Integer> nbrs = adjMap.get(vertex);

            for (int child : nbrs) {
                verticesToInDegree.put(child, verticesToInDegree.get(child) - 1);
                if (verticesToInDegree.get(child) <= 0) {
                    sourceQueue.add(child);
                }
            }


        }
        return sortedList;
    }

        public static void main(String[] args) {
            List<Integer> result = TopologicalSort.sort(4,
                    new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}, new int[]{1, 0}});
            System.out.println(result);
        }

}
