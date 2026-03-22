// 5430번 AC
package BOJ_5430;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] p = br.readLine().split("");

            int n = Integer.parseInt(br.readLine());

            boolean isExist = false;

            if (n == 0) {
                String tmp = br.readLine();

                for (int i = 0; i < p.length; i++) {
                    if (p[i].equals("D")) {
                        isExist = true;
                        break;
                    }
                }

                if (isExist) {
                    sb.append("error").append("\n");
                } else {
                    sb.append(tmp).append("\n");
                }

                continue;
            }

            String[] list = br.readLine().replaceAll("[\\[\\]]", "").split(",");

            Deque<Integer> q = new LinkedList<>();

            for (int i = 0; i < list.length; i++) {
                q.offer(Integer.parseInt(list[i]));
            }

            boolean isLeft = true;
            boolean isError = false;

            for (int i = 0; i < p.length; i++) {
                if (p[i].equals("R")) {
                    isLeft = !isLeft;
                } else {
                    if (q.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (isLeft) {
                        q.pollFirst();
                    } else {
                        q.pollLast();
                    }
                }
            }

            if (isError) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");

                while (!q.isEmpty()) {
                    if (isLeft) {
                        sb.append(q.pollFirst()).append(",");
                    } else {
                        sb.append(q.pollLast()).append(",");
                    }
                }

                if (sb.charAt(sb.length() - 1) != '[') {
                    sb.deleteCharAt(sb.length() - 1);
                }

                sb.append("]").append("\n");
            }
        }

        System.out.print(sb);
    }
}