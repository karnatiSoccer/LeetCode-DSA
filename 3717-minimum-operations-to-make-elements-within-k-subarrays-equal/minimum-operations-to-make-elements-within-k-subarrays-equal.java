
import java.util.*;

class Solution {

    private static class MultiSet {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;
        long sum = 0;

        void add(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            size++;
            sum += val;
        }

        void remove(int val) {
            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }

            size--;
            sum -= val;
        }

        int getMin() {
            return map.firstKey();
        }

        int getMax() {
            return map.lastKey();
        }
    }

    private MultiSet lower = new MultiSet();
    private MultiSet upper = new MultiSet();

    // Add an element to the sliding window
    private void add(int val) {

        if (lower.size == 0 || val <= lower.getMax()) {
            lower.add(val);
        } else {
            upper.add(val);
        }

        balance();
    }

    // Remove an element from the sliding window
    private void remove(int val) {

        if (lower.map.containsKey(val)) {
            lower.remove(val);
        } else {
            upper.remove(val);
        }

        balance();
    }

    // Maintain lower.size == upper.size
    // OR lower.size == upper.size + 1
    private void balance() {

        while (lower.size > upper.size + 1) {
            int val = lower.getMax();

            lower.remove(val);
            upper.add(val);
        }

        while (lower.size < upper.size) {
            int val = upper.getMin();

            upper.remove(val);
            lower.add(val);
        }
    }

    // Minimum operations to make current window equal
    private long getCost() {

        int median = lower.getMax();

        long leftCost =
            (long) median * lower.size - lower.sum;

        long rightCost =
            upper.sum - (long) median * upper.size;

        return leftCost + rightCost;
    }

    // Calculate cost of every window of size x
    private long[] getWindowCosts(int[] nums, int x) {

        int n = nums.length;
        int m = n - x + 1;

        long[] cost = new long[m];

        lower = new MultiSet();
        upper = new MultiSet();

        // First window
        for (int i = 0; i < x; i++) {
            add(nums[i]);
        }

        cost[0] = getCost();

        // Remaining sliding windows
        for (int i = x; i < n; i++) {

            remove(nums[i - x]);

            add(nums[i]);

            cost[i - x + 1] = getCost();
        }

        return cost;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate minimum cost for every window
        long[] cost = getWindowCosts(nums, x);

        // Step 2: DP
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        // dp[i][j] = minimum cost using first i elements
        //            while selecting exactly j windows

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= k; j++) {

                // Option 1: Skip current element
                dp[i][j] = dp[i - 1][j];

                // Option 2: Select window ending at i-1
                if (j > 0 && i >= x) {

                    long pick =
                        dp[i - x][j - 1] + cost[i - x];

                    dp[i][j] = Math.min(
                        dp[i][j],
                        pick
                    );
                }
            }
        }

        return dp[n][k];
    }
}