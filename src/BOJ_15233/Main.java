// 15233번 Final Score
package BOJ_15233;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        String[] teamA = new String[A];
        String[] teamB = new String[B];

        int countA = 0;
        int countB = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < A; i++) {
            teamA[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < B; i++) {
            teamB[i] = st.nextToken();
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < G; i++) {
            String player = st.nextToken();

            for (int j = 0; j < A; j++) {
                if (teamA[j].equals(player)) {
                    countA++;
                    break;
                }
            }

            for (int j = 0; j < B; j++) {
                if (teamB[j].equals(player)) {
                    countB++;
                    break;
                }
            }
        }

        if (countA > countB) {
            System.out.println("A");
        }
        else if (countA < countB) {
            System.out.println("B");
        }
        else {
            System.out.println("TIE");
        }
    }
}