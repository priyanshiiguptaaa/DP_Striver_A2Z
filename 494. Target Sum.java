class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0; 
        for (int num : nums) {
            total += num;
        }

        if ((target + total) % 2 != 0 || Math.abs(target) > total) {
            return 0;
        }

        int x = (target + total) / 2;
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = x; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[x];
    }
}
