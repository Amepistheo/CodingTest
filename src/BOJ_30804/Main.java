// 30804번 과일 탕후루
package BOJ_30804;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] fruit = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            map.put(fruit[right], map.getOrDefault(fruit[right], 0) + 1);

            while (map.size() > 2) {
                map.put(fruit[left], map.get(fruit[left]) - 1);

                if (map.get(fruit[left]) == 0) {
                    map.remove(fruit[left]);
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}