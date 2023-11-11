// 10430번 나머지
package BOJ_10430;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        sb.append((A+B) % C).append("\n");
        sb.append(((A%C) + (B%C)) % C).append("\n");
        sb.append((A*B) % C).append("\n");
        sb.append(((A%C) * (B%C)) % C).append("\n");

        System.out.print(sb);
    }
}