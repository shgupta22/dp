package memoization;

public class Fib {
    public static void main(String[] args) {
        System.out.println(fib_rec(4));
        System.out.println(fib_rec(0));
        System.out.println(fib_rec(9));
        System.out.println(fib_mem(50));
        System.out.println(fib_without_extra_space(100));
    }

    public static long fib_rec(long n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return fib_rec(n-1) + fib_rec(n-2);
    }

    public static long fib_mem(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        long f[] = new long[n+2];
        f[0] = 0;
        f[1] = 1;

        for (int i  =2; i<= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static long fib_without_extra_space(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        long f1 = 0;
        long f2 = 1;
        long fn = 0;

        for (int i = 2; i <= n; i++) {
            fn = f1 + f2;
            f1 = f2;
            f2 = fn;
        }
        return fn;
    }
}
