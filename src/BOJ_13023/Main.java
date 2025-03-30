// 13023번 ABCDE
package BOJ_13023;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> friend = new ArrayList<>();
    private static boolean[] isVisit;

    private static int N, M;
    private static boolean isExist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            friend.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friend.get(a).add(b);
            friend.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            if (isExist) {
                break;
            }

            isVisit = new boolean[N];
            isVisit[i] = true;

            dfs(i, 1);
        }

        if (isExist) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int person, int depth) {
        if (depth == 5) {
            isExist = true;
            return;
        }

        for (int current : friend.get(person)) {
            if (isVisit[current]) {
                continue;
            }

            isVisit[current] = true;
            dfs(current, depth + 1);
            isVisit[current] = false;
        }
    }
}