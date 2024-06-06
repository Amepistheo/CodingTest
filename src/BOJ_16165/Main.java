// 16165번 걸그룹 마스터 준석이
package BOJ_16165;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, List<String>> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int t = 0; t < N; t++) {
            String team = br.readLine();
            int num = Integer.parseInt(br.readLine());

            List<String> list = new ArrayList<>();

            for (int i = 0; i < num; i++) {
                list.add(br.readLine());
            }

            map.put(team, list);
        }

        for (int t = 0; t < M; t++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 1) {
                for (String group : map.keySet()) {
                    if (map.get(group).contains(name)) {
                        sb.append(group).append("\n");
                        break;
                    }
                }
            }
            else {
                List<String> list = map.get(name);
                Collections.sort(list);

                for (String member : list) {
                    sb.append(member).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}