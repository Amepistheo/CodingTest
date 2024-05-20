// 20115번 에너지 드링크
package BOJ_20115;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] drink = new Integer[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(drink, Collections.reverseOrder());

        double sum = drink[0];

        for (int i = 1; i < N; i++) {
            sum += ((double) drink[i] / 2);
        }

        System.out.println(sum);
    }
}