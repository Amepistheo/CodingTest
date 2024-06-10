// 15720번 카우버거
package BOJ_15720;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Integer[] burger = new Integer[B];
        Integer[] side = new Integer[C];
        Integer[] drink = new Integer[D];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < B; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            side[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < D; i++) {
            drink[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(burger, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(drink, Collections.reverseOrder());

        int min = Math.min(burger.length, Math.min(side.length, drink.length));

        int originalPrice = 0;
        int discountPrice = 0;

        for (int i = 0; i < min; i++) {
            int sum = 0;
            sum += (burger[i] + side[i] + drink[i]);

            originalPrice += sum;
            discountPrice += (int) (sum * 0.9);
        }

        for (int i = min; i < burger.length; i++) {
            originalPrice += burger[i];
            discountPrice += burger[i];
        }
        for (int i = min; i < side.length; i++) {
            originalPrice += side[i];
            discountPrice += side[i];
        }
        for (int i = min; i < drink.length; i++) {
            originalPrice += drink[i];
            discountPrice += drink[i];
        }

        sb.append(originalPrice).append("\n").append(discountPrice);

        System.out.println(sb);
    }
}