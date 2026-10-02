class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(new char[2 * n] , 0 , ans);
        return ans;
    }
    public void helper(char[] chars , int pos , List<String> ans){
        if(pos == chars.length){
            if(isValid(chars)){
                ans.add(new String(chars));
            }
            return ;
        }
        chars[pos] = '(';
        helper(chars , pos+1 , ans);

        chars[pos] = ')';
        helper(chars, pos+1 , ans);

    }

    public boolean isValid(char[] chars){
        int balance = 0;
        for (char c : chars) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) return false; 
        }
        return balance == 0;
    }
}