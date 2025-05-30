package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int questionCount = Integer.parseInt(bf.readLine());
        int[][] questions = new int[questionCount][3];
        int[][] answers = new int[questionCount][2];

        for (int i = 0; i < questionCount; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int questionInput = Integer.parseInt(st.nextToken());

            questions[i][0] = questionInput / 100;
            questions[i][1] = (questionInput % 100) / 10;
            questions[i][2] = questionInput % 10;
            answers[i][0] = Integer.parseInt(st.nextToken());
            answers[i][1] = Integer.parseInt(st.nextToken());
        }

        int expectationCount = 0;

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = 1; k < 10; k++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    boolean isCorrect = true;

                    for (int l = 0; l < questionCount; l++) {
                        int sameLocateCount = 0;
                        int anotherLocateCount = 0;

                        if (questions[l][0] == i) {
                            sameLocateCount++;
                        }

                        if (questions[l][1] == j) {
                            sameLocateCount++;
                        }

                        if (questions[l][2] == k) {
                            sameLocateCount++;
                        }

                        if (questions[l][0] == k || questions[l][0] == j) {
                            anotherLocateCount++;
                        }

                        if (questions[l][1] == k || questions[l][1] == i) {
                            anotherLocateCount++;
                        }

                        if (questions[l][2] == j || questions[l][2] == i) {
                            anotherLocateCount++;
                        }

                        if (answers[l][0] != sameLocateCount || answers[l][1] != anotherLocateCount) {
                            isCorrect = false;
                            break;
                        }
                    }

                    if (isCorrect) {
                        expectationCount++;
                    }
                }
            }
        }

        System.out.println(expectationCount);
    }
}
