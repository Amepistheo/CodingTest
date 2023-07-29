// 10871번 X보다 작은 수
package BOJ_10871;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input < X)
                sb.append(input).append(" ");
        }

        System.out.print(sb);
    }
}