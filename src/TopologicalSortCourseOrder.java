import java.util.*;

public class TopologicalSortCourseOrder {

    public static List<Integer> courseOrder(int n, List<List<Integer>> preRequisites) {
        Map<Integer, List<Integer>> graph = buildAdjacencyList(preRequisites);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        List<Integer> result = new ArrayList<>();

        for (int i =0 ; i < n; i++) {
            if (!dfs(graph, visited, cycle, i, result)) return new ArrayList<>();
        }

        return result;
    }

    public static boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, Set<Integer> cycle, int node, List<Integer> result) {
        if (cycle.contains(node)) return false;
        if (visited.contains(node)) return true;

        cycle.add(node);
        for (int neighbor: graph.getOrDefault(node, List.of())) {
            if (!dfs(graph, visited, cycle, neighbor, result)) return false;
        }
        cycle.remove(node);
        visited.add(node);
        result.add(node);
        return true;
    }

    public static Map<Integer, List<Integer>> buildAdjacencyList(List<List<Integer>> preRequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> pair: preRequisites) {
            int a = pair.get(0);
            int b = pair.get(1);
            if (!graph.containsKey(a)) graph.put(a, new ArrayList<>());
            if (!graph.containsKey(b)) graph.put(b, new ArrayList<>());
            graph.get(a).add(b);
        }
        return graph;
    }

    public static void main(String[] args) {
        System.out.println(courseOrder(6, List.of(List.of(0,1),
                List.of(0,2),
                List.of(1,3),
                List.of(3,2),
                List.of(5,0),
                List.of(4,0))));

        System.out.println(courseOrder(2, List.of()));
    }
}
