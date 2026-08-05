class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> map = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            map.add(new ArrayList<>());
        }

        for(int[] invocation : invocations){
            int u = invocation[0];
            int v = invocation[1];

            map.get(u).add(v);
        }

        Set<Integer> suspicious =  new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        suspicious.add(k);
        q.offer(k);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neigh : map.get(curr)){
                if(!suspicious.contains(neigh)){
                    suspicious.add(neigh);
                    q.offer(neigh);
                }
            }
        }

        boolean canRemove = true;
        for (int[] inv : invocations) {
            int u = inv[0];
            int v = inv[1];
                if (!suspicious.contains(u) && suspicious.contains(v)) {
                canRemove = false;
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!canRemove || !suspicious.contains(i)) {
                ans.add(i);
            }
        }

        return ans;

        
    }
}