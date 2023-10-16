// 2346번 풍선 터뜨리기
package BOJ_2346;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Node> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            int value = Integer.parseInt(st.nextToken());
            deque.offer(new Node(i, value));
        }

        while (!deque.isEmpty()) {
            sb.append(deque.getFirst().index).append(" ");
            int next = deque.poll().value;

            if (deque.isEmpty())
                break;

            // 양수일 때 next-1을 하는 이유는 next에서 poll()을 하여 오른쪽으로 한칸 먼저 이동했기 때문
            if (next > 0) {
                for (int i=0; i<next-1; i++)
                    deque.offerLast(deque.pollFirst());
            }
            else {
                for (int i=0; i<Math.abs(next); i++)
                    deque.offerFirst(deque.pollLast());
            }
        }

        System.out.print(sb);
    }
}

class Node {
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}