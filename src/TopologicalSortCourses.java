import java.util.*;

public class TopologicalSortCourses {

    public static boolean canComplete(int numCourses, List<List<Integer>> preRequisites) {
        Map<Integer, List<Integer>> graph = buildAdjacencyList(preRequisites);
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited)) return false;
        }
        return true;
    }

    public static boolean dfs(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if (visited.contains(node)) return false;

        if (graph.get(node).isEmpty()) return true;

        visited.add(node);
        for (int neighbor: graph.get(node)) {
            if (!dfs(graph, neighbor, visited)) return false;
        }
        visited.remove(node);
        graph.put(node, new ArrayList<>());
        return true;
    }


    public static Map<Integer, List<Integer>> buildAdjacencyList(List<List<Integer>> preRequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (List<Integer> pair: preRequisites) {
            Integer a = pair.get(0);
            Integer b = pair.get(1);
            if (!map.containsKey(a)) map.put(a, new ArrayList<>());
            if (!map.containsKey(b)) map.put(b, new ArrayList<>());
            map.get(a).add(b);
//            map.get(b).add(a);
        }
        return map;
    }

    public static void main(String[] args) {

        System.out.println(canComplete(5, List.of(List.of(0,1),
                List.of(0,2),
                List.of(1,3),
                List.of(1,4),
                List.of(3,4))));


        System.out.println(canComplete(2, List.of(List.of(0,1),
                List.of(1,0))));

        System.out.println(canComplete(4, List.of(List.of(0,1),
                List.of(2,3))));

        System.out.println(canComplete(4, List.of(List.of(0,1),
                List.of(1,2),
                List.of(2,0))));
    }
}
