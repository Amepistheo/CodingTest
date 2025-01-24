// 76502번 괄호 회전하기
package PG_76502;

import java.util.*;

class Solution {
    public int solution(String s) {
        Queue<String> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            q.offer(String.valueOf(s.charAt(i)));
        }

        if ((q.size() % 2) != 0) {
            return 0;
        }

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<String> stack = new Stack<>();

            for (int j = 0; j < s.length(); j++) {
                String c = q.poll();

                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c.equals(")") && stack.peek().equals("(")) {
                    stack.pop();
                } else if (c.equals("}") && stack.peek().equals("{")) {
                    stack.pop();
                } else if (c.equals("]") && stack.peek().equals("[")) {
                    stack.pop();
                } else {
                    stack.push(c);
                }

                q.offer(c);
            }

            if (stack.isEmpty()) {
                answer++;
            }

            q.offer(q.poll());
        }

        return answer;
    }
}