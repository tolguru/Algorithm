package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj_17509 {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int[] solveTimes = new int[11];
        int[] incorrectCounts = new int[11];

        for (int i = 0; i < 11; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            solveTimes[i] = Integer.parseInt(st.nextToken());
            incorrectCounts[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solveTimes);

        int passedTime = 0;
        int penalty = 0;

        for (int i = 0; i < 11; i++) {
            penalty += solveTimes[i] + passedTime + incorrectCounts[i] * 20;
            passedTime += solveTimes[i];
        }

        System.out.println(penalty);
    }
}