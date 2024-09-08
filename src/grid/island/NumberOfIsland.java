package grid.island;

/*
*   https://leetcode.com/problems/number-of-islands/description/
*/ 
public class NumberOfIsland {

    // 2ms Beats 99.72%
    // ChatGPT, no need of boolean[][], using grid[i][j] = '0';



    // 4ms Beats 48.05%
    // First shot, literally the same as MaxAreaOfIsland
    public int mine(char[][] grid) {
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        int sum=0;
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                sum+= dfs(i,j,visited, grid);
            }
        }

        return sum;
    }

    private int dfs(int i, int j, boolean[][] visited, char[][] grid){
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length
            || visited[i][j] || grid[i][j] == '0'){
                return 0;
        }

        visited[i][j]=true;

        dfs(i-1, j, visited, grid);
        dfs(i+1, j, visited, grid);
        dfs(i, j-1, visited, grid);
        dfs(i, j+1, visited, grid);

        return 1;
    }
}
