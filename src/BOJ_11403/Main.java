// 11403번 경로 찾기
package BOJ_11403;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드 와샬 문제 (모든 정점에서 모든 정점으로의 최단 경로 구하기, 거쳐가는 정점 고려)
        for (int k=0; k<N; k++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1)
                        map[i][j] = 1;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(map[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}