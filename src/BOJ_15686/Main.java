// 15686번 치킨 배달
package BOJ_15686;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int result = Integer.MAX_VALUE;

    static int[][] city;
    static boolean[] isOpen;

    static List<Node> home = new ArrayList<>();
    static List<Node> chicken = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    home.add(new Node(i, j));
                } else if (city[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        isOpen = new boolean[chicken.size()];
        search(0, 0);

        System.out.println(result);
    }

    private static void search(int start, int count) {
        if (count == M) {
            int sum = 0;

            for (Node h : home) {
                int min = Integer.MAX_VALUE;

                for (int i = 0; i < chicken.size(); i++) {
                    if (isOpen[i]) {
                        int dist = Math.abs(h.x - chicken.get(i).x) + Math.abs(h.y - chicken.get(i).y);
                        min = Math.min(min, dist);
                    }
                }

                sum += min;
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            isOpen[i] = true;
            search(i + 1, count + 1);
            isOpen[i] = false;
        }
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}