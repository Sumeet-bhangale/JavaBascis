

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] inputArray = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = inputArray.length;

        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        // Dynamic Programming approach to find LIS
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (inputArray[i] > inputArray[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        // Find the maximum value in lis array
        int maxLength = Arrays.stream(lis).max().orElse(1);

        System.out.println("Length of Longest Increasing Subsequence: " + maxLength);
    }
}
