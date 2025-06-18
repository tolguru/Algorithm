import java.io.IOException;

public class Test {
    private static final int[] array = new int[7];

    public static void main(String[] args) throws IOException {
        array[0] = 38;
        array[1] = 27;
        array[2] = 43;
        array[3] = 3;
        array[4] = 9;
        array[5] = 82;
        array[6] = 10;

        divide(0, 6);
    }

    private static void divide(int s, int e) {
        if (s == e) {
            System.out.println(array[s]);
            return;
        }

        for (int i = s; i <= e; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int mid = (s + e) / 2;
        divide(s, mid);
        divide(mid + 1, e);
    }
}
