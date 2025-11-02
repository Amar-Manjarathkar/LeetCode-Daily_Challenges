class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] wall : walls){
            grid[wall[0]][wall[1]] = -1;        
            }
        for (int[] guard : guards){
            grid[guard[0]][guard[1]] = -2;
        }
        for (int[] guard : guards){
            int r = guard[0];
            int c = guard[1];

            int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};

            for (int[] dir : directions){
                int dr = dir[0];
                int dc = dir[1];
                int currR = r + dr;
                int currC = c + dc;

                while (currR >= 0 &&
                    currR < m && currC >= 0 
                    && currC < n){
                        if(grid[currR][currC] < 0){
                            break;
                        }
                        if(grid[currR][currC]==0){
                            grid[currR][currC]=1;
                        }
                        currR+=dr;
                        currC+=dc;
                    }
            }
        }
        int unguardedCount = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j]==0){
                    unguardedCount++;
                }
            }
        }
            return unguardedCount;

    }
}
