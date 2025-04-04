// RECURSION - 2^n

class Solution {
    static int mcm(int arr[] , int i , int j){
        if(i == j){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j-1;k++){
            int cost1 = mcm(arr , i , k);
            int cost2 = mcm(arr , k + 1, j);
            int cost3 = arr[i - 1] * arr[k] * arr[j];
            int finalcost =cost1 + cost2 + cost3;
            ans = Math.min(ans , finalcost);
        }
        return ans;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int x=mcm(arr , 1 , n - 1);
        return x;
    }
}

//MEMOIZATION - O(n ^ 3)

class Solution {
    static int mcm(int arr[] , int i , int j , int[][] dp){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j-1;k++){
            int cost1 = mcm(arr , i , k , dp);
            int cost2 = mcm(arr , k + 1, j , dp);
            int cost3 = arr[i - 1] * arr[k] * arr[j] ;
            int finalcost =cost1 + cost2 + cost3;
            ans = Math.min(ans , finalcost);
        }
        dp[i][j] = ans;
        return ans;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int dp[][] = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        
        int x=mcm(arr , 1 , n - 1 , dp);
        return x;
    }
}


// TABULATION - O(n ^ 3)

class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Length of chain (gap between i and j)
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }
}
