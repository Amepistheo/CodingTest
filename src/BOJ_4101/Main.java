// 4101번 크냐?
package BOJ_4101;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (first == 0 && second == 0) {
                break;
            }

            if (first > second) {
                sb.append("Yes").append("\n");
            }
            else {
                sb.append("No").append("\n");
            }
        }

        System.out.print(sb);
    }
}