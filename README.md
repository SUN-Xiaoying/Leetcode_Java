
|trie|前缀树|prefix/dictionary tree|
|----|----|----|
|2D square|正方形||
|3D cube|立方体|`Surface area=6×s^2`|
|Rectangular prism|四棱柱|`Surface area=2lw+2lh+2wh`|
|-|四棱柱|`Volume=l×w×h`|
|Flip Matrix|翻转矩阵||
|Quadrant|象限||
|Partial|局部|partial search|
|Palindrome|回文|
|Deformity|变形|
|Nested|嵌套|

Two-dimensional dynamic programming from recursion

# Math

|Sign|Math|
|---|---|
|exponent|指数|
|recursive|递归|
|adjacent|邻接|
|square| `Math.sqrt()`|
|factorial|阶乘 |
|diagonal|对角线|
|`int remainder = dividend % divisor;`|取余|
|The `k`th Factor of n| `k` 因数 / 因子|
|evenly divide|整除|

指数

```java
double result = Math.pow(2, 3); // 2 raised to the power of 3
System.out.println(result); // Output will be 8.0
```

开方

```java
int X = 16;
double result = Math.sqrt(X);
int result2 = (int) Math.sqrt(16); // Output will be 4
System.out.println(result); // Output will be 4.0

```


```java

Math.floor() <= i <= Math.ceil();
```



## Structure

|Structure|-|Rule||
|----|----|----|----|
|Queue|队列|First In, First Out||
|Stack|栈|First In, Last Out||
|LinkedList|链表||
|Binary Tree|二叉树||

BT
```java

```

Stack
```java
Stack<Integer> stack = new Stack<>();
stack.push(10);

// Retrieve the top element of the stack without removing it.
stack.peek();

// Retrieve the top element of the stack and REMOVE it.
stack.pop();

stack.isEmpty();

```

Queue

```java
Queue<Integer> queue = new LinkedList<>();

// Elements will be ordered in natural order (ascending for numbers)
Queue<Integer> queue = new PriorityQueue<>();


queue.offer(10);
queue.peek();
queue.poll();
queue.isEmpty();
```

Deque

```java
  public Deque<Integer> deque = new LinkedList<>();

  deque.offerFirst();
  deque.offerLast();
```


# Init

## LIST

### Java 8

```java
int[][] dp = new int[rows][cols];

int[] DURATION = {1,3,7};
```

Use Arrays

```java
Arrays.fill(dp, Integer.MAX_VALUE);
Arrays.fill(dp, 0, n, Integer.MAX_VALUE);
```

### Java 15
```java
  List<> list = new ArrayList<>();

   // Add some elements to the list
    list.add(1);
    list.add(2);
    list.add(3);

```

Initiate with specfic column size

```java
    List<List<Integer>> matrix = new ArrayList<>();
    for (int i = 0; i < colSize; i++) {
        flipped.add(new ArrayList<>()); // Initialize each column with an empty list
    }
```

Flipping Matrix

```java
    List<StringBuilder> columnList = new ArrayList<>();
    for(int j=0; j<colInt; j++){
        columnList.add(new StringBuilder());
    }
```


Intiate Matrix in a brutal way

```java
    List<List<Integer>> A = new ArrayList<>();

    // Use Arrays.asList to create the inner lists
    A.add(Arrays.asList(1, 3, 4));
    A.add(Arrays.asList(2, 2, 3));
    A.add(Arrays.asList(1, 2, 4));

```

```java

  Set<> set = new HashSet<>();

  Map<Integer, Integer> map = new HashMap<>();

```
### BigInteger

  Factorials of n>20 cannot be stored even in a 64-bit long long variable. BigIntger must be used.

```java

  public static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.ONE; // Start with 1
        for(int i=2; i<=n; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
    }
```

## MinMax

|||
|----|----|
|int|`Integer.MAX_VALUE`|
|-|`Integer.MIN_VALUE`|
|BigInteger|`BigInteger.ONE`|
|-|`BigInteger.valueOf(Integer.MAX_VALUE)`|

```java
    // Initialize max with the smallest possible integer value
    int max = Integer.MIN_VALUE;
```


# SUM

# ARRAY

||`Arrays.asList()`|
|----|----|
||`Arrays.sort()`|
||`Arrays.fill()`|
||`Arrays.stream(dp).sum()`|

## Sort

```java
    List<Integer> arr;
    Collections.sort(arr);

    // Sort the list in descending order
    Collections.sort(arr, Collections.reverseOrder());
```



## Sum of the List

### Java 8

```java
int[] dp = new int[size];
Arrays.stream(dp).sum();
```

### Java 15

```java
List<Integer> ar
int sum = ar.stream().mapToInt(Integer::intValue).sum();
```


```java
List<Long> ar
long sum = ar.stream().mapToLong(Long::longValue).sum();
```






# MAP

Find the most frequent number in a list

```java
     List<Integer> numbers = Arrays.asList(1, 3, 2, 3, 4, 2, 3, 2, 2, 4, 4, 4); // Example list of numbers

        // Use a HashMap to store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the most frequent number
        int mostFrequent = -1;
        int maxCount = -1;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequent = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        // Output the most frequent number
        System.out.println("The most frequent number is: " + mostFrequent);
```

```java
        // Use a map to count the frequency of each number
        Map<Integer, Long> frequencyMap = numbers.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        // Find the entry with the maximum frequency
        int mostFrequent = frequencyMap.entrySet()
            .stream()
            .max(Map.Entry.comparingByValue())
            .get()
            .getKey();

```

# Transform

|From|To|Code|
|----|----|----|
|double|int|`int intValue = (int) doubleValue;`|
|String|int|`int number = Integer.parseInt(numberStr);`|

## Matrx to List

```java
    List<Integer> numbers = A.stream()
                            .flatMap(List::stream)  
                            .collect(Collectors.toList());

```

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
|子串|`str.substring(start , end);` |endPosition=str.length() by default|
|取数|`str.indexOf(charValue);`||
|取字|`str.charAt(index);` |not `getChar`|
|Discompose|`str.toCharArray()`|

## SubString
```java
    str.substring( startPosition, endPosition );
```

```java
    if (subString.contains(String.valueOf(c))) { // Check if subString contains the character c
        subString = String.valueOf(c); // Assign the character to subString
        result++; // Increment the result counter
    }
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


# LOOP

## FOR

for define more than one iteators

```java
    for(int i=0, j=0; i<m && j<n ; i++){

    }
```

char in String
```java
        for(char c: s.toCharArray())｛
        
        }
```

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

# LinkedList
## REVERSE
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

## isPail

`right!=null || fast!=null`, or NullPointerException Warning.

# ASCII

There are extended ASCII tables (often referred to as ISO-8859-1 or other code pages) that extend this to **256** characters (values 0 to 255), but the standard ASCII table itself is limited to **128** values.

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