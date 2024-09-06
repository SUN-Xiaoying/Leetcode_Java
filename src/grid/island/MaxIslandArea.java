package grid.island;

/*
 * https://leetcode.com/problems/max-area-of-island/description/
 * https://www.youtube.com/watch?v=iJGr1OtmH0c
 */
public class MaxIslandArea {
    //2ms Beats 67.68%
    public int maxAreaOfIsland(int[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        int max_area = Integer.MIN_VALUE;
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                if (!visited[i][j]) { // Check if the cell is already visited
                    max_area = Math.max(max_area, dfs(i, j, visited, grid));
                }
            }
        }
        return max_area;
    }

    private int dfs(int i, int j, boolean[][] visited, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || 
            !visited[i][j] || grid[i][j] == 0){
                return 0;
        }

        visited[i][j] = true;

        return (1+dfs(i-1, j, visited, grid)
            +dfs(i+1, j, visited, grid)
            +dfs(i, j-1, visited, grid)
            +dfs(i, j+1, visited, grid)
        );
    }
}
 