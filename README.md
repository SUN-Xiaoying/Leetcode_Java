### Init

```java
List<> list = new ArrayList<>();
Set<> set = new HashSet<>();
```




# IO

# Array and Strings

### maxPorfit

> Time Limit Exceeded:

差价找最大

## 3Sum
三数之和先排序
```java
Arrays.sort(nums);
```

# Sort
## mid

```java
    mid=left+((right-left)>>1)
```

## swap

```java
    public static void swap(int[]arr, int i, int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
```

# 2. LinkedList
## 2.1 reverse
```java
    public ListNode reverse(ListNode head){
        //basecase
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
```

## 2.2 isPail

`right!=null || fast!=null`, or NullPointerException Warning.

