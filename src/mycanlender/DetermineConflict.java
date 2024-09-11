package mycanlender;

/*
 * https://leetcode.com/problems/determine-if-two-events-have-conflict/description/
 */
public class DetermineConflict {

    /*
     * 0ms Beats 100.00%
     * Xiao conquests world with one-line code
    */
    public static boolean haveConflict(String[] event1, String[] event2) {
        boolean first = (event1[1].compareTo(event2[0]))>=0;
        boolean second = (event2[1].compareTo(event1[0]))>=0;
        return first && second;
    }
   

    public static void main(String[] args) {
        String[] event1 = {"10:00","11:00"};
        String[] event2 = {"14:00","15:00"};

        System.out.println(haveConflict(event1, event2));
    }
}
