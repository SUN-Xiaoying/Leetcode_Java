package book;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Sqrt {
        /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

     public static void readAllRows(String s) {
        double square = Math.sqrt(s.length());
        int rowInt = (int)Math.floor(square);
        int colInt = (int)Math.ceil(square);

        if(rowInt*colInt < s.length()){
            rowInt++;
        }
        System.out.println(rowInt);
        System.out.println(colInt);
        List<StringBuilder> rows = new ArrayList<>();

        for(int i=0; i<rowInt; i+=colInt){
            rows.add(new StringBuilder());
        }

        for(int j=0; j<s.length(); j+=colInt){
            int k=0;
            int end = j+colInt > s.length() ? s.length() : j+colInt;
            rows.get(k).append(s.substring(j, end));
            System.out.println(s.substring(j, end));
            k++;
        }
    }

    public static String encryption(String s) {
        // Write your code here
            int strLen = s.length();
            double square = Math.sqrt(strLen);
            int rowInt = (int)Math.floor(square);
            int colInt = (int)Math.ceil(square);
            
            if (rowInt*colInt < strLen) {
                rowInt++;
            }
            
            List<StringBuilder> columnList = new ArrayList<>();
            for(int j=0; j<colInt; j++){
                columnList.add(new StringBuilder());
            }
            
            for(int i=0; i<strLen; i++){
                columnList.get(i%colInt).append(s.charAt(i));
            }
            StringBuilder result = new StringBuilder();
            for(StringBuilder col: columnList){
                result.append(col.toString()).append(" "); 
            }
            return result.toString();
        }

    public static void main(String[] args) {

        String s = "chillout";

        readAllRows(s);
        String cols = encryption(s);

        System.out.println(cols);
    }
}
