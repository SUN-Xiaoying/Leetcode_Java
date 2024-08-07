

# Init

```java
  List<> list = new ArrayList<>();
    List<List<Integer>> matrix = new ArrayList<>();

  Set<> set = new HashSet<>();

  Map<Integer, Integer> map = new HashMap<>();

```
  Factorials of n>20 cannot be stored even in a 64-bit long long variable. BigIntger must be used.

```java
  public static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.ONE; // Start with 1
        for(int i=2; i<=n; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
    }

```

# MATH

|Sign|Math|
|---|---|
|square| `Math.sqrt()`|
|factorial|阶乘 |
|diagonal|对角线|
|`int remainder = dividend % divisor;`|取余|


```java


Math.floor() <= i <= Math.ceil();
```



# MAP

Map find the most frequent number in a list

```java
    Map<Integer, Integer> frequencyMap = new HashMap<>();
        
    // Count the frequency of each number
    for (Integer number : list) {
        frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
    }

    Integer mostFrequentNumber = null;
    int maxFrequency = 0;

    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
        Integer number = entry.getKey();
        Integer frequency = entry.getValue();
        if (frequency > maxFrequency) {
            maxFrequency = frequency;
            mostFrequentNumber = number;
        }
    }

    return mostFrequentNumber;
```

# Transform

|From|To|Code|
|----|----|----|
|double|int|`int intValue = (int) doubleValue;`|
|String|int|`int number = Integer.parseInt(numberStr);`|
|`List<Integer> ar`|`int sum`|```ar.stream().mapToInt(Integer::intValue).sum();```|
|`List<Long> ar`|`long sum`|```ar.stream().mapToLong(Long::longValue).sum();```|

## Map to List

```java
    List<Integer> valuesList = map.values()
                                  .stream()
                                  .collect(Collectors.toList());
```

## Integer to str
```java
    String.format("%02d", intVar);
    System.out.printf("%.6f%n", (double) posNum / bottomNum);
```

>   Not 0.6



# String

||||
|---|---|----|
||`str.substring(start , end);` |endPosition=str.length() by default|
||`str.indexOf(charValue);`||
||`str.charAt(index);` |not `getChar`|

## SubString
```java
    str.substring( startPosition, endPosition );
```


### TimeFormat

12 hour to 24 hour.
```java
      if (period.equals("AM")) {
          if (hourInt == 12) {
              hourInt = 0; // Midnight case
          }
      } else { // PM case
          if (hourInt != 12) {
              hourInt += 12; // Convert PM hour to 24-hour format
          }
      }
```


# MaxMin

# Sort

## MID

左加(右减左>>1)

```java
    int mid=left+((right-left)>>1);
```

## SWAP

I J I

```java
    public static void swap(int[]arr, int i, int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
```
> 字符串就不可哦! char[]

## Array

```java
      List<Integer> arr;
      Collections.sort(arr);
```

### REVERSE
```java
    public static void reverse(int[]a, int start, int end) {
        while(st < ed){
            swap(a, st, ed);
            st++;
            ed--;
        }
    }



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