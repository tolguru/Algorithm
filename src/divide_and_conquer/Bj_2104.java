package divide_and_conquer;

public class Bj_2104 {
    public static void main(String[] args) throws Exception {
        int N = readInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = readInt();
        }
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