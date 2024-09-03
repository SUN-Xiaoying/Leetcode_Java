package sliding;

import java.util.*;

public class LongestSubstrWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        char[] charList = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int size=0;
        for(int right=0, left=0; right<charList.length; right++ ){
            char ch= charList[right];
            if(map.containsKey(ch)){
                left = Math.max(left,  map.get(ch)+1);
            } 
            map.put(ch, right);
            size = Math.max(size, right-left+1);
        }
        return size;
    }
    
}
