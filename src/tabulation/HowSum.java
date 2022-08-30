package tabulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HowSum {
    public static void main(String[] args) {
        System.out.println(howSum(7, List.of(2,3)));
        System.out.println(howSum(7, List.of(5,3,4,7)));
        System.out.println(howSum(7, List.of(2,4)));
        System.out.println(howSum(300, List.of(7,14)));
    }

    public static List<Integer> howSum(int target, List<Integer> numbers) {
        List<List<Integer>> table = new ArrayList<>(target + 1);
        for(int i =0;  i <= target; i++) table.add(null);
        table.add(0, new ArrayList<>());

        for (int i = 0; i <= target; i++) {
            if (table.get(i) != null) {
                for (int num: numbers) {
                    if (i + num <= target) {
                        ArrayList<Integer> integers = new ArrayList<>(table.get(i));
                        integers.add(num);
                        table.set(i + num, integers);
                    }
                }
            }
        }
        return table.get(target);
    }
}
