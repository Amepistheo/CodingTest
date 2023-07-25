// 11650번 좌표 정렬하기
package BOJ_11650;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Queue<Node> q = new PriorityQueue<>();                  // 우선순위 큐 사용(오름차순 정렬. 기준 밑에서 다시 작성해줌)

        int N = Integer.parseInt(br.readLine());                // 점의 개수

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            q.offer(new Node(x, y));
        }

        for (int i=0; i<N; i++) {
            Node vertex = q.poll();
            System.out.println(vertex.x + " " + vertex.y);
        }
    }
}

class Node implements Comparable<Node> {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // compareTo의 경우 결과값이 양수인 경우 순서를 바꿔줌
    @Override
    public int compareTo(Node node) {
        if (this.x == node.x)
            return this.y - node.y;
        else
            return this.x - node.x;
    }
}