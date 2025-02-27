// 2504번 괄호의 값
package BOJ_2504;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> stack = new Stack<>();
        String[] str = br.readLine().split("");

        int total = 0;
        int sum = 1;

        for (int i = 0; i < str.length; i++) {
            String s = str[i];

            if (s.equals("(")) {
                stack.add(s);
                sum *= 2;
            } else if (s.equals("[")) {
                stack.add(s);
                sum *= 3;
            } else if (s.equals(")")) {
                if (stack.isEmpty() || !stack.peek().equals("(")) {
                    total = 0;
                    break;
                } else if (str[i - 1].equals("(")) {
                    total += sum;
                }

                stack.pop();
                sum /= 2;
            } else if (s.equals("]")) {
                if (stack.isEmpty() || !stack.peek().equals("[")) {
                    total = 0;
                    break;
                } else if (str[i - 1].equals("[")) {
                    total += sum;
                }

                stack.pop();
                sum /= 3;
            }
        }

        if (!stack.isEmpty()) {
            total = 0;
        }

        System.out.println(total);
    }
}