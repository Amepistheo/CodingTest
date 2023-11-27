// 8979번 올림픽
package BOJ_8979;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] score = new int[N+1][5];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
            score[i][3] = Integer.parseInt(st.nextToken());
            score[i][4] = 1;
        }

        Arrays.sort(score, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        return o2[3] - o1[3];
                    }
                    return o2[2] - o1[2];
                }
                else {
                    return o2[1] - o1[1];
                }
            }
        });

        for (int i=0; i<N-1; i++) {
            if ((score[i][1] == score[i+1][1]) && (score[i][2] == score[i+1][2]) && (score[i][3] == score[i+1][3])) {
                score[i+1][4] = score[i][4];
            }
            else {
                score[i+1][4] = i+2;
            }
        }

        for (int i=0; i<N; i++) {
            if (score[i][0] == K) {
                System.out.println(score[i][4]);
                break;
            }
        }
    }
}