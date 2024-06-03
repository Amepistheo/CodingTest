// 20291번 파일 정리
package BOJ_20291;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine().split("\\.")[1];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet);

        for (String key : keySet) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }

        System.out.print(sb);
    }
}