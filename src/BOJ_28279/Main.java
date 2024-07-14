// 28279번 덱 2
package BOJ_28279;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> dq = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case (1) :
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case (2) :
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case (3) :
                    if (!dq.isEmpty()) {
                        sb.append(dq.pop());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case (4) :
                    if (!dq.isEmpty()) {
                        sb.append(dq.pollLast());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case (5) :
                    sb.append(dq.size()).append("\n");
                    break;
                case (6) :
                    if (!dq.isEmpty()) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                    sb.append("\n");
                    break;
                case (7) :
                    if (!dq.isEmpty()) {
                        sb.append(dq.peek());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
                case (8) :
                    if (!dq.isEmpty()) {
                        sb.append(dq.peekLast());
                    } else {
                        sb.append(-1);
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}