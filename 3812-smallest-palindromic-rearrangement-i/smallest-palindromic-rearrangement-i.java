class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        int n =s.length();
        char mid = '*';


        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
            
        }

        for(int i =0 ; i < 26 ; i++){
            if(freq[i] % 2 == 1) mid = (char)('a' + i); 
        }
        
        StringBuilder ans = new StringBuilder();
        
        for(int i = 0 ; i < 26 ; i++){
            while(freq[i] >= 2){
                ans.append((char )('a' + i));
                freq[i] -= 2 ;
            }
        }
        String reversed = new StringBuilder(ans).reverse().toString();
        
        if( n % 2 == 1) ans.append(mid);
        
        ans.append(reversed);

        // System.out.println(ans);
        return ans.toString();
    }
}