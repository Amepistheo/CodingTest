// 9375번 패션왕 신해빈
package BOJ_9375;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());            // 테스트 케이스의 수

        for (int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());        // 의상의 수

            Map<String, Integer> map = new HashMap<>();     //테스트 케이스별로 Map 초기화 해줘야함

            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken();                             // 의상의 이름은 필요 X
                String key = st.nextToken();                // 의상의 종류 (키)

                // 의상의 종류를 기준으로 값이 있으면 value + 1 해주고 아니라면 1 넣어줌
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int total = 1;

            // (각각의 value의 값 + 1) 한 값들을 곱한 경우에서 알몸인 상태 -1 해준 값이 결과
            for (int j : map.values()) {
                total *= (j + 1);
            }

            sb.append(total - 1).append("\n");
        }

        System.out.print(sb);
    }
}
