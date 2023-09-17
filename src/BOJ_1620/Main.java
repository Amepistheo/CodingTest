// 1620번 나는야 포켓몬 마스터 이다솜
package BOJ_1620;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());                                   // 포켓몬의 개수
        int M = Integer.parseInt(st.nextToken());                                   // 문제의 개수

        for (int i=1; i<=N; i++) {
            String name = br.readLine();

            map1.put(i, name);                                                      // 번호 : key, 포켓몬 : value
            map2.put(name, i);                                                      // 포켓몬 : key, 번호 : value
        }

        for (int i=0; i<M; i++) {
            String question = br.readLine();

            if (question.charAt(0)>=49 && question.charAt(0)<=57)                   // 입력값이 숫자인 경우
                sb.append(map1.get(Integer.parseInt(question))).append("\n");
            else                                                                    // 입력값이 문자인 경우 value값으로 key를 가져옴
                sb.append(map2.get(question)).append("\n");
        }

        System.out.print(sb);
    }
}