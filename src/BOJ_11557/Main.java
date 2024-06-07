// 11557번 Yangjojang of The Year
package BOJ_11557;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, Long> map = new HashMap<>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                map.put(st.nextToken(), Long.parseLong(st.nextToken()));
            }

            List<String> keySet = new ArrayList<>(map.keySet());

            Collections.sort(keySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));

            sb.append(keySet.get(0)).append("\n");
        }

        System.out.print(sb);
    }
}