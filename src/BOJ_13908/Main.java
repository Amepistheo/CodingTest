// 13908번 비밀번호
package BOJ_13908;

import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int total;

    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisit = new boolean[10];

        if (m > 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                isVisit[Integer.parseInt(st.nextToken())] = true;
            }
        }

        backTracking(0, 0);

        System.out.println(total);
    }

    private static void backTracking(int index, int count) {
        if (index == n) {
            if (count == m) {
                total++;
            }

            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (isVisit[i]) {
                isVisit[i] = false;
                backTracking(index + 1, count + 1);
                isVisit[i] = true;
            } else {
                backTracking(index + 1, count);
            }
        }
    }
}