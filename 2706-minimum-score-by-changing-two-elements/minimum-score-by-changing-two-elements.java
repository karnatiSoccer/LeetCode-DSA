// class Solution {
//     public int minimizeSum(int[] nums) {
//         Arrays.sort(nums);
//         int low = Integer.MAX_VALUE;
//         int high = Integer.MIN_VALUE;

//         for(int i = 0 ; i < nums.length-1 ; i++){
//             low = Math.min(low , Math.abs(nums[i+1] - nums[i-1]));
//         }
//         high = nums[nums.length-1] - nums[0];

//         if(low  >=  high){
//             return high;
//         }

//         return low;
        
//     }
// }

class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(Math.min(nums[n-1] - nums[2], nums[n-3] - nums[0]), nums[n-2] - nums[1]);
    }
}