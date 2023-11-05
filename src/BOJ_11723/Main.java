// 11723번 집합
package BOJ_11723;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        boolean[] set = new boolean[21];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
                case "add":
                    set[Integer.parseInt(st.nextToken())] = true;
                    break;

                case "remove":
                    set[Integer.parseInt(st.nextToken())] = false;
                    break;

                case "check":
                    if (set[Integer.parseInt(st.nextToken())]) {
                        sb.append(1).append("\n");
                    }
                    else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "toggle":
                    int x = Integer.parseInt(st.nextToken());
                    set[x] = !set[x];
                    break;

                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set[j] = true;
                    }
                    break;

                case "empty":
                    for (int j = 1; j <= 20; j++) {
                        set[j] = false;
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}