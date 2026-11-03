class Solution {
    public int minMoves(int[] nums) {
        int max = -1;
        for(int i : nums){
            max = Math.max(max , i);
        }
        int ans = 0;
        for(int i : nums){
            ans += Math.abs(i - max);
        }
        return ans;
    }
}