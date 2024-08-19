package aws;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OptimalBoxWeights {
    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        // Write your code here
            int n = arr.size();
            if(n==1){
                return arr;
            }
            Collections.sort(arr);
            int totalSum = arr.stream().mapToInt(Integer::intValue).sum();
            int currentSum = 0;
            List<Integer> result = new ArrayList<>();
            
            for(int i=n-1; i>=0; i--){
                if(currentSum <= totalSum - currentSum){
                    currentSum += arr.get(i);
                    result.add(arr.get(i));
                }
            }
            Collections.sort(result);
            return result;
        }
        
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = minimalHeaviestSetA(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
