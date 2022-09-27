package tabulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestSum {
    public static void main(String[] args) {
        System.out.println(bestSum(7, List.of(5,3,4,7)));
        System.out.println(bestSum(8, List.of(2,3,5)));
        System.out.println(bestSum(8, List.of(1,4,5)));
        System.out.println(bestSum(100, List.of(1,2,5,25)));
        ///////
        System.out.println("**********");
        System.out.println(bestSum(100, List.of(1,2,5,25))); //[25, 25, 25, 25]
        System.out.println(bestSum(7, List.of(2,3,4,7)));//[7]
        System.out.println(bestSum(7, List.of(1,2,3,4,5)));//[5, 2]
        System.out.println(bestSum(8, List.of(2,3,5)));//[5, 3]
        System.out.println(bestSum(7, List.of(2,3,4,5)));//[4, 2]
        System.out.println(bestSum(7, List.of(2,3)));
        System.out.println(bestSum(300, List.of(7,14)));
    }

    public static List<Integer> bestSum(int target, List<Integer> numbers) {
        List<List<Integer>> table = new ArrayList<>(target + 1);
        for(int i =0;  i <= target; i++) table.add(null);
        table.add(0, new ArrayList<>());

        for (int i = 0; i <= target; i++) {
            for (int num : numbers) {
                if (table.get(i) != null) {
                    if (i + num <= target) {
                        ArrayList<Integer> combinations = new ArrayList<>(table.get(i));
                        combinations.add(num);

                        if (table.get(i + num) == null || table.get(i + num).size() > combinations.size()) {
                            table.set(i + num, combinations);
                        }
                    }
                }
            }
        }
        return table.get(target);
    }
}
