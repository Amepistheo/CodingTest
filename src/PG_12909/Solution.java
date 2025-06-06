// 12909번 올바른 괄호
package PG_12909;

import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();

        for (char c : str) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}