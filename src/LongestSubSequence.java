public class LongestSubSequence {

    public static int longestSubsequenceLength(String text1, String text2) {
        int m = text1.length() +1;
        int n = text2.length() +1;

        int[][] dp = new int[m][n];

        for (int i =0; i < m-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = 1 + dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequenceLength("abcde", "ace"));
        System.out.println(longestSubsequenceLength("abc", "abc"));
        System.out.println(longestSubsequenceLength("abc", "def"));
    }
}
