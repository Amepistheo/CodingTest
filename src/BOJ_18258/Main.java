// 18258번 큐 2
package BOJ_18258;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            String first = st.nextToken();

            if (first.equals("push")) {
                int second = Integer.parseInt(st.nextToken());

                q.offer(second);
            }

            else if (first.equals("pop")) {
                if (q.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(q.poll()).append("\n");
            }

            else if (first.equals("size"))
                sb.append(q.size()).append("\n");

            else if (first.equals("empty")) {
                if (q.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }

            else if (first.equals("front")) {
                if (q.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(q.peek()).append("\n");
            }

            else if (first.equals("back")) {
                if (q.isEmpty())
                    sb.append(-1).append("\n");
                else
                    sb.append(q.peekLast()).append("\n");
            }
        }

        System.out.print(sb);
    }
}