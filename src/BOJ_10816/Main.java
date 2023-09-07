// 10816번 숫자 카드 2
package BOJ_10816;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<Long, Integer> map = new HashMap<>();

        long N = Long.parseLong(br.readLine());                     // 숫자 카드의 개수

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            long key = Long.parseLong(st.nextToken());

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long M = Long.parseLong(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<M; i++) {
            long value = map.getOrDefault(Long.parseLong(st.nextToken()), 0);

            sb.append(value).append(" ");
        }

        System.out.print(sb);
    }
}