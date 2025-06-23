package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long firstValue = 1;
        long secondValue = 1;
        long tmp;

        if (n <= 2) {
            System.out.println(1);

            return;
        }

        for (int i = 0; i < n - 2; i++) {
            tmp = secondValue;
            secondValue += firstValue;
            firstValue = tmp;
        }

        System.out.println(secondValue);
    }
}
