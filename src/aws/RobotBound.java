package aws;

// https://leetcode.com/problems/robot-bounded-in-circle/description/
public class RobotBound {
    public static final char[] directions={'N', 'E', 'S', 'W'};

    // ChatGPT add one more judgement, dir!=0
    public static boolean isRobotBounded(String instructions) {
         // Directions are represented as north (0), east (1), south (2), and west (3)
         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
         int x = 0, y = 0; // Initial position
         int dir = 0; // Initial direction facing north (0)
 
         for (char instruction : instructions.toCharArray()) {
             if (instruction == 'G') {
                 x += directions[dir][0];
                 y += directions[dir][1];
             } else if (instruction == 'L') {
                 dir = (dir + 3) % 4; // Turn left
             } else if (instruction == 'R') {
                 dir = (dir + 1) % 4; // Turn right
             }
         }
 
         // The robot is bounded in a circle if it returns to the origin or doesn't face north
         return (x == 0 && y == 0) || dir != 0;
    }
    // 109 / 117 testcases passed
    public static boolean mine(String instructions) {
        int[] cur={0,0};
        int i=0;

        String temp = "";
        for(int k=0; k<4; k++){
            temp+=instructions;
        }

        for(char ch: temp.toCharArray()){
            if(ch=='G'){
                char d = directions[Math.abs(i%4)];
                if(d=='N'){
                    cur[1]++;
                } else if(d=='S'){
                    cur[1]--;
                } else if(d=='W'){
                    cur[0]--;
                } else {
                    cur[0]++;
                }
            } else if(ch=='L'){
                i--;
            } else {
                i++;
            }

            if(cur[0]==0 && cur[1]==0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1= "GGLLGG";

        System.out.println(isRobotBounded(s1));
    }
}

