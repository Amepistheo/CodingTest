// 2644번 촌수계산
package BOJ_2644;

import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisit;
    static int[] isCount;

    static int v1, v2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());                    // 전체 사람의 수

        for (int i=0; i<=n; i++)                                   // 노드 별 리스트 생성
            graph.add(new ArrayList<>());

        isVisit = new boolean[n+1];
        isCount = new int[n+1];

        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());                // 촌수 계산 하는 사람
        v2 = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());                 // 관계의 개수

        // 친척 관계 초기화
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.offer(v1);
        isVisit[v1] = true;
        isCount[v1] = 0;

        while (!q.isEmpty()) {
            int cousin = q.poll();

            for (int i=0; i<graph.get(cousin).size(); i++) {
                int cousinCousin = graph.get(cousin).get(i);

                // 방문한 노드일 경우 다음 루프로 넘어감
                if (isVisit[cousinCousin])
                    continue;
                // 도착지점에 다다른 경우 현재 부모 count+1의 값을 넘겨주고 함수 종료
                if (cousinCousin == v2)
                    return isCount[cousin] + 1;

                isCount[cousinCousin] = isCount[cousin] + 1;
                q.offer(cousinCousin);
                isVisit[cousinCousin] = true;
            }
        }

        // 어떠한 관계도 아닌 경우 -1 return 해줌
        return -1;
    }
}
