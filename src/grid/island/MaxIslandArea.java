package grid.island;

/*
 * https://leetcode.com/problems/max-area-of-island/description/
 * https://www.youtube.com/watch?v=iJGr1OtmH0c
 */
public class MaxIslandArea {
    //2ms Beats 67.68%
    public int maxAreaOfIsland(int[][] grid) {
        // line from ChatGPT
        if (grid == null || grid.length == 0) return 0;

        int ROW = grid.length;
        int COL = grid[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        int max_area = Integer.MIN_VALUE;
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                // line from ChatGPT
                if (grid[i][j] == 1 && !visited[i][j]) { 
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
 