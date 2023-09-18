// 1546번 평균
package BOJ_1546;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Integer[] score = new Integer[N];

        st = new StringTokenizer(br.readLine());

        double sum = 0;

        for (int i=0; i<N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            sum += score[i];
        }

        Arrays.sort(score, Collections.reverseOrder());

        System.out.println(((sum/score[0])*100)/N);
    }
}