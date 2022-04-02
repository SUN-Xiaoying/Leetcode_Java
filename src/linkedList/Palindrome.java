package linkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

public class Palindrome {
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

    // tool: creat LinkedList
    public static ListNode create(){
        int size = nextInt();
        if(size == 0)return null;
        ListNode head=null;
        ListNode cur=null;
        int val;
        for(int i=0; i<size;i++){
            val=nextInt();
            // node is inline variable
            // ListNode node = new ListNode(val);
            if(head==null){
                head = new ListNode(val);
                cur=head;
            }else{
                cur.next=new ListNode(val);
                cur=cur.next;
            }
        }
        return head;
    }
    // tool: Reverse
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode cur=head;
        ListNode pre=null;
        ListNode temp=null;
        while(cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }

    public boolean isPail (ListNode head) {
        // fast-slow
        ListNode fast=head;
        ListNode slow=head;
        while(fast!= null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        fast=reverseList(slow);
        slow=head;
        while(slow!= null){
            if(slow.val != fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
}
