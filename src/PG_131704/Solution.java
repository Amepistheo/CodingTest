// 131704번 택배상자
package PG_131704;

import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int i = order.length; i > 0; i--) {
            s1.push(i);
        }

        for (int num : order) {
            if (!s2.isEmpty() && s2.peek() == num) {
                s2.pop();
                answer++;
                continue;
            }

            while (!s1.isEmpty() && s1.peek() != num) {
                s2.push(s1.pop());
            }

            if (!s1.isEmpty() && s1.peek() == num) {
                s1.pop();
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}