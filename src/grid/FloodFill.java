package grid;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]){
            return image;
        }

        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int source, int color){

        int row = image.length;
        int col = image[0].length;
        
        if(sr<0 || sc<0 || sr>row-1 || sc>col-1){
            return;
        } else if(image[sr][sc] != source){
            return;
        }

        image[sr][sc] = color;

        dfs(image, sr-1, sc, source, color);
        dfs(image, sr+1, sc, source, color);
        dfs(image, sr, sc-1, source, color);
        dfs(image, sr, sc+1, source, color);
    }
}
