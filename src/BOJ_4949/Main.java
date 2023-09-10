// 4949번 균형잡힌 세상
package BOJ_4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Stack<Character> stack = new Stack<>();
            boolean flag = true;                    // 탐색 중간이 멈췄는지 아닌지 판단하는 변수

            String input = br.readLine();

            // 종료 조건
            if (input.equals("."))
                break;

            for (int i=0; i<input.length(); i++) {
                char c = input.charAt(i);

                if (c == '(' || c == '[')
                    stack.push(c);
                else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    else if (stack.peek() == '(')
                        stack.pop();
                }
                else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    else if (stack.peek() == '[')
                        stack.pop();
                }
            }

            if (stack.isEmpty() && flag)
                sb.append("yes").append("\n");
            else
                sb.append("no").append("\n");
        }

        System.out.print(sb);
    }
}