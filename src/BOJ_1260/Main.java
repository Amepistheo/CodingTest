// 1260번 DFS와 BFS
package BOJ_1260;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisit;
    static int[][] graphArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        String[] inputArr;

        input = br.readLine();
        inputArr = input.split(" ");

        int N = Integer.parseInt(inputArr[0]);          // 정점의 개수
        int M = Integer.parseInt(inputArr[1]);          // 간선의 개수
        int V = Integer.parseInt(inputArr[2]);          // 탐색을 시작할 정점의 번호
        graphArr = new int[N+1][N+1];                   // 2차원 배열 graphArr 생성

        // graphArr에 간선들 저장
        while (M-- > 0) {
            String edge[] = br.readLine().split(" ");
            int edge1 = Integer.parseInt(edge[0]);
            int edge2 = Integer.parseInt(edge[1]);
            
            graphArr[edge1][edge2] = 1;
            graphArr[edge2][edge1] = 1;
        }

        // dfs 결과 값 출력
        isVisit = new boolean[N+1];
        dfs(V);

        System.out.println();

        // bfs 결과 값 출력
        isVisit = new boolean[N+1];
        bfs(V);

    }
    public static void dfs(int V) {
        isVisit[V] = true;
        System.out.print(V + " ");

        if (V == graphArr.length) {                     // graphArr.length는 graphArr의 행의 개수
            return;                                     // 아무것도 리턴하지 않은채 함수 종료시킴
        }
        
        for (int i=1; i<graphArr.length; i++) {
            if (graphArr[V][i] == 1 && isVisit[i] == false) {
                dfs(i);
            }
        }
    }
    public static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();      // BFS 탐색 저장

        queue.add(V);
        isVisit[V] = true;
        System.out.print(V + " ");

        while(!queue.isEmpty()) {                       // queue가 빌 때까지 반복
            int temp = queue.poll();
            
            for (int i=1; i< graphArr.length; i++) {
                if (graphArr[temp][i] == 1 && isVisit[i] == false) {
                    queue.add(i);
                    isVisit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
