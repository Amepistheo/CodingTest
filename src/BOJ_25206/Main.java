// 25206번 너의 평점은
package BOJ_25206;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[][] major = new String[20][3];

        for (int i=0; i<20; i++) {
            st = new StringTokenizer(br.readLine());

            major[i][0] = st.nextToken();
            major[i][1] = st.nextToken();
            major[i][2] = st.nextToken();
        }

        double count = 0;
        double total_credit = 0;

        for (int i=0; i<20; i++) {
            String grade = major[i][2];
            double credit = Double.parseDouble(major[i][1]);

            if (grade.equals("A+")) {
                count += (credit * 4.5);
            }
            else if (grade.equals("A0")) {
                count += (credit * 4.0);
            }
            else if (grade.equals("B+")) {
                count += (credit * 3.5);
            }
            else if (grade.equals("B0")) {
                count += (credit * 3.0);
            }
            else if (grade.equals("C+")) {
                count += (credit * 2.5);
            }
            else if (grade.equals("C0")) {
                count += (credit * 2.0);
            }
            else if (grade.equals("D+")) {
                count += (credit * 1.5);
            }
            else if (grade.equals("D0")) {
                count += (credit * 1.0);
            }
            else if (grade.equals("F")) {
                count += (credit * 0.0);
            }
            else {
                continue;
            }

            total_credit += Double.parseDouble(major[i][1]);
        }

        System.out.println(Math.round((count/total_credit) * 1000000)/1000000.0);
    }
}