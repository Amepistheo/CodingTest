// 9536번 여우는 어떻게 울지?
package BOJ_9536;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            List<String> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }

            while (true) {
                String s = br.readLine();

                if (s.equals("what does the fox say?")) {
                    break;
                }

                String[] sound = s.split(" ");

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).equals(sound[2])) {
                        list.remove(j);
                        j--;
                    }
                }
            }

            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j)).append(" ");
            }
        }

        System.out.println(sb);
    }
}