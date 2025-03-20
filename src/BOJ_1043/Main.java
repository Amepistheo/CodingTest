// 1043번 거짓말
package BOJ_1043;

import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> party = new ArrayList<>();
    private static List<List<Integer>> participant = new ArrayList<>();

    private static int[] knowPeople;
    private static boolean[] isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            party.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            participant.add(new ArrayList<>());
        }

        isPossible = new boolean[M];

        st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        knowPeople = new int[count];

        for (int i = 0; i < count; i++) {
            knowPeople[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int people = Integer.parseInt(st.nextToken());

                party.get(people).add(i);
                participant.get(i).add(people);
            }
        }

        for (int i = 0; i < knowPeople.length; i++) {
            dfs(knowPeople[i]);
        }

        int result = 0;

        for (int i = 0; i < M; i++) {
            if (!isPossible[i]) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int person) {
        for (int i = 0; i < party.get(person).size(); i++) {
            int p = party.get(person).get(i);

            if (!isPossible[p]) {
                isPossible[p] = true;

                for (int j = 0; j < participant.get(p).size(); j++) {
                    int next = participant.get(p).get(j);
                    dfs(next);
                }
            }
        }
    }
}