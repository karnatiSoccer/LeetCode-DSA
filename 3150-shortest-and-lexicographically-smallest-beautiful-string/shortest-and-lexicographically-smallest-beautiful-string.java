class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "*";

        int i= 0;
        
        for(int j = 0 ; j < s.length() ; j++){
            char cur = s.charAt(j);
            if(cur == '1')k--;

            while(k < 0){
                if(s.charAt(i)== '1')k++;
                i++;
            }
            
            while (k == 0 && s.charAt(i) == '0') {
                i++;
            }

            if(k == 0){
                String subString = s.substring(i , j+1);

                ans = compare(ans , subString); 
            }

        }

        return ans.equals("*") ?  "" : ans;
    }


    public String compare(String ans , String subString){
        if(ans.equals("*")) return subString;

        if(subString.length() < ans.length()) return subString;

        else if(subString.length() > ans.length()) return ans;

        return subString.compareTo(ans) < 0? subString : ans;
    } 
}
