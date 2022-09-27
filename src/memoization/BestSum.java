package memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
    /**
     *
     * For Some Corner cases Memoization doesn't work
     */
    public static void main(String[] args) {
        System.out.println(bestSum_rec(7, List.of(5,3,4,7)));
        System.out.println(bestSum_rec(8, List.of(2,3,5)));
        System.out.println(bestSum_rec(8, List.of(1,4,5)));
//        System.out.println(bestSum_rec(100, List.of(1,2,5,25)));
        System.out.println("********************");
        System.out.println(bestSum_mem(7, List.of(5,3,4,7), new HashMap<>()));
        System.out.println(bestSum_mem(8, List.of(2,3,5), new HashMap<>()));
        System.out.println(bestSum_mem(8, List.of(1,4,5), new HashMap<>()));
        System.out.println(bestSum_mem(100, List.of(1,2,5,25), new HashMap<>()));
        System.out.println(bestSum_mem(8, List.of(2,3,5), new HashMap<>()));
        System.out.println(bestSum_mem(300, List.of(7,14), new HashMap<>()));
    }

    /**
     * m = target sum
     * n = number length
     *
     * time: O(n^m * m)
     * space: O(m * m)
     */
    public static List<Integer> bestSum_rec(int targetSum, List<Integer> numbers) {
        if (targetSum ==0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderCombination = bestSum_rec(remainder, numbers);

            if (remainderCombination != null) {
                ArrayList<Integer> objects = new ArrayList<>(remainderCombination);
                objects.add(num);
                if (shortestCombination == null || objects.size() < shortestCombination.size()) {
                    shortestCombination = new ArrayList<>(objects);
                }
            }
        }
        return shortestCombination;
    }

    public static List<Integer> bestSum_mem(int targetSum, List<Integer> numbers, Map<Integer, List<Integer>> map) {
        if (map.containsKey(targetSum)) return map.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Integer> shortestCombination = null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderCombination = bestSum_mem(remainder, numbers, map);

            if (remainderCombination != null) {
                ArrayList<Integer> objects = new ArrayList<>(remainderCombination);
                objects.add(num);
                if (shortestCombination == null || objects.size() < shortestCombination.size()) {
                    shortestCombination = new ArrayList<>(objects);
                }
            }
        }


        if (shortestCombination != null)
            map.put(targetSum, new ArrayList<>(shortestCombination));
        else
            map.put(targetSum, new ArrayList<>());
        return shortestCombination;
    }
}
