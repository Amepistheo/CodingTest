// 1032번 명령 프롬프트
package BOJ_1032;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char[] file = new char[50];

        String input = br.readLine();

        for (int i=0; i<input.length(); i++) {
            file[i] = input.charAt(i);
        }

        if (N == 1) {
            sb.append(input);
        }
        else {
            for (int i=0; i<N-1; i++) {
                String input2 = br.readLine();

                for (int j=0; j<input.length(); j++) {
                    if (file[j] != (input2.charAt(j))) {
                        file[j] = '?';
                    }
                }
            }

            for (int i=0; i<input.length(); i++) {
                sb.append(file[i]);
            }
        }

        System.out.println(sb);
    }
}