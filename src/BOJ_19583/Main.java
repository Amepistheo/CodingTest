// 19583번 싸이버개강총회
package BOJ_19583;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        String[] S = str[0].split(":");
        String[] E = str[1].split(":");
        String[] Q = str[2].split(":");

        long start1 = Long.parseLong(S[0]) * 60 + Long.parseLong(S[1]);
        long end1 = Long.parseLong(E[0]) * 60 + Long.parseLong(E[1]);
        long end2 = Long.parseLong(Q[0]) * 60 + Long.parseLong(Q[1]);

        Set<String> enter = new HashSet<>();
        Set<String> exit = new HashSet<>();

        String tmp;

        while ((tmp = br.readLine()) != null) {
            if (tmp.isEmpty()) {
                break;
            }

            String[] t = tmp.split(" ");
            String[] m = t[0].split(":");

            long time = Long.parseLong(m[0]) * 60 + Long.parseLong(m[1]);

            if (time <= start1) {
                enter.add(t[1]);
            } else if (end1 <= time && time <= end2) {
                exit.add(t[1]);
            }
        }

        int count = 0;

        for (String n : enter) {
            if (exit.contains(n)) {
                count++;
            }
        }

        System.out.println(count);
    }
}