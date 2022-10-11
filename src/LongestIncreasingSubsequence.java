import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static int longestSubsequence(int[] nums) {
        int[] lis = new int[nums.length +1];

        for (int i=0; i < nums.length;i++) lis[i]=1;

        for (int i=nums.length-1; i >=0; i--) {
            for (int j = i+1; j<nums.length;j++) {
                if (nums[i] < nums[j]) {
                    lis[i] = Math.max(lis[i], 1+ lis[j]);
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{2,3,5,1,5,6,7,4,10}));
        System.out.println(longestSubsequence(new int[]{1,2,4,3}));
    }
}
