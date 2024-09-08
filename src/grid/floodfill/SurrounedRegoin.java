package grid.floodfill;

/**
 * https://leetcode.com/problems/surrounded-regions/description/
 * 算法讲解058【必备】洪水填充 https://www.youtube.com/watch?v=BK7hHKxtzmw&list=PLvKfL6GtwDxwuyrpAJfU3HTnPZl4WnraE&index=58
 */
public class SurrounedRegoin {
    public static int[] move = new int[]{-1, 0, 1, 0, -1};

    // 他是怎么想到把边缘岛屿变成F的
    // 2ms Beats 87.89%
    public static void solve(char[][] board) {
        int ROW = board.length;
        int COL = board[0].length;

        for(int i=0; i<ROW; i++){
            if(board[i][0]=='O'){
                dfs(i, 0, ROW, COL, board);
            }
            if(board[i][COL-1]=='O'){
                dfs(i,COL-1, ROW, COL, board);
            }
        }

        for(int j=1; j<COL-1; j++){
            if(board[0][j]=='O'){
                dfs(0, j, ROW, COL, board);
            }
            if(board[ROW-1][j]=='O'){
                dfs(ROW-1, j, ROW, COL, board);
            }
        }

        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='F'){
                    board[i][j]='O';
                }
            }
        }
    }

    private static void dfs(int i, int j, int ROW, int COL, char[][]board){
        if(i<0 || i>=ROW || j<0 || j>=COL || board[i][j]!='O'){
            return;
        }
        board[i][j]='F';
        dfs(i-1, j, ROW, COL, board);
        dfs(i+1, j, ROW, COL, board);
        dfs(i, j-1, ROW, COL, board);
        dfs(i, j+1, ROW, COL, board);
    }



    public static void mine(char[][] board) {
        int ROW = board.length;
        int COL = board[0].length;
        boolean[][] visited = new boolean[ROW][COL];

        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    isSurrounded(i, j, visited, ROW, COL, board);
                }
            }
        }
    }

    // 先judge再染黑
    private static boolean isSurrounded(int x, int y, boolean[][] visited, int ROW, int COL, char[][] board){
        if(x<=0 || x>=ROW-1 || y<=0 || y>=COL-1){
            return false;
        }

        boolean result = true;
        for(int k=0, nx, ny; k<4; k++){
            nx = x+move[k];
            ny = y+move[k+1];

            if(board[nx][ny]=='O' && !visited[nx][ny]){
                result = result && isSurrounded(nx, ny, visited, ROW, COL, board);
            }
        }

        if(result){
            board[x][y]='X';
            return result;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
        for(char[] chars: board){
            System.out.println(String.valueOf(chars));
        }
    }
}