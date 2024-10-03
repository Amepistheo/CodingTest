// 15828번 Router
package BOJ_15828;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int num;

        while ((num = Integer.parseInt(br.readLine())) != -1) {
            if (num == 0) {
                q.poll();
            } else if (q.size() != N) {
                q.offer(num);
            }
        }

        if (q.isEmpty()) {
            sb.append("empty");
        } else {
            while(!q.isEmpty()) {
                sb.append(q.poll()).append(" ");
            }
        }

        System.out.println(sb);
    }
}