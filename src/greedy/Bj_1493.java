package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_1493 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final Deque<Box> separatedBoxDeque = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        // 2의 거듭제곱을 미리 계산한 배열. 박스 분할 계산에서 사용.
        int[] powerOfTwo = new int[20];

        for (int i = 0; i < powerOfTwo.length; i++) {
            powerOfTwo[i] = (int) Math.pow(2, i);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        Box originalBox = new Box(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Queue<Byte> powerBoxQueue = new ArrayDeque<>();

        separatedBoxDeque.offer(originalBox);

        while (!separatedBoxDeque.isEmpty()) {
            Box box = separatedBoxDeque.poll();
            int power = 19;

            do {
                int sideSize = powerOfTwo[power];

                /*
                박스를 분리한다.
                박스 전체 사이즈보다 변의 크기가 크면 변의 크기를 가진 정사각형만큼은 분리할 수 있다.
                 */
                if (sideSize <= box.length && sideSize <= box.width && sideSize <= box.height) {
                    int sameBoxCount = (box.length / sideSize) * (box.width / sideSize) * (box.height / sideSize);

                    // 같은 크기의 정사각형 박스를 모두 분리한다. 분리된 정사각형의 거듭제곱 수만 저장한다.
                    for (int i = 0; i < sameBoxCount; i++) {
                        powerBoxQueue.offer((byte) power);
                    }

                    /*
                    기존 박스 사이즈에서 위에서 분리한 사이즈만큼을 제외하고 나머지 부분들을 다시 분리 대기 중인 박스로 나눈다.
                    2차원으로 단순화해서 좌측면, 상단면, 박스의 천장쪽을 따로 분리한다.

                    X는 분리 대기 큐에 추가할 박스 부분, O는 분리된 정사각형 부분

                    좌상단 분리  천장쪽 분리
                    XXX         ---
                    XOO         -XX
                    XOO         -XX
                     */
                    int separatedLengthSize = sideSize * (box.length / sideSize);
                    int separatedWidthSize = sideSize * (box.width / sideSize);
                    int separatedHeightSize = sideSize * (box.height / sideSize);

                    addSeparatedBox(separatedLengthSize, box.width - separatedWidthSize, box.height);
                    addSeparatedBox(box.length - separatedLengthSize, box.width, box.height);
                    addSeparatedBox(separatedLengthSize, separatedWidthSize, box.height - separatedHeightSize);

                    break;
                }
            }
            while (--power >= 0);
        }

        int[] cubes = new int[20];
        int cubeTypeCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < cubeTypeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int cubeType = Integer.parseInt(st.nextToken());
            int cubeCount = Integer.parseInt(st.nextToken());
            cubes[cubeType] = cubeCount;
        }

        int useCount = 0;

        while (!powerBoxQueue.isEmpty()) {
            // 박스 사이즈는 1이라고 가정하고 시작한다.
            byte cubePower = powerBoxQueue.poll();
            int boxSize = 1;

            while (boxSize > 0) {
                if (cubes[cubePower] > 0) {
                    boxSize--;
                    cubes[cubePower]--;
                    useCount++;
                } else {
                    // 부피 기준으로 한 단계 낮은 거듭제곱 수일 때 8배의 큐브가 필요한 점에 따른 계산
                    boxSize *= 8;
                    cubePower--;
                }

                if (cubePower < 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(useCount);
    }

    private static void addSeparatedBox(int length, int width, int height) {
        if ((long) length * width * height > 0) {
            separatedBoxDeque.offer(new Box(length, width, height));
        }
    }

    private static class Box {
        public int length;
        public int width;
        public int height;

        public Box(int length, int width, int height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }
    }
}