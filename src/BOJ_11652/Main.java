// 11652번 카드
package BOJ_11652;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        int max = 0;
        long pos = 0;

        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(br.readLine());

            map.put(card, map.getOrDefault(card, 0) + 1);

            if (map.get(card) > max) {
                max = map.get(card);
                pos = card;
            }
            else if (map.get(card) == max) {
                pos = Math.min(pos, card);
            }
        }

        System.out.println(pos);
    }
}