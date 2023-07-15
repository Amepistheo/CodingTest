// 2606번 바이러스
package BOJ_2606;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());        // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine());        // 컴퓨터 쌍의 수 (간선 개수)
        boolean[][] graphArr = new boolean[N+1][N+1];   // 간선 유무 T/F
        boolean[] isVisit = new boolean[N + 1];         // 방문 여부 T/F
        int count = 0;                                  // 바이러스 걸린 컴퓨터의 수

        while(M-- > 0) {                                // 간선 graphArr에 저장
            String input = br.readLine();
            String[] inputArr = input.split(" ");

            int V1 = Integer.parseInt(inputArr[0]);
            int V2 = Integer.parseInt(inputArr[1]);

            graphArr[V1][V2] = true;
            graphArr[V2][V1] = true;
        }

        queue.add(1);                                   // 1번 컴퓨터 시작이기 때문에 queue에 저장 및 true 변경
        isVisit[1] = true;

        while(!queue.isEmpty()) {                       // BFS(너비우선탐색)을 통해 isVisit의 값 변경
            int temp = queue.poll();

            for (int i=1; i<graphArr.length; i++) {
                if (graphArr[temp][i] && !isVisit[i]) {
                    queue.add(i);
                    isVisit[i] = true;
                }
            }
        }

        for (int i=1; i< graphArr.length; i++) {
            if (isVisit[i])
                count++;
        }

        System.out.println(count-1);
    }
}