// 11948번 과목선택
package BOJ_11948;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] science = new int[4];
        int[] society = new int[2];

        for (int i = 0; i < 4; i++) {
            science[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2; i++) {
            society[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(science);
        Arrays.sort(society);

        int sum = science[1] + science[2] + science[3] + society[1];

        System.out.println(sum);
    }
}