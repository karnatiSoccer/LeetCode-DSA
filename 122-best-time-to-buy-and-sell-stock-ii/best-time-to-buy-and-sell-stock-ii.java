class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new Integer[n][2];

        return  helper(n-1 , 0 , prices);
    }

    public int helper(int idx , int buy , int[] prices){
        if (idx < 0) {
            return (buy == 1) ? Integer.MIN_VALUE / 2 : 0;
        }
        
        if(dp[idx][buy] != null) return dp[idx][buy];


        if(buy == 0){
            int doNothing = helper(idx-1 ,0 , prices);
            int sell= helper(idx-1 , 1, prices) + prices[idx];
            return dp[idx][buy] = Math.max(doNothing , sell);
        }
        else{
            int doNothing = helper(idx-1 , 1 , prices);
            int buyToday = helper(idx-1 , 0 ,prices) - prices[idx];

            return dp[idx][buy] = Math.max(doNothing , buyToday);
        }
    }
}