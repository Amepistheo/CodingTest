// 12931번 자릿수 더하기
package PG_12931;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String[] str = String.valueOf(n).split("");

        for (String s : str) {
            answer += Integer.parseInt(s);
        }

        return answer;
    }
}