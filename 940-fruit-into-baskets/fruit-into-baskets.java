class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer , Integer > hash = new HashMap<>();
        int i = 0;
        int maxLen = 0;

        for(int j = 0 ; j < fruits.length ; j++){
            int currTree = fruits[j];
            hash.put(currTree, hash.getOrDefault(currTree , 0) +1);

            while(hash.size() > 2){
                hash.put(fruits[i] , hash.getOrDefault(fruits[i] , 0) -1);
                if(hash.get(fruits[i]) == 0) hash.remove(fruits[i]);
                i++;
                
            }

            maxLen = Math.max(maxLen , j-i+1);
        }
        return maxLen;
    }
}