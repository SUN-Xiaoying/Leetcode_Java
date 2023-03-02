package klarna;

import java.util.LinkedList;
import java.util.List;

class JumpGame {
    public static List<Integer> whoIsGoingHomeEarly(int n, int k) {
        List<Integer> list = new LinkedList<Integer>();
        List<Integer> ans = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > n / 2) {
            i = (i + k - 1) % list.size();
            ans.add(list.get(i));
            list.remove(i);
        }
        System.out.println(ans);
        return ans;
    }
}