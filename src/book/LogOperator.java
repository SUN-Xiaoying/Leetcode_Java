package book;

public class LogOperator {

    public static int[] generateRandomArray(int size, int value) {
        // generate random length array
        int [] arr = new int[(int)((size+1)*Math.random())];
        for(int i =0; i<arr.length; i++){
            // Not important. Difference between two random numbers
            arr[i] = (int)((value+1)*Math.random()) - (int)(value*Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        

    }
}
