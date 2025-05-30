// 3190번 뱀
package BOJ_3190;

import java.io.*;
import java.util.*;

public class Main {

    private static Map<Integer, String> move = new HashMap<>();
    private static boolean[][] map;

    private static int[] dR = {0, 1, 0, -1};
    private static int[] dC = {1, 0, -1, 0};

    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new boolean[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = true;
        }

        int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            move.put(X, C);
        }

        System.out.println(snake());
    }

    private static int snake() {
        Deque<Node> body = new LinkedList<>();
        body.add(new Node(1, 1));

        boolean[][] isVisit = new boolean[N + 1][N + 1];
        isVisit[1][1] = true;

        int direction = 0;
        int time = 0;

        while (true) {
            time++;

            Node head = body.peekFirst();

            int dr = head.x + dR[direction];
            int dc = head.y + dC[direction];

            if (dr < 1 || dr > N || dc < 1 || dc > N) {
                break;
            }

            if (isVisit[dr][dc]) {
                break;
            }

            body.addFirst(new Node(dr, dc));
            isVisit[dr][dc] = true;

            if (map[dr][dc]) {
                map[dr][dc] = false;
            } else {
                Node tail = body.pollLast();
                isVisit[tail.x][tail.y] = false;
            }

            if (move.containsKey(time)) {
                String dir = move.get(time);

                if (dir.equals("D")) {
                    direction = (direction + 1) % 4;
                } else {
                    direction = (direction + 3) % 4;
                }
            }
        }

        return time;
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