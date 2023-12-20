// 2935번 소음
package BOJ_2935;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger A = new BigInteger(br.readLine());
        String c = br.readLine();
        BigInteger B = new BigInteger(br.readLine());

        if (c.equals("+")) {
            System.out.println(A.add(B));
        }
        else if (c.equals("*")) {
            System.out.println(A.multiply(B));
        }
    }
}