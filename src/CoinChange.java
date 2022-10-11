import java.util.HashMap;
import java.util.Map;

public class CoinChange {


    public static int countCoinChange(int[] coins, int target) {
        Map<String, Integer> map = new HashMap<>();
        return dfs(0, 0, target, coins, map);
    }

    public static int dfs(int i, int amount, int target,int[] coins, Map<String, Integer> map) {
        if (amount == target) return 1;
        if (amount > target) return 0;
        if (i == coins.length) return 0;

        String key = i+","+amount;
        if (map.containsKey(key)) return map.get(key);

        int val = dfs(i, amount + coins[i], target, coins, map)
                + dfs(i + 1, amount, target, coins, map);

        map.put(key, val);
        return val;
    }
    public static void main(String[] args) {
        System.out.println(countCoinChange(new int[]{1,2,5}, 5));
    }
}
