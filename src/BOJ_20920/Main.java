// 20920번 영단어 암기는 괴로워
package BOJ_20920;

import java.io.*;
import java.util.*;

public class Main {

    private static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        firstSetting();
        solveProblem();
    }

    private static void firstSetting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            if (word.length() < M) {
                continue;
            }

            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    private static void solveProblem() {
        StringBuilder sb = new StringBuilder();

        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet, (o1, o2) -> {
            if ((int) map.get(o1) != map.get(o2)) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }

            return o1.compareTo(o2);
        });

        for (String s : keySet) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}