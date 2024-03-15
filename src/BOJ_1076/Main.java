// 1076번 저항
package BOJ_1076;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        long result = (Arrays.asList(color).indexOf(first) * 10) + (Arrays.asList(color).indexOf(second));
        result *= (long) Math.pow(10, Arrays.asList(color).indexOf(third));

        System.out.println(result);
    }
}