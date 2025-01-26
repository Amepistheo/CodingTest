// 132265번 롤케이크 자르기
package PG_132265;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        int answer = 0;

        for (int num : topping) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        for (int num : topping) {
            int n = map1.get(num) - 1;

            if (n <= 0) {
                map1.remove(num);
            } else {
                map1.put(num, n);
            }

            map2.put(num, map2.getOrDefault(num, 0) + 1);

            if (map1.size() == map2.size()) {
                answer++;
            }
        }

        return answer;
    }
}