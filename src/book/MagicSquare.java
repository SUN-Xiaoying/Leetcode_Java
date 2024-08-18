package book;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
    private static void addArrayToList(List<List<Integer>> listOfLists, int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        listOfLists.add(list);
    }
    
    public static List<Integer> getAllSums(List<Integer> allNumbers, List<List<Integer>> allLines){
        List<Integer> allSums = new ArrayList<>();
        for(List<Integer> line: allLines){
            int lineSum = 0;
            for(int pos: line){
                lineSum += allNumbers.get(pos);
            }
            allSums.add(lineSum);
        }
        return allSums;
    }
    
    // Method to calculate frequencies from a list
    public static int getMostFrequentValue(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each number
        for (Integer number : list) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }
        int maxFreqInt = 0;
        int maxFrequency = 0;
        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()){
            if(entry.getValue() > maxFrequency){
                maxFreqInt = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        return maxFreqInt;
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
    // Write your code here
        
        List<Integer> allNumbers = s.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
            
        List<List<Integer>> allLines = new ArrayList<>();
        
        int[] firstRow = {0,1,2};
        int[] secondRow = {3,4,5};
        int[] thirdRow = {6,7,8};
        int[] firstCol = {0,3,6};
        int[] secondCol = {1,4,7};
        int[] thirdCol = {2,5,8};
        int[] leftToRight = {0,4,8};
        int[] rightToLeft = {2,4,6};
    
        // Add all arrays to the list
        addArrayToList(allLines, firstRow);
        addArrayToList(allLines, secondRow);
        addArrayToList(allLines, thirdRow);
        addArrayToList(allLines, firstCol);
        addArrayToList(allLines, secondCol);
        addArrayToList(allLines, thirdCol);
        addArrayToList(allLines, leftToRight);
        addArrayToList(allLines, rightToLeft);
    
        List<Integer> allSums = getAllSums(allNumbers, allLines);
        
        int mostFrequentSum = getMostFrequentValue(allSums);
        
        return mostFrequentSum;
    }

}


public class MagicSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

