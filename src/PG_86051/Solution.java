// 86051번 없는 숫자 더하기
package PG_86051;

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(i, 1);
        }

        for (int n : numbers) {
            map.remove(n);
        }

        for (int num : map.keySet()) {
            answer += num;
        }

        return answer;
    }
}