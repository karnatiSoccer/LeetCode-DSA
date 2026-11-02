class Solution {
    public int minMoves2(int[] nums) {
        // int total = 0;
        // for(int i = 0 ; i < nums.length; i++){
        //     total+= nums[i];
        // }
        // int avg = total / nums.length;
        Arrays.sort(nums);

        int median = nums[nums.length/2];

        int ans = 0;
        for(int i : nums){
            // System.out.println( Math.abs(i - median));
            ans += Math.abs(i - median);
        }
        return ans;
    }
}