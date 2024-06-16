// 5545번 최고의 피자
package BOJ_5545;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Integer[] topping = new Integer[N];

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            topping[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(topping, Collections.reverseOrder());

        int pizzaKcal = C / A;
        int price = A;
        int kcal = C;

        for (int i = 0; i < N; i++) {
            price += B;
            kcal += topping[i];

            int tempKcal = kcal / price;

            if (pizzaKcal > tempKcal) {
                break;
            }
            else {
                pizzaKcal = tempKcal;
            }
        }

        System.out.println(pizzaKcal);
    }
}