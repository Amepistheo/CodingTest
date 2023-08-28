// 11870번 좌표 압축
package BOJ_18870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];
        int[] sort = new int[N];                                // 정렬된 배열 저장
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            sort[i] = input[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 오름차순 정렬 (중복된 값은 저장 X)
        Arrays.sort(sort);

        int rank = 0;

        for (int i=0; i<sort.length; i++) {
            if (!map.containsKey(sort[i])) {
                map.put(sort[i], rank);
                rank++;
            }
        }

        for (int i=0; i<N; i++) {
            sb.append(map.get(input[i])).append(" ");
        }

        System.out.print(sb);
    }
}
