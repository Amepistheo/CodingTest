// 10814번 나이순 정렬
package BOJ_10814;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[][] inputArr = new String[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            inputArr[i][0] = st.nextToken();            // 나이 저장
            inputArr[i][1] = st.nextToken();            // 이름 저장
        }

        // 나이순으로 정렬 (오름차순)
        Arrays.sort(inputArr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (int i=0; i<N; i++) {
            System.out.println(inputArr[i][0] + " " + inputArr[i][1]);
        }
    }
}
