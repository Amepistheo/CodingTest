// 2110번 공유기 설치
package BOJ_2110;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        // 가능한 최소 간격
        int low = 1;
        // 입력받은 집들의 최대 간격
        int high = home[N-1];

        while (low <= high) {
            int mid = (low + high) / 2;

            // 공유기 설치 위치 (처음부터 시작)
            int pos = 0;
            // 설치 가능한 공유기 수
            int count = 1;

            // 현재 탐색하는 집의 위치와 직전에 공유기를 설치한 집의 위치 사이의 거리가
            // 최소거리(mid)보다 크거나 같을 때 공유기의 설치 개수 늘려주고
            // 마지막 설치 위치 갱신
            for (int i = 1; i < N; i++) {
                if ((home[i] - home[pos]) >= mid) {
                    pos = i;
                    count++;
                }
            }

            // 설치된 공유기의 수 < 가지고 있는 공유기의 수
            // Upper Bound 내림 -> 최소거리 줄임
            if (count < C) {
                high = mid - 1;
            }
            // 설치된 공유기의 수 >= 가지고 있는 공유기의 수
            // Lower Bound 올림 -> 최소거리 늘림
            else {
                low = mid + 1;
            }
        }

        // Upper Bound는 탐색 값을 초과하는 첫번째 값 가리키므로
        // 1을 빼준 값이 조건을 만족하는 최댓값
        System.out.println(low - 1);
    }
}