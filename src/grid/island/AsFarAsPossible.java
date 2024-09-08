package grid.island;

/*
 * https://leetcode.com/problems/as-far-from-land-as-possible/description/
 * https://www.youtube.com/watch?v=oEW2leDRVY0&list=PLvKfL6GtwDxwuyrpAJfU3HTnPZl4WnraE&index=62
*/
public class AsFarAsPossible {
    /*
    * BFS,  Breadth-First Search
    * 宽度优先遍历
    */ 
    public int maxDistance(int[][] grid) {
        int l=0, r= 0;
        int ROW = grid.length;
        int COL = grid[0].length;
        int[][] queue = new int[ROW*COL][2];
        boolean[][] visited = new boolean[ROW][COL];
        int[] move = new int[]{-1, 0, 1, 0, -1};
        int seas = 0;
        
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                if(grid[i][j]==1){
                    visited[i][j] = true;
                    queue[r][0] = i;
                    queue[r++][1] = j;
                } else {
                    visited[i][j] = false;
                    seas++;
                }
            }
        }

        // 题目要求
        if(seas==0 || seas==ROW*COL){
            return -1;
        }


        int level =0, size=0;
        while(l<r){
            level++;
            size = r-l;

            for(int k=0, x,y,nx,ny; k<size; k++){
                x=queue[l][0];
                y=queue[l++][1];

                for(int i=0; i<4; i++){
                    nx=x+move[i];
                    ny=y+move[i+1];

                    if(nx>=0 && nx<ROW && ny>=0 && ny<COL && grid[nx][ny]==0 && !visited[nx][ny]){
                        visited[nx][ny]=true;
                        queue[r][0]=nx;
                        queue[r++][1]=ny;
                    }
                }
            }
        }

        return level-1;
    }
}
