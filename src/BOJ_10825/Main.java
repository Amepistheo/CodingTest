// 10825번 국영수
package BOJ_10825;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[][] student = new String[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            student[i][0] = st.nextToken();
            student[i][1] = st.nextToken();
            student[i][2] = st.nextToken();
            student[i][3] = st.nextToken();
        }

        Arrays.sort(student, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[1].equals(o2[1])) {
                    if (o1[2].equals(o2[2])) {
                        if (o1[3].equals(o2[3])) {
                            return o1[0].compareTo(o2[0]);
                        }

                        return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                    }

                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }

                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(student[i][0]).append("\n");
        }

        System.out.print(sb);
    }
}