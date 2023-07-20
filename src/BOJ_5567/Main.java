// 5567번 결혼식
package BOJ_5567;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());            // 동기의 수
        int m = Integer.parseInt(br.readLine());            // 리스트의 길이

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] isVisit = new boolean[n+1];

        // 각 노드 별 리스트 생성
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        // 연결리스트에 값 넣기
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 상근이의 친구들 node에 넣음
        List<Integer> node = graph.get(1);
        isVisit[1] = true;

        // 친구들의 친구들 방문하면 true
        for (int j = 0; j < node.size(); j++) {
            List<Integer> node2 = graph.get(node.get(j));
            isVisit[node.get(j)] = true;

            for (int k = 0; k < node2.size(); k++) {
                isVisit[node2.get(k)] = true;
            }
        }

        int count = 0;
        for (int i=1; i<=n; i++) {
            if (isVisit[i])
                count++;
        }

        // 상근이 제외하고서 초대할 친구들의 인원수 출력
        System.out.println(count-1);
    }
}

// 인접리스트 & BFS 사용 코드 (참고해서 공부해보기)
/*public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> l = new ArrayList<>();
        for(int i = 0; i<=N; i++)
            l.add(new ArrayList<>());

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            l.get(A).add(B);
            l.get(B).add(A);
        }

        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        boolean[] visited = new boolean[N+1];
        visited[1] = true;

        //친구들을 확인
        for(int i = 0; i<l.get(1).size(); i++){
            int friend = l.get(1).get(i);

            if(visited[friend])
                continue;

            visited[friend] = true;
            sum++;
            q.offer(friend);
        }

        while(!q.isEmpty()){
            int friend = q.poll();

            for(int i = 0; i<l.get(friend).size(); i++){
                int friendFriend = l.get(friend).get(i);

                if(visited[friendFriend])
                    continue;

                sum++;
                visited[friendFriend] = true;
            }
        }

        System.out.println(sum);
    }
}*/
