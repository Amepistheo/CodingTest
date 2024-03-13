// 28278번 스택 2
package BOJ_28278;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int com = Integer.parseInt(st.nextToken());

            if (com == 1) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if (com == 2) {
                if (stack.empty()) {
                    sb.append(-1).append('\n');
                }
                else {
                    sb.append(stack.pop()).append('\n');
                }
            }
            else if (com == 3) {
                sb.append(stack.size()).append('\n');
            }
            else if (com == 4) {
                if (stack.empty()) {
                    sb.append(1).append('\n');
                }
                else {
                    sb.append(0).append('\n');
                }
            }
            else if (com == 5) {
                if (stack.empty()) {
                    sb.append(-1).append('\n');
                }
                else {
                    sb.append(stack.peek()).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}