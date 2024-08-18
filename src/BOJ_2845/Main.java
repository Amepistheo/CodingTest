// 2845번 파티가 끝나고 난 뒤
package BOJ_2845;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int total = L * P;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            int participant = Integer.parseInt(st.nextToken());
            sb.append(participant - total).append(" ");
        }

        System.out.println(sb);
    }
}