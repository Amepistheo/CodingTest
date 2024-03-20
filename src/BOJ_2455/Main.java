// 2455번 지능형 기차
package BOJ_2455;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int people = 0;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            int minus = Integer.parseInt(st.nextToken());
            int plus = Integer.parseInt(st.nextToken());

            people = people - minus + plus;
            max = Math.max(max, people);
        }

        System.out.println(max);
    }
}