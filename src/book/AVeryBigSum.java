package book;

//Function Description
//
//Complete the aVeryBigSum function in the editor below. It must return the sum of all array elements.
//
//aVeryBigSum has the following parameter(s):
//
//int ar[n]: an array of integers .
//Return
//
//long: the sum of all array elements
//Input Format
//
//The first line of the input consists of an integer .
//The next line contains  space-separated integers contained in the array.
//
//Output Format
//
//Return the integer sum of the elements in the array.
//
//Sample Input
//
//5
//1000000001 1000000002 1000000003 1000000004 1000000005
//
//Output
//5000000015

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class AVeryBigSum {

    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        return ar.stream().mapToLong(Long::longValue).sum();
    }
   public static void main(String[] args) throws IOException {
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

       int arCount = Integer.parseInt(bufferedReader.readLine().trim());

       List<Long> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
               .map(Long::parseLong)
               .collect(toList());

       long result = aVeryBigSum(ar);

       bufferedWriter.write(String.valueOf(result));
       bufferedWriter.newLine();

       bufferedReader.close();
       bufferedWriter.close();
   }
}
