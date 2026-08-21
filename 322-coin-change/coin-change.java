class Solution {
    Integer[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount+1];
        Arrays.fill(dp , amount+1);
        dp[0] = 0;

        for(int i = 1 ; i <= amount ; i++){
            for(int coin : coins){
                if(i- coin >= 0){
                    dp[i] = Math.min(dp[i] , dp[i-coin]+1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
        

        // int ans= helper(coins , amount, coins.length-1);
        // return ans == Integer.MAX_VALUE?  -1 : ans;
    }

    // public int helper(int[] coins ,int amount , int idx){
    //         if (amount == 0) return 0;
    //         if (idx < 0 || amount < 0) return Integer.MAX_VALUE;
            
    //         if(dp[amount] != null) return dp[amount];

    //         int taken = Integer.MAX_VALUE;
    //         if(coins[idx] <= amount){
    //             int res = helper(coins , amount- coins[idx], idx);
    //             if(res != Integer.MAX_VALUE) taken = res+1;
    //         }
    //         int noTaken = helper(coins, amount , idx-1);

    //         return dp[amount] = Math.min(taken , noTaken);
        
    // }
}