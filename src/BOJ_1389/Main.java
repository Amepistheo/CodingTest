// 1389번 케빈 베이컨의 6단계 법칙
package BOJ_1389;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int result;
    static int min = Integer.MAX_VALUE;

    static int[][] map;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());               // 유저의 수
        M = Integer.parseInt(st.nextToken());               // 친구 관계의 수

        map = new int[N+1][N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;
        }

        for (int i=1; i<=N; i++) {
            isVisit = new boolean[N+1];
            bfs(i);
        }

        System.out.println(result);
    }

    public static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();

        int count = 0;

        q.offer(new Node(start, 0));
        isVisit[start] = true;

        while(!q.isEmpty()) {
            Node vertex = q.poll();
            count += vertex.value;

            for (int i=1; i<=N; i++) {
                int num = map[vertex.num][i];

                if (num == 1 && !isVisit[i]) {
                    q.offer(new Node(i, vertex.value + 1));
                    isVisit[i] = true;
                }
            }
        }

        if (count < min) {
            min = count;
            result = start;
        }
    }
}

class Node {
    int num, value;

    public Node(int num, int value) {
        this.num = num;
        this.value = value;
    }
}
