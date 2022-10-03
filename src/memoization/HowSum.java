package memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static void main(String[] args) {
        System.out.println(howSum(7, List.of(2,3)));
        System.out.println(howSum(7, List.of(5,3,4,7)));
        System.out.println(howSum(7, List.of(2,4)));
//        System.out.println(howSum(300, List.of(7,14)));
        System.out.println("*****");
        System.out.println(howSum_mem(7, List.of(2, 3), new HashMap<>()));
        System.out.println(howSum_mem(7, List.of(5,3,4,7), new HashMap<>()));
        System.out.println(howSum_mem(7, List.of(2,4), new HashMap<>()));
        System.out.println(howSum_mem(300, List.of(7,14), new HashMap<>()));
    }

    /**
     * m = target sum
     * n= array length
     *
     * time: O(n^m * m)
     * space: O(m)
     */
    public static List<Integer> howSum(int targetSum, List<Integer> numbers) {
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSum(remainder, numbers);
            if (remainderResult != null) {
                remainderResult.add(num);
                return remainderResult;
            }
        }
        return null;
    }

    /**
     * time: O(n * m * m) = O(n*m^2)
     * space: O(m * m) = O(m^2)
     *
     */
    public static List<Integer> howSum_mem(int targetSum, List<Integer> numbers, Map<Integer, List<Integer>> map) {
        if (map.containsKey(targetSum)) return map.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int num : numbers) {
            int remainder = targetSum - num;
            List<Integer> remainderResult = howSum_mem(remainder, numbers, map);
            if (remainderResult != null) {
                remainderResult.add(num);
                map.put(targetSum, new ArrayList<>(remainderResult));
                return remainderResult;
            }
        }
        map.put(targetSum, null);
        return null;
    }
}
