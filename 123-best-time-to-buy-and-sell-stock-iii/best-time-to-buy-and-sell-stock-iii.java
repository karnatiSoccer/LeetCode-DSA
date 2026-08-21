class Solution {
    Integer[][][] memo;
    final int NEG_INF = Integer.MIN_VALUE / 2;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new Integer[n][2][3];
        return helper(n - 1, 1, 2, prices);
    }
    public int helper(int idx, int state, int cap, int[] prices) {
        if (idx < 0) return state == 1 ? 0 : NEG_INF;   
        if (cap == 0 && state == 1) return 0;           

        if (memo[idx][state][cap] != null) return memo[idx][state][cap];

        int res;
        if (state == 1) {
            int skip = helper(idx - 1, 1, cap, prices);
            int sellToday = helper(idx - 1, 0, cap - 1, prices) + prices[idx];
            res = Math.max(skip, sellToday);
        } else {
            int skip = helper(idx - 1, 0, cap, prices);
            int buyToday = helper(idx - 1, 1, cap, prices) - prices[idx];
            res = Math.max(skip, buyToday);
        }
        return memo[idx][state][cap] = res;
    }
}