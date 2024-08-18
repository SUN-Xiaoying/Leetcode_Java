package matrix;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    public static String mine(List<String> grid) {

        // Write your code here
        int n = grid.size();
        int m = grid.get(0).length();
        List<String> sortedGrid = new ArrayList<String>();

        // for(int i=0; i<n; i++){
        //     char[] chars = grid.get(i).toCharArray();
        //     Arrays.sort(chars);
        //     sortedGrid.add(new String(chars));
        // }

        for(int i=0; i<n; i++){
            for(int j=0;j<m-1; j++){
                if((int)sortedGrid.get(i).charAt(j) > (int)sortedGrid.get(i).charAt(j+1)){
                    return "NO";
                }
            }
        }

        for(int i=0; i<n-1; i++){
            for(int j=0;j<m; j++){
                if((int)sortedGrid.get(i).charAt(j) > (int)sortedGrid.get(i+1).charAt(j)){
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        List<String> grid = new ArrayList<>();

        grid.add("mpxz");
        grid.add("abcd");
        grid.add("wlmf");

        // grid.add("ebacd");
        // grid.add("fghij");
        // grid.add("olmkn");
        // grid.add("trpqs");
        // grid.add("xywuv");

        System.out.println(mine(grid));
    }
    
}
