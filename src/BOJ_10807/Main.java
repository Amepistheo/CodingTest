// 10807번 개수 세기
package BOJ_10807;

import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;
    private static int N, v;

    public static void main(String[] args) throws IOException {
        firstSetting();
        solveProblem();
    }

    private static void firstSetting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        v = Integer.parseInt(br.readLine());
    }

    private static void solveProblem() {
        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == v) {
                count++;
            }
        }

        System.out.println(count);
    }
}