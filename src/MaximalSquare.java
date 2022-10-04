import java.util.*;

public class MaximalSquare {

    static int ROWS;
    static int COLS;
    static Map<String, Integer> map;
    public static int maximalSquare(char[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        map = new HashMap<>();

        dp(0, 0, matrix);

        List<Integer> list = new ArrayList<>(map.values());
        int max = 0;
        for (int l: list) {
            max = Math.max(l, max);
        }
        return max * max;
    }

    public static int dp(int r, int c, char[][] matrix) {
        if (r >= ROWS || c >= COLS) return 0;

        String key = r+","+c;
        if (!map.containsKey(key)) {
            int down = dp(r+1, c, matrix);
            int right = dp(r, c+1, matrix);
            int diag = dp(r+1, c+1, matrix);

            map.put(key, 0);
            if (matrix[r][c] == '1') {
                map.put(key, 1 + Math.min(down, Math.min(right, diag)));
            }
        }
        return map.get(key);
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(maximalSquare(matrix));
    }
}
