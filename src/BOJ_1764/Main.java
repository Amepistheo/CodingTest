// 1764번 듣보잡
package BOJ_1764;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, Integer> map = new HashMap<>();
        List<String> l = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());               // 듣도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());               // 보도 못한 사람의 수

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        // HashMap에 name을 key로, 횟수를 value로 설정
        for (int i = 0; i < M; i++){
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);

            if (map.get(name) == 2)
              l.add(name);
        }

        Collections.sort(l);

        sb.append(l.size()).append("\n");

        for (int i = 0; i < l.size(); i++) {
            sb.append(l.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
