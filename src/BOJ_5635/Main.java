// 5635번 생일
package BOJ_5635;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[][] student = new String[N][4];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            student[i][0] = st.nextToken();
            student[i][1] = st.nextToken();
            student[i][2] = st.nextToken();
            student[i][3] = st.nextToken();
        }

        Arrays.sort(student, (o1, o2) -> {
            if (Objects.equals(o1[3], o2[3])) {
                if (Objects.equals(o1[2], o2[2])) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                }
                else {
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
            }
            else {
                return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
            }
        });

        sb.append(student[N-1][0]).append("\n").append(student[0][0]);

        System.out.println(sb);
    }
}