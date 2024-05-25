// 5766번 할아버지는 유명해!
package BOJ_5766;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if ((N == 0) && (M == 0)) {
                break;
            }

            Player player[] = new Player[10001];

            for (int i = 0; i < 10001; i++) {
                player[i] = new Player(i, 0);
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    player[Integer.parseInt(st.nextToken())].score++;
                }
            }

            Arrays.sort(player);

            for (int i = 0; i < 10001; i++) {
                if (player[1].score == player[i].score) {
                    sb.append(player[i].number).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}

class Player implements Comparable<Player> {
    int number;
    int score;

    public Player(int number, int score) {
        this.number = number;
        this.score = score;
    }

    @Override
    public int compareTo(Player other) {
        // 점수에 대해 내림차순 정렬
        return Integer.compare(other.score, this.score);
    }
}