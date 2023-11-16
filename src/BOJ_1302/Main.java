// 1302번 베스트셀러
package BOJ_1302;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;

        for (int i=0; i<N; i++) {
            String book = br.readLine();

            map.put(book, map.getOrDefault(book, 0) + 1);
            max = Math.max(max, map.get(book));
        }

        List<String> mapvalue = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                mapvalue.add(entry.getKey());
            }
        }

        Collections.sort(mapvalue);

        System.out.println(mapvalue.get(0));
    }
}