package tabulation;

public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(6));
        System.out.println(fib(9));
        System.out.println(fib(50));
    }

    public static Integer fib(int n) {
        int[] table = new int[n + 1];
        table[0] = 0;
        table[1] = 1;

        for(int i = 2; i <= n; i++) {
            table[i] = table[i-1] + table[i-2];
        }
        return table[n];
    }
}
