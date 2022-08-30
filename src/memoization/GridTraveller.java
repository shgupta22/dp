package memoization;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
    public static void main(String[] args) {
        System.out.println(gridTraveller_rec(1,1));
        System.out.println(gridTraveller_rec(2,5));

        Map<String, Long> mem = new HashMap<>();
        System.out.println(gridTraveller_mem(2,5, mem));
        mem = new HashMap<>();
        System.out.println(gridTraveller_mem(180,18, mem));
    }

    public static long gridTraveller_rec(int m, int n) {
        if (m ==1 || n == 1)  return 1;
        if (m == 0 || n == 0) return 0;
        return gridTraveller_rec(m-1, n) + gridTraveller_rec(m, n-1);
    }

    public static long gridTraveller_mem(int m, int n, Map<String, Long> mem) {
        String key = ""+m + ',' + n;
        if (mem.containsKey(key)) return mem.get(key);
        if (m ==1 || n == 1)  return 1;
        if (m == 0 || n == 0) return 0;

        mem.put(key, gridTraveller_mem(m-1, n, mem) + gridTraveller_mem(m, n-1, mem));
        return mem.get(key);
    }
}
