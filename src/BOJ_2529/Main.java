// 2529번 부등호
package BOJ_2529;

import java.io.*;
import java.util.*;

public class Main {

    private static int k;
    private static String min = "9999999999";
    private static String max = "-1";

    private static String[] arr;
    private static int[] num;
    private static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());

        arr = new String[k];
        num = new int[k + 1];
        isVisit = new boolean[10];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        for (int i = 0; i < 10; i++) {
            num[0] = i;

            isVisit[i] = true;
            backTracking(1);
            isVisit[i] = false;
        }

        sb.append(max).append("\n").append(min);

        System.out.println(sb);
    }

    private static void backTracking(int count) {
        if (count == k + 1) {
             String s = "";

             for (int i = 0; i <= k; i++) {
                 s += num[i];
             }

             if (s.compareTo(min) < 0) {
                 min = s;
             }

             if (s.compareTo(max) > 0) {
                 max = s;
             }

             return;
        }

        for (int i = 0; i < 10; i++) {
            if (isVisit[i]) {
                continue;
            }

            if (arr[count - 1].equals("<")) {
                if (num[count - 1] < i) {
                    isVisit[i] = true;
                    num[count] = i;
                    backTracking(count + 1);
                    isVisit[i] = false;
                }
            } else {
                if (num[count - 1] > i) {
                    isVisit[i] = true;
                    num[count] = i;
                    backTracking(count + 1);
                    isVisit[i] = false;
                }
            }
        }
    }
}