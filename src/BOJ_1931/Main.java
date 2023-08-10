// 1931번 회의실 배정
package BOJ_1931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());                    // 회의의 수
        int[][] meeting = new int[N][2];

        // 회의의 정보 입력
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의 종료 시간 기준으로 오름차순 정렬 (단 종료시간 같을 시 시작시간 오름차순 정렬)
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];

                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int finish = 0;

        // 이전 회의 종료시간보다 현재 회의 시작시간이 크거나 같은 경우 갱신
        for (int i=0; i<N; i++) {
            if (finish <= meeting[i][0]) {
                finish = meeting[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}