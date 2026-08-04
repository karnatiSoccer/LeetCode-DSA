class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        if(nums.length < 2) return ans; 

        Arrays.sort(nums);
        
        for(int i = 1; i < nums.length ; i++){
            if(nums[i-1]+1 == nums[i]){
                continue;
            }
            for(int j = nums[i-1]+1 ; j < nums[i] ;j++){
                ans.add(j);
            }    
        }
        return ans;
    }
}