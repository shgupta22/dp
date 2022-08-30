package tabulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanSum {
    public static void main(String[] args) {
        System.out.println(canSum(7, List.of(2,3)));
        System.out.println(canSum(300, List.of(7,14)));
        System.out.println(canSum(2, List.of(9,3, 5,8)));
        System.out.println(canSum(300, List.of(7,14)));
    }

    public static boolean canSum(int target, List<Integer> numbers) {
        boolean[] table = new boolean[target + 1];
        table[0] = true;
        for (int i = 0; i <= target; i++) {
            if (table[i]) {
                for (int num : numbers) {
                    if (i + num <= target) table[i + num] = true;
                }
            }
        }
        return table[target];
    }
}
