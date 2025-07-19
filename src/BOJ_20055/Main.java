// 20055번 컨베이어 벨트 위의 로봇
package BOJ_20055;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] belt = new int[2 * N];
        boolean[] robot = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int level = 0;

        while (true) {
            level++;

            int tmp = belt[2 * N - 1];

            for (int i = 2 * N - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }

            belt[0] = tmp;

            for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }

            robot[0] = false;
            robot[N - 1] = false;

            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i - 1] = false;
                    robot[i] = true;
                    belt[i]--;
                    robot[N - 1] = false;
                }
            }

            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
            }

            int count = 0;

            for (int i = 0; i < 2 * N; i++) {
                if (belt[i] == 0) {
                    count++;
                }
            }

            if (count >= K) {
                break;
            }
        }

        System.out.println(level);
    }
}