// 16435번 스네이크버드
package BOJ_16435;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] fruit = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fruit);

        for (int i = 0; i < N; i++) {
            if (fruit[i] <= L) {
                L++;
            }
        }

        System.out.println(L);
    }
}