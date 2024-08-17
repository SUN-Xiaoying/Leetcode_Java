package sliding;

public class MinWindowSubString {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m<n){
            return "";
        }

        int[] ledger = new int[256];
        int minSize = Integer.MAX_VALUE;

        int start = 0;
    
        for(char ch:t.toCharArray()){
            ledger[ch]--;
        }

        for(int l=0, r=0, debt=n; r<m; r++){
            if(ledger[s.charAt(r)]++ < 0){
                debt--;
            }

            //能覆盖的子串, 出现了
            if(debt==0){
                // 看看能不能尽可能小
                while(ledger[s.charAt(l)] > 0){
                    ledger[s.charAt(l++)]--;
                }
                // 重新计算最小长度
                if(minSize > r-l+1){
                    minSize = r-l+1;
                    start = l;
                }
            }
        }

        return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start+minSize);
    }
}
