// 131128번 숫자 짝꿍
package PG_131128;

import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        String answer = "";

        int[] cntX = new int[10];
        int[] cntY = new int[10];

        for (char c : X.toCharArray()) {
            cntX[c - '0']++;
        }

        for (char c : Y.toCharArray()) {
            cntY[c - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            int count = Math.min(cntX[i], cntY[i]);

            while (count-- > 0) {
                sb.append(i);
            }
        }

        if (sb.isEmpty()) {
            answer = "-1";
        } else if (sb.charAt(0) == '0') {
            answer = "0";
        } else {
            answer = sb.toString();
        }

        return answer;
    }
}