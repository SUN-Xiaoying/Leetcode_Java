
# 葵花宝典

- 求和先排队 （`Arrays.sort`）
  - 位置用地图 (`Map<Integer, Integer> map = HashMap<>()`)
- 求差滑滑梯
- 查重找哈希

## 1. 链表
### 入环
- 快慢指针
  1. 相遇, 快指针从头慢慢来
  2. 再相遇, 就是缘分开始

### 相交
1. 短的放进HashSet
2. 统计长度，长的先走

### Palindrome
1. stack, 遍历两遍 (extra space)
2. 回文，快慢再逆序 (no extra space)

---

## 2. String
### ({})
1. 不用栈，一个变量搞定

### Init

```java
List<> list = new ArrayList<>();
Set<> set = new HashSet<>();
```

---

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

1. `L + R` Overflow Warning
2. Shift is the fastest

```java
    mid=left+((right-left)>>1)
```

### swap

```java
    public static void swap(int[]arr, int i, int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
```
> 字符串就不可哦! char[]

### reverse
```java
    public static void reverse(int[] nums, int i, int j) {
        while(i<j){
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
            i++;
            j--;
        }
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

