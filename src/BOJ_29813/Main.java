// 29813번 최애의 팀원
package BOJ_29813;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Queue<Node> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int id = Integer.parseInt(st.nextToken());

            q.offer(new Node(name, id));
        }

        while (q.size() > 1) {
            Node node = q.poll();

            while (node.id > 1) {
                q.offer(q.poll());
                node.id--;
            }

            q.poll();
        }

        System.out.println(q.poll().name);
    }
}

class Node {
    String name;
    int id;

    public Node (String name, int id) {
        this.name = name;
        this.id = id;
    }
}