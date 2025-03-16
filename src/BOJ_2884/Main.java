// 2884번 알람 시계
package BOJ_2884;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int total = (H * 60) + M - 45;

        int newH = total / 60;
        int newM = total % 60;

        if (newM < 0) {
            newH = 23;
            newM += 60;
        }

        sb.append(newH).append(" ").append(newM);

        System.out.println(sb);
    }
}