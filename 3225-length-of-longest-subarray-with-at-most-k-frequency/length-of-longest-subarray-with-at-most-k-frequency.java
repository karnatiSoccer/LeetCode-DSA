class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        HashMap<Integer ,Integer > hash = new HashMap<>();
        int n = nums.length;

            int j = 0;
        int maxLen = 0;
        for(int i = 0 ; i < n; i++){

            while( j < n && hash.getOrDefault(nums[j] , 0) < k){
                hash.put(nums[j] , hash.getOrDefault(nums[j] , 0) + 1 );

                j++;
            }
            
            maxLen = Math.max(maxLen ,j-i );
            hash.put(nums[i] ,  hash.get(nums[i]) -1) ;
            
        
        }

        return maxLen;
    }
}