// 13549번 숨바꼭질 3
package BOJ_13549;

import java.io.*;
import java.util.*;

public class Main {

    private static boolean[] visit;
    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[100001];

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(N, 0));
        visit[N] = true;

        while (!q.isEmpty()) {
            Node vertex = q.poll();

            if (vertex.index == K) {
                return vertex.time;
            }
            if (vertex.index*2 <= 100000 && !visit[vertex.index*2]) {
                q.offer(new Node(vertex.index*2, vertex.time));
                visit[vertex.index*2] = true;
            }
            if (vertex.index-1 >= 0 && !visit[vertex.index-1]) {
                q.offer(new Node(vertex.index-1, vertex.time+1));
                visit[vertex.index-1] = true;
            }
            if (vertex.index+1 <= 100000 && !visit[vertex.index+1]) {
                q.offer(new Node(vertex.index+1, vertex.time+1));
                visit[vertex.index+1] = true;
            }
        }

        return -1;
    }
}

class Node {
    int index;
    int time;

    public Node(int index, int time) {
        this.index = index;
        this.time = time;
    }
}