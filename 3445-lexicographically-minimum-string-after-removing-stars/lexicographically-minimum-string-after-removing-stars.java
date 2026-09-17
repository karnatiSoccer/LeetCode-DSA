class Solution {
    public String clearStars(String s) {

        StringBuilder ans = new StringBuilder();
        int n = s.length();

        PriorityQueue<Character> pq = new PriorityQueue<>();
        Map<Character , Deque<Integer>> map  = new HashMap<>();

        boolean[] keep = new boolean[n];

        Arrays.fill(keep , true);

        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(c == '*'){
                char smallest = pq.poll();
                int idxToRemive = map.get(smallest).removeLast();
                keep[i] = false;
                keep[idxToRemive] = false;

            }
            else{
                pq.offer(c);
                map.putIfAbsent(c , new ArrayDeque<>());
                map.get(c).add(i);
            }
        }
        for(int i = 0 ;i < n ;i++){
            if(keep[i]){
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}