// 1181번 단어 정렬
package BOJ_1181;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] word = new String[N];

        for (int i=0; i<N; i++) {
            word[i] = br.readLine();
        }

        // 길이가 짧은 것 부터 / 길이가 같으면 사전 순으로
        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }

                return o1.length() - o2.length();
            }
        });

        sb.append(word[0]).append('\n');

        // 중복된 단어는 하나 남기고 제거
        for (int i=1; i<N; i++) {
            if (!word[i].equals(word[i-1]))
                sb.append(word[i]).append("\n");
        }

        System.out.print(sb);
    }
}
