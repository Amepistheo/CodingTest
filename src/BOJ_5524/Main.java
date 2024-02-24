// 5524번 입실 관리
package BOJ_5524;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            String newName = "";

            for (int j = 0; j < name.length(); j++) {
                if (name.charAt(j) >= 'A' && name.charAt(j) <= 'Z') {
                    newName += (char)(name.charAt(j) + 32);
                }
                else {
                    newName += name.charAt(j);
                }
            }

            sb.append(newName).append('\n');
        }

        System.out.print(sb);
    }
}