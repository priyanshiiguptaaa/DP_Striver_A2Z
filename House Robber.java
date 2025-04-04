class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int[] dp = new int[n + 1]; 
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);
        for(int i = 2 ; i < n ; i++){
            int ans1 = dp[i - 1];
            int ans2 = dp[i - 2] + nums[i];
            dp[i] = Math.max(ans1 , ans2);
        }
        return dp[n - 1];
    }
}
