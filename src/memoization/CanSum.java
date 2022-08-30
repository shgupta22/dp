package memoization;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum_rec(7, List.of(2,3)));
        System.out.println(canSum_rec(300, List.of(7,14)));
        System.out.println(canSum_rec(7, List.of(9,3, 5,8)));
        Map<Integer, Boolean> map = new HashMap<>();
        System.out.println(canSum_mem(300, List.of(7,14), map));

    }

    /**
     * m = target sum
     * n= array length
     *
     * time: O(n^m)
     * space: O(m)
     *
     */
    public static boolean canSum_rec(int targetSum, List<Integer> numbers) {
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum_rec(remainder, numbers)) return true;
        }
        return false;
    }

    /**
     * m = target sum
     * n= array length
     *
     * time: O(n * m)
     * space: O(m)
     *
     */
    public static boolean canSum_mem(int targetSum, List<Integer> numbers, Map<Integer, Boolean> map) {
        if (map.containsKey(targetSum)) return map.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int num : numbers) {
            int remainder = targetSum - num;
            if (canSum_mem(remainder, numbers, map)) {
                map.put(targetSum, true);
                return true;
            }
        }
        map.put(targetSum, false);
        return false;
    }
}
