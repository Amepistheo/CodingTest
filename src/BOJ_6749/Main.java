// 6749번 Next in line
package BOJ_6749;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(br.readLine());
        int middle = Integer.parseInt(br.readLine());

        System.out.println(2 * middle - first);
    }
}