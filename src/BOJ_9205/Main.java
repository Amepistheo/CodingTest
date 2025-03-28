// 9205번 맥주 마시면서 걸어가기
package BOJ_9205;

import java.io.*;
import java.util.*;

public class Main {

    private static List<Node> list;
    private static boolean[] isVisit;

    private static Node home, festival;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            isVisit = new boolean[n];

            st = new StringTokenizer(br.readLine());
            home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Node(x, y));
            }

            st = new StringTokenizer(br.readLine());
            festival = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            boolean isPossible = bfs();

            if (isPossible) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
        }

        System.out.print(sb);
    }

    private static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(home);

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (Math.abs(current.x - festival.x) + Math.abs(current.y - festival.y) <= 1000) {
                return true;
            }

            for (int i = 0; i < list.size(); i++) {
                Node next = list.get(i);

                if (isVisit[i]) {
                    continue;
                }

                if (Math.abs(current.x - next.x) + Math.abs(current.y - next.y) <= 1000) {
                    isVisit[i] = true;
                    q.offer(next);
                }
            }
        }

        return false;
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