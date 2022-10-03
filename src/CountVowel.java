import java.util.HashMap;
import java.util.Map;

public class CountVowel {

    public static int countVowel(int n) {
        Map<String, Integer> map = new HashMap<>();
        return dp(n, 0, map);
    }

    public static int dp(int n, int i, Map<String, Integer> map) {
        if (n == 0) return 1;
        if (i == 5) return 0;

        String key = i+","+n;
        if (map.containsKey(key)) return map.get(key);
        int ans = dp(n, i+1, map);
        ans += dp(n-1, i, map);

        map.put(key, ans);
        return ans;
    }

    public static int amazing(int n) {
        int a = 1, e = 1, i = 1, o =1, u =1;

        while (n > 1) {
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
            n--;
        }
        return a+e+i+o+u;
    }

    public static void main(String[] args) {
        System.out.println(countVowel(2));
        System.out.println(countVowel(1));
        System.out.println(countVowel(3));
        System.out.println(countVowel(33));

        System.out.println(amazing(1));
        System.out.println(amazing(2));
        System.out.println(amazing(3));
        System.out.println(amazing(33));
    }
}
