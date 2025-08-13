// 12933번 정수 내림차순으로 배치하기
package PG_12933;

import java.util.*;

class Solution {
    public long solution(long n) {
        String answer = "";
        String[] list = String.valueOf(n).split("");

        Arrays.sort(list, Collections.reverseOrder());

        for (String s : list) {
            answer += s;
        }

        return Long.parseLong(answer);
    }
}