// 4358번 생태학
package BOJ_4358;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        int count = 0;

        while (true) {
            String tree = br.readLine();

            if (tree == null || tree.isEmpty()) {
                break;
            }

            map.put(tree, map.getOrDefault(tree, 0) + 1);
            count++;
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        for (String key : list) {
            double frequency = (map.get(key) / (double) count) * 100;

            sb.append(key).append(" ").append(String.format("%2.4f", frequency)).append("\n");
        }

        System.out.print(sb);
    }
}