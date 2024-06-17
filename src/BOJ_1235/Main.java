// 1235번 학생 번호
package BOJ_1235;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] student = new String[N];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            student[i] = br.readLine();
        }

        int length = student[0].length();

        for (int k = 1; k <= length; k++) {
            for (int i = 0; i < N; i++) {
                set.add(student[i].substring(length - k));
            }

            if (set.size() == N) {
                System.out.println(k);
                break;
            }

            set.clear();
        }
    }
}