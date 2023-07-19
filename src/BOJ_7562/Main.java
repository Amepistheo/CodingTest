// 7562번 나이트의 이동
package BOJ_7562;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dR = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dC = {-2, -2, -1, -1, 1, 1, 2, 2};

    static boolean[][] isVisit;
    static int I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());            // 테스트 케이스의 개수


        while(N-- > 0) {
            I = Integer.parseInt(br.readLine());            // 체스판의 한 변의 길이
            isVisit = new boolean[I][I];                    // isVisit 초기화

            st = new StringTokenizer(br.readLine());

            int rowP = Integer.parseInt(st.nextToken());     // 나이트가 현재 있는 행
            int colP = Integer.parseInt(st.nextToken());     // 나이트가 현재 있는 열

            st = new StringTokenizer(br.readLine());

            int rowG = Integer.parseInt(st.nextToken());    // 나이트가 이동하려는 행
            int colG = Integer.parseInt(st.nextToken());    // 나이트가 이동하려는 열

            sb.append(bfs(rowP, colP, rowG, colG)).append('\n');
        }
        System.out.print(sb);
    }

    public static int bfs(int rowP, int colP, int rowG, int colG) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(rowP, colP, 0));           // count는 이동한 횟수
        isVisit[rowP][colP] = true;

        while(!q.isEmpty()) {
            Node vertex = q.poll();

            for (int i=0; i<8; i++) {
                int dr = vertex.row + dR[i];
                int dc = vertex.col + dC[i];

                if (dr<0 || dr>=I || dc<0 || dc>=I)
                    continue;
                if (isVisit[dr][dc])
                    continue;

                if(dr == rowG && dc == colG)            // 도착지점을 만났을 때 이동횟수+1을 return
                    return vertex.count+1;

                q.offer(new Node(dr, dc, vertex.count+1));      // 모든 조건문에 해당하지 않는 경우 queue에 값 넣음
                isVisit[dr][dc] = true;                               // count가 아닌 vertex.count에 1을 더한 값을 넣어줘야 함!! (각 정점에서 +1 한 것이지 queue에 값을 넣을때마다 +1 해주는 것이 아니기 떄문)
            }
        }

        // 도착지점에 가지 못하는 경우 or 위치가 변하지 않은 경우
        return 0;
    }
}

class Node{
    int row, col, count;

    public Node(int row, int col, int count) {
        this.row = row;
        this.col = col;
        this.count = count;
    }
}
