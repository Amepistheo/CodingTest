// 12906번 같은 숫자는 싫어
package PG_12906;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int n : arr) {
            if (stack.isEmpty()) {
                stack.push(n);
                continue;
            }

            if (stack.peek() != n) {
                stack.push(n);
            }
        }

        int[] answer = new int[stack.size()];
        int i = stack.size() - 1;

        while (!stack.isEmpty()) {
            answer[i] = stack.pop();
            i--;
        }

        return answer;
    }
}