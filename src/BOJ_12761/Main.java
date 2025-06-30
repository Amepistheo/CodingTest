// 12761번 돌다리
package BOJ_12761;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        boolean[] isVisit = new boolean[100001];

        q.offer(new Node(N, 0));
        isVisit[N] = true;

        int min = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.n == M) {
                min = node.count;
                break;
            }

            int[] move = {
                    node.n - 1, node.n + 1,
                    node.n - A, node.n + A,
                    node.n - B, node.n + B,
                    node.n * A, node.n * B};

            for (int num : move) {
                if (0 <= num && num <= 100000 && !isVisit[num]) {
                    q.offer(new Node(num, node.count + 1));
                    isVisit[num] = true;
                }
            }
        }

        System.out.println(min);
    }
}

class Node {
    int n;
    int count;

    public Node(int n, int count) {
        this.n = n;
        this.count = count;
    }
}