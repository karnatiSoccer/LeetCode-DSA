class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int cnt= 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1'  && !visited[i][j]){
                    cnt++;
                    dfs(i , j , visited, grid);
                }
            }
        }
        return cnt;

    }

    public void dfs(int i , int j , boolean[][] visited, char[][] grid){
        visited[i][j] = true;

        int m = visited.length;
        int n = visited[0].length;


        int[][] dirs = {{-1,0} , {0,1} , {1, 0} , {0,-1}};

        for(int[] dir : dirs){
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == '1' && !visited[newI][newJ]){
                dfs(newI , newJ , visited, grid);
            }
        }
    }
}