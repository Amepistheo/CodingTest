// 7568번 덩치
package BOJ_7568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] body = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            body[i][0] = Integer.parseInt(st.nextToken());
            body[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            int count = 1;

            for (int j=0; j<N; j++) {
                if (i==j)
                    continue;

                // 키와 몸무게가 모두 작을 때만 덩치 등수 증가
                if ((body[i][0]<body[j][0]) && (body[i][1]<body[j][1]))
                    count++;
            }

            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }
}