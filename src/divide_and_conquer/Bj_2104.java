package divide_and_conquer;

public class Bj_2104 {
    public static void main(String[] args) throws Exception {
        int N = readInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = readInt();
        }

        long max = 0;

        for (int i = 0; i < N; i++) {
            int base = numbers[i];
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
}