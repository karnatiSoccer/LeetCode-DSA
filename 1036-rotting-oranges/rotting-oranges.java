class Solution {

    class rotOrange{
        int i ,j;
        rotOrange(int i , int j){
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<rotOrange> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1) cnt++;
                else if(grid[i][j] == 2){
                    q.offer(new rotOrange(i , j));
                }
            }
        }

        int[][] dirs = {
            {-1, 0},  // up
            {1, 0},   // down
            {0, -1},  // left
            {0, 1}    // right
        };

        // boolean[][] 

        int rotCnt = q.size();
        // if(rotCnt == 0) return 0;
        if (rotCnt == 0) 
            return cnt == 0 ? 0 : -1; 
            
        int min =-1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int k = 0; k < size; k++) {
                rotOrange curr = q.poll();
                int i = curr.i;
                int j = curr.j;

                for(int[] dir : dirs){
                    int newI = i+ dir[0];
                    int newJ = j+ dir[1];

                    if(newI >= 0 && newI < m && newJ >= 0 && newJ <n && grid[newI][newJ] == 1){
                        grid[newI][newJ] = 2;
                        q.offer(new rotOrange(newI ,newJ));
                        // rotCnt++;
                        cnt--;
                    }
                }
            }
            min++;
        }
        // System.out.println(rotCnt+ " " + cnt);
        return cnt == 0 ? min : -1;
        


    }
}