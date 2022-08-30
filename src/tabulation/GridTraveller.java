package tabulation;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
    public static void main(String[] args) {
        System.out.println(gridTraveller(1,1));
        System.out.println(gridTraveller(2,5));
        System.out.println(gridTraveller(3,3));

        Map<String, Long> mem = new HashMap<>();
        System.out.println(gridTraveller(2,5));
        mem = new HashMap<>();
        System.out.println(gridTraveller(180,18));
    }

    public static Long gridTraveller(int m, int n) {
        long[][] grid = new long[m+1][n+1];

        grid[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i+1 <= m) grid[i+1][j] += grid[i][j];
                if (j+1 <= n) grid[i][j+1] += grid[i][j];
            }
        }
        return grid[m][n];
    }
}
