// 20364번 부동산 다툼
package BOJ_20364;

import java.io.*;
import java.util.*;

public class Main {

    private static int N, Q;
    private static int[] land;
    private static int[] duck;

    public static void main(String[] args) throws IOException {
        firstSetting();
        solveProblem();
    }

    private static void firstSetting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        land = new int[N + 1];
        duck = new int[Q];

        Arrays.fill(land, -1);

        for (int i = 0; i < Q; i++) {
            duck[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solveProblem() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            int originalIndex = duck[i];
            int targetIndex = originalIndex;
            int firstLand = 0;

            while (targetIndex >= 1) {
                // 만약 누가 점유한 땅이라면 점유된 땅의 번호 저장
                if (land[targetIndex] != -1) {
                    firstLand = targetIndex;
                }

                // targetIndex를 부모로 이동
                if ((targetIndex % 2) == 1) {
                    targetIndex = (targetIndex - 1) / 2;
                } else {
                    targetIndex /= 2;
                }
            }

            // 원하는 땅을 점유할 수 없는 경우
            if (firstLand != 0) {
                sb.append(firstLand).append("\n");
            } else {    // 원하는 땅을 점유할 수 있을 경우 -> 점유하는 땅을 1로 변경하여 뒤에 있는 오리가 점유할 수 없게 함
                land[originalIndex] = 1;
                sb.append('0').append("\n");
            }
        }

        System.out.print(sb);
    }
}