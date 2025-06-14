package divide_and_conquer;

import java.util.ArrayList;

public class Bj_2104 {
    public static void main(String[] args) throws Exception {
        int N = readInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = readInt();
        }

        long max = 0;
        int prevBase = 0;
        ArrayList<Set> sets = new ArrayList<>;
        long prevSum = 0;

        for (int i = 0; i < N; i++) {
            int base = numbers[i];

            // 크면
            // 왼쪽은 그렇게 스킵... 오른쪽은 그냥 왼쪽에서 더한 거 빼면 되는데

            if (prevBase == base) {
                prevSum -= base;
                continue;
            }

            if (prevBase < base) {
                max = Math.max(max, prevSum * base);
            }

            if (base == 0) {
                continue;
            }

            prevBase = base;

            long sum = base;
            int leftIndex = i - 1;

            while (leftIndex >= 0) {
                int leftNumber = numbers[leftIndex--];

                if (base > leftNumber) {
                    break;
                }

                sum += leftNumber;
            }

            int rightIndex = i + 1;

            while (rightIndex < N) {
                int rightNumber = numbers[rightIndex++];

                if (base > rightNumber) {
                    break;
                }

                sum += rightNumber;
            }

            max = Math.max(max, sum * base);
            prevSum = sum - base;
        }

        System.out.println(max);
    }

    private static int readInt() throws Exception {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) >= 48) {
            n = (n * 10) + (c & 15);
        }

        return n;
    }

    private static class Set {
        public int min;
        public int sum;

        public Set(int min, int sum) {
            this.min = min;
            this.sum = sum;
        }
    }
}