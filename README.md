- [Terminology](#terminology)
- [Math](#math)
  - [BIT OPERATION](#bit-operation)
- [Complexity](#complexity)
- [Structure](#structure)
  - [ARRAY](#array)
  - [Grid](#grid)
  - [STRING](#string)
  - [HASHSET, HASHMAP](#hashset-hashmap)
  - [TREEMAP TREESET](#treemap-treeset)
  - [HEAP](#heap)
  - [STACK](#stack)
  - [MAP](#map)
  - [QUEUE](#queue)
    - [用数组实现Queue](#用数组实现queue)
    - [Deque](#deque)
- [Comparator](#comparator)
- [Init](#init)
  - [LIST](#list)
    - [Java 8](#java-8)
    - [Java 15](#java-15)
- [MinMax](#minmax)
    - [BigInteger](#biginteger)
- [SUM](#sum)
  - [Sum of the List](#sum-of-the-list)
    - [Java 8](#java-8-1)
    - [Java 15](#java-15-1)
- [Stream](#stream)
  - [MAP](#map-1)
- [Transform](#transform)
  - [Matrx to List](#matrx-to-list)
  - [Map to List](#map-to-list)
  - [Integer to str](#integer-to-str)
    - [TimeFormat](#timeformat)
- [LOOP](#loop)
  - [FOR](#for)
- [Sort](#sort)
  - [MID](#mid)
  - [SWAP](#swap)
    - [REVERSE](#reverse)
- [LinkedList](#linkedlist)
  - [REVERSE](#reverse-1)
  - [isPail](#ispail)
- [ASCII](#ascii)
- [葵花宝典](#葵花宝典)
  - [1. 链表](#1-链表)
    - [入环](#入环)
    - [相交](#相交)
    - [Palindrome](#palindrome)



# Terminology
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
|Permutation|排列|
|----|----|----|
|Divide and conquer|分而治之|
|Subarray|Must be a **continuous (contiguous)** part of an array|

Two-dimensional dynamic programming from recursion

# Math

|Sign|Math||
|:---:|:---:|:----:|
|Greatest Common Divisor|最大公约数|`gcd(a,b){return b==0 ? a : gcd(b, a%b)}`, **a>b**|
|Least Common Multiple|最小公倍数|`(a/gcd)*b`|
|Divisible by either `a` or `b`|除或|`m/a + m/b - m/lcm`|
|exponent|指数|
|recursive|递归|
|adjacent|邻接|
|exponent|指数|`Math.pow(2, 3) == 8`|
|square|开方|`Math.sqrt(16) == 4`|
|factorial|阶乘 |
|diagonal|对角线|
|` modulus`|取余|`%`|
|The `k`th Factor of n| `k` 因数 / 因子|
|evenly divide|整除||
|-|-|-|
|parity|奇偶||
|even|偶数||
|odd|奇数||
|denominator|分母||
|perimeter|周长||

||||
|---|---|---|
|向上取整|`Math.ceil((double) n / m)`|`(n + m - 1) / m`|
|向下取整|`Math.floor((double) n / m)`||


```java

Math.floor() <= i <= Math.ceil();
```

## BIT OPERATION
|MATH||BIT||
|---|---|---|---|
|`y % 2 != 0`|odd|`(y & 1) == 1`||
|`y = y / 2;`|divide 2|`y >>= 1`||
|`l + (r-l)/2`|mid|`l+((r−l)>>>1)`|take account for overflow|

# Complexity
|Sign|Complexity||
|---|---|----|
|`Arrays.sort(int[] nums)`|`O(nlog(n))`|Dual-Pivot Quicksort algorithm|
|`Arrays.binarySearch(int[], int)`|`O(logn)`| If num not exists, the value returned is `-(insertion point) - 1`|
|`Collections.sort(List<Integer> list)`|`O(n log(n))`|Timsort algorithm|


# Structure

|Structure|-|Rule||
|----|----|----|----|
|Queue|队列|First In, First Out||
|Stack|栈|First In, Last Out||
|LinkedList|链表||
|Binary Tree|二叉树||


## ARRAY

|||
|----|----|
|`Arrays.asList()`|
|`Arrays.sort()`|按字典序小排序, `Arrays.sort(strs, (a,b)->(a+b).compareTo(b+a))`|
|`Arrays.fill()`|
|`Arrays.stream(nums).sum()`|`int[] num`|
|`Collections.sort(arr)`|`List<Integer> arr`|
|`Collections.sort(arr, Collections.reverseOrder());`|
|`Arrays.copyOfRange(nums, l, r)`|Subarray, indices l and r - 1|
|`Arrays.binarySearch(num, target)`|If not exists, return `-(insertion point) - 1`|

## Grid

0: Up
1: Right
2: Down
3: Left

```java
    int[] move = new int[] {-1, 0, 1, 0, -1};

    x+move[i] 
    y+move[i+1]
```


## STRING

|Operations|String|
|---|----|
|`str.substring(start , end);` |endPosition=str.length() by default|
|`str == null` || `str.isEmpty()`|
|`str.contains(string)`||
|`str.indexOf(char);`| does not exist return -1|
|`str.charAt(index);` ||
|`str.toCharArray()`|`String.valueOf(char)`|
|`str1.equals(str2)`||
|**`str1.compareTo(str2)`**|"11:00".compareTo("14:00") == -3|
|字典序|"abc".compareTo("b") == -1|

||`str = null`|`str = ""`|
|---|---|---|
|Memory|No memory is allocated|Memory is allocated for an empty string|
|`str.length()`| throws **NullPointerException**|return `0`|
|`str.isEmpty()`|throws **NullPointerException**|return `true`|

```java
String str1 = new String("Hello");
String str2 = new String("Hello");
```
|`str1==str2`|`str1.equals(str2)`|
|:---:|:---:|
|false|true|

## HASHSET, HASHMAP

> HashMap和HashSet，增删改查, O(1)，但是大常数

**Java中通过自定义hashCode、equals等方法
任何类都可以实现“根据值做key”或者“根据内存地址做key”的需求**

## TREEMAP TREESET
有序表, ordered list

> TreeSet和TreeMap原理一样，有无伴随数据的区别
> 增删改查, O(logN)

|Opeartion|TreeMap|
|---|----|
|`TreeMap<Integer, String> treeMap = new TreeMap<>()`||
|`treeMap.getOrDefault(key, 0)`||
|`treeMap.containsKey(key)`|not exists return null|
|`treeMap.firstKey()`||
|`treeMap.lastsKey()`||
|`treeMap.floorKey(4)`|return cloest <=4|
|`treeMap.ceilingKey(4)`|return cloest >=4|

|Opeartion|TreeSet|
|---|----|
|`TreeSet<Integer, String> treeSet = new TreeSet<>()`||
|`treeSet.pollFirst()`|1,2,3,4|
|`treeSet.pollLast()`|4,3,2,1|

## HEAP
|Opeartion|Heap|
|---|----|
|`Queue<Integer> heap = new PriorityQueue<>()`|默认小根堆, min-heap, Elements will be ordered in ascending|
|`heap.size()`||
|`heap.poll()`||


## STACK

|Opeartion|Stack|
|---|----|
|`Stack<Integer> stack = new Stack<>()`||
|`stack.contains()`||
|`stack.isEmpty()`|空|
|`stack.push(num)`|`stack.add(num)`|
|`stack.peek()`|Retrieve the top element of the stack WITHOUT removing it|
|`stack.pop()`|Retrieve the top element of the stack and REMOVE it|
|`stack.get(index)`||

>  `push()` is used specifically with stacks, ensuring that the LIFO order is respected. `add()` is a more general method that can be used with various types of collections.

## MAP
|Opeartion|Map|
|---|----|
|`Map<Integer, Integer> map = new HashMap<>()`||
|`put(K key, V value)`||
|`get(Object key)`||
|`remove(Object key)`||
|`size()`||
|`isEmpty()`||
|`containsKey(Object key)`||
|`containsValue(Object value)`||


## QUEUE

|Opeartion|Queue|
|---|----|
|`Queue<Integer> queue = new LinkedList<Integer>()`||
|`Queue<Integer> queue = new PriorityQueue<>()`|Elements will be ordered in ascending|
|`queue.offer(num)`||
|`queue.peek()`||
|`queue.poll()`||
|`queue.isEmpty()`||

### 用数组实现Queue

|||
|---|---|
|[l, r)|`int[] queue`|
|isEmpty()|`return l==r`|
|add(num)|`queue[r++] == num`|
|poll|`return queue[l++]`|
|head()|`return queue[l]`|
|tail()|`return queue[r-1]`|

### Deque

```java
  public Deque<Integer> deque = new LinkedList<>();

  deque.offerFirst();
  deque.offerLast();
```

# Comparator

`compare(Object o1, Object o2)`
返回负数默认 o1 小
返回正数默认 o2 小

```java
// return in an ascending order
// 字典序从小到大
Arrays.sort(strs, (a,b)->(a+b).comparesTo(b+a)); 

// 年龄较大的往前排
Arrays.sort(arr, (a,b) -> b.age -a.age); 

// 公司编号小的先来，年纪大的先来
Arrays.sort(arr, (a,b) -> (a.company!=b.company) ? a.comapny-b.company : b.age-a.age);
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

 

```


# MinMax

|Symbol|Value|
|----|----|
|`Integer.MAX_VALUE`||
|`Integer.MIN_VALUE`|-2,147,483,648|
|`Integer.ONE`|1|
|----|----|
|`BigInteger.ONE`||
|`BigInteger.valueOf(Integer.MAX_VALUE)`||

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
# SUM


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






# Stream

## MAP

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


```java
    int mid=l+((r-l)>>1);
```

If you use `l+(r-l)>>1`, you will get WRONG answer

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