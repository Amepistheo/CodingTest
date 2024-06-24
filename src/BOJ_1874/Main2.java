// 1874번 스택 수열
package BOJ_1874;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        int top = 0;

        for (int i = 0; i < n; i++) {
            if (top < seq[i]) {
                for (int j = top + 1; j <= seq[i]; j++) {
                    stack.push(j);
                    sb.append('+').append("\n");
                }

                stack.pop();
                sb.append('-').append("\n");

                top = seq[i];
            }
            else {
                int peek = stack.peek();

                if (peek == seq[i]) {
                    stack.pop();
                    sb.append('-').append("\n");
                }
                else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.print(sb);
    }
}