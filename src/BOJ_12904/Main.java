// 12904번 A와 B
package BOJ_12904;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<String> q = new LinkedList<>();

        String S = br.readLine();
        String T = br.readLine();

        q.offer(T);

        int answer = 0;

        while (true) {
            String str = q.poll();

            if (str.equals(S)) {
                answer = 1;
                break;
            }

            if (str.length() < S.length()) {
                break;
            }

            char c = str.charAt(str.length() - 1);

            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.deleteCharAt(str.length() - 1);

            if (c == 'B') {
                sb.reverse();
            }

            q.offer(String.valueOf(sb));
        }

        System.out.println(answer);
    }
}