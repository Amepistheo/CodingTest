// 17073번 나무 위의 빗물
package BOJ_17073;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> tree = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long W = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list.get(U).add(V);
            list.get(V).add(U);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisit = new boolean[N + 1];

        q.offer(1);

        while (!q.isEmpty()) {
            int node = q.poll();

            if (isVisit[node]) {
                continue;
            }

            isVisit[node] = true;

            for (int n : list.get(node)) {
                if (isVisit[n]) {
                    continue;
                }

                tree.get(node).add(n);
                q.offer(n);
            }
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (tree.get(i).isEmpty()) {
                count++;
            }
        }

        System.out.println((double) W / count);
    }
}