// 3040번 백설 공주와 일곱 난쟁이
package BOJ_3040;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dwarf = new int[9];
        int target1 = 0;
        int target2 = 0;
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            sum += dwarf[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - dwarf[i] - dwarf[j] == 100) {
                    target1 = i;
                    target2 = j;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == target1) {
                continue;
            }
            if (i == target2) {
                continue;
            }

            sb.append(dwarf[i]).append("\n");
        }

        System.out.print(sb);
    }
}