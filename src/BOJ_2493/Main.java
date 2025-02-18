// 2493번 탑
package BOJ_2493;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stack<Node> stack = new Stack<>();
        int[] answer = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int top = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (top <= stack.peek().height) {
                    answer[i] = stack.peek().index + 1;
                    break;
                }

                stack.pop();
            }

            stack.add(new Node(i, top));
        }

        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }
}

class Node {
    int index;
    int height;

    public Node(int index, int height) {
        this.index = index;
        this.height = height;
    }
}