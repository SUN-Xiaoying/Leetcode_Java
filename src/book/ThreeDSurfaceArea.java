package book;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ThreeDSurfaceArea {


    public static int findMaxInMatrix(List<List<Integer>> A){
        // Initialize max with the smallest possible integer value
        int max = Integer.MIN_VALUE;

        // Iterate through each row
        for (List<Integer> row : A) {
            for (int value : row) {
                max = (value > max) ? value : max;
            }
        }

        return max;
    }

    public static List<Integer> findMaxInRows(List<List<Integer>> A){
        // Initialize max with the smallest possible integer value
        List<Integer> maxInRows = new ArrayList<>();

        // Iterate through each row
        for (List<Integer> row : A) {
            int maxValue = Integer.MIN_VALUE;
            for (int value : row){
                maxValue = (value > maxValue) ? value : maxValue;
            }
            maxInRows.add(maxValue);
        }
        
        return maxInRows;
    }

    public static List<List<Integer>> flipMartix(List<List<Integer>> A){

        int colSize = A.get(0).size();

        List<List<Integer>> flipped = new ArrayList<>();
        for(int i =0; i<colSize; i++){
            flipped.add(new ArrayList<>());
        }

        List<Integer> numbers = A.stream()
                                .flatMap(List::stream)  
                                .collect(Collectors.toList());

        for(int i=0; i<numbers.size(); i++){
            flipped.get(i%colSize).add(numbers.get(i));
        }
        return flipped;
    }


    public static int countV(List<Integer> list) {
        int countVSum = 0;
        for(int i=0;i<list.size()-1;i++){
            if( (list.get(i-1)>list.get(i)) && (list.get(i)<list.get(i+1))){
                countVSum++;
            }
        }
        return countVSum;
    }

    public static int countValleys(List<Integer> list) {
        int count = 0;
        int size = list.size();
        
        // Iterate through the list, starting from the second element and ending at the second last element
        for (int i = 1; i < size - 1; i++) {
            int previous = list.get(i - 1);
            int current = list.get(i);
            int next = list.get(i + 1);
            
            // Check if current element forms a valley
            if (current < previous && current < next) {
                count++;
            }
        }
        
        return count;
    }

    public static int surfaceArea(List<List<Integer>> A) {
        // TODO: x,y == 1
        int x = A.size();
        int y = A.get(0).size();
        int z = findMaxInMatrix(A);
        int resultSurface = 0;

        // Find Max Row [4, 3, 4]
        List<Integer> maxInRows = findMaxInRows(A);
        int rowsSum = maxInRows.stream().mapToInt(Integer::intValue).sum();

        // Find Max Col [2, 3, 4]
        List<List<Integer>> flipped = flipMartix(A);
        List<Integer> maxInCols = findMaxInRows(flipped);
        int colsSum = maxInCols.stream().mapToInt(Integer::intValue).sum();


        resultSurface = resultSurface + 2*x*y + 2*colsSum + 2*rowsSum; 

        return resultSurface;
    }

    public static int chatgpt(List<List<Integer>> A){
        int H = A.size();
        int W = A.get(0).size();
        int surfaceArea = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // Top and bottom surfaces
                surfaceArea += 2;

                // Front surface (i-1)
                if (i == 0) {
                    surfaceArea += A.get(i).get(j);
                } else {
                    surfaceArea += Math.max(0, A.get(i).get(j) - A.get(i - 1).get(j));
                }

                // Back surface (i+1)
                if (i == H - 1) {
                    surfaceArea += A.get(i).get(j);
                } else {
                    surfaceArea += Math.max(0, A.get(i).get(j) - A.get(i + 1).get(j));
                }

                // Left surface (j-1)
                if (j == 0) {
                    surfaceArea += A.get(i).get(j);
                } else {
                    surfaceArea += Math.max(0, A.get(i).get(j) - A.get(i).get(j - 1));
                }

                // Right surface (j+1)
                if (j == W - 1) {
                    surfaceArea += A.get(i).get(j);
                } else {
                    surfaceArea += Math.max(0, A.get(i).get(j) - A.get(i).get(j + 1));
                }
            }
        }

        return surfaceArea;
    }

    public static void main(String[] args) {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        // int H = Integer.parseInt(firstMultipleInput[0]);

        // int W = Integer.parseInt(firstMultipleInput[1]);
        // List<List<Integer>> A = new ArrayList<>();

        // IntStream.range(0, H).forEach(i -> {
        //     try {
        //         A.add(
        //             Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        //                 .map(Integer::parseInt)
        //                 .collect(toList())
        //         );
        //     } catch (IOException ex) {
        //         throw new RuntimeException(ex);
        //     }
        // });

        int H=3;
        int W=3;
        List<List<Integer>> A = new ArrayList<>();

        A.add(Arrays.asList(1,3,4));
        A.add(Arrays.asList(2,2,3));
        A.add(Arrays.asList(1,2,4));


        int result = surfaceArea(A);

        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedReader.close();
        // bufferedWriter.close();
    }
}
