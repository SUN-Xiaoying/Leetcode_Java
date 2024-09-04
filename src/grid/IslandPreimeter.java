package grid;

/*
 * https://leetcode.com/problems/island-perimeter/description/
*/
public class IslandPreimeter {

    // ChatGPT check only right and below
    // 4ms Beats 99.83%
    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rows = grid.length;
        int cols = grid[0].length;
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) { // If it's land
                    perimeter += 4; // Add 4 for the current land cell
                    
                    // Check if there's land to the right
                    if (j < cols - 1 && grid[i][j + 1] == 1) {
                        perimeter -= 2; 
                    }
                    
                    // Check if there's land below
                    if (i < rows - 1 && grid[i + 1][j] == 1) {
                        perimeter -= 2; 
                    }
                }
            }
        }
        return perimeter;
    }
    

    // 6ms Beats 39.17%
    // 自信的增长只能建立在从一个胜利，迈向另一个胜利的基础上。
    public static int mine(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row+2][col+2];
        int sum=0, cnt=0;

        for(int i=0; i<=row+1; i++){
            dp[i][0]=0;
            dp[i][col]=0;
        }

        for(int j=1; j<=col; j++){
            dp[0][j]=0;
            dp[row][j]=0;
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                dp[i+1][j+1] = grid[i][j];
            }
        }

        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                if(dp[i][j] == 1){
                    cnt=0;
                    if(dp[i-1][j]==1){
                        cnt++;
                    }
                    if(dp[i+1][j]==1){
                        cnt++;
                    }
                    if(dp[i][j-1]==1){
                        cnt++;
                    }
                    if(dp[i][j+1]==1){
                        cnt++;
                    }
                    sum+=4-cnt;
                }
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        int[][] grid ={{1,1}};

        System.out.println(islandPerimeter(grid));
    }
}
