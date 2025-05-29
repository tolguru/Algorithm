package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_1182 {
    private static int matchedCount = 0;
    private static int[] sequence;
    private static int n;
    private static int s;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nsSt = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(nsSt.nextToken());
        s = Integer.parseInt(nsSt.nextToken());
        sequence = new int[n];
        StringTokenizer sequenceSt = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(sequenceSt.nextToken());
        }

        check(0, 0);

        System.out.println(matchedCount);
    }

    private static void check(int index, int sum) {
        for (int i = index; i < n; i++) {
            int subSum = sequence[i] + sum;

            if (subSum == s) {
                matchedCount++;
            }

            check(i + 1, subSum);
        }
    }
}
