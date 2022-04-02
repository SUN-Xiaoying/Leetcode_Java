package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Overlap {
    // input: stream
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static int nextInt(){
        try{
            st.nextToken();
            return (int)st.nval;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    // tool function
    public static ListNode create(){
        int size=nextInt();
        if(size==0)return null;
        ListNode head=null;

        ListNode cur=null;
        int val;
        for(int i=0;i<size;i++){
            val=nextInt();
            if(head==null){
                head = new ListNode(val);
                cur=head;
            }else{
                cur.next= new ListNode(val);
                cur=cur.next;
            }
        }
        return head;
    }


    public static void main(String[] args) throws IOException {
        // input
        ListNode head1=create();
        ListNode n1=head1;
        ListNode head2=create();
        ListNode n2=head2;

        // handle
        StringBuilder sb = new StringBuilder();
        while(n1!=null && n2!=null){
            if(n1.val == n2.val){
                sb.append(n1.val).append(" ");
                n1=n1.next;
                n2=n2.next;
            }else if(n1.val > n2.val){
                n2=n2.next;
            }else{
                n1=n1.next;
            }
        }

        // output
        System.out.println(sb.toString());
    }
}
