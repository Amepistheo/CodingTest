// 42746번 가장 큰 수
package PG_42746;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (str[0].equals("0")) {
            return "0";
        }

        String answer = "";

        for (String s : str) {
            answer += s;
        }

        return answer;
    }
}