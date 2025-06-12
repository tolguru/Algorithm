package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_1493 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] powerOfTwo = new int[20];
    private static final int[] cubes = new int[20];
    private static int useCount = 0;

    public static void main(String[] args) throws Exception {
        try {
            // 2의 거듭제곱을 미리 계산한 배열. 박스 분할 계산에서 사용.
            for (int i = 0; i < powerOfTwo.length; i++) {
                powerOfTwo[i] = (int) Math.pow(2, i);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            long boxLength = Integer.parseInt(st.nextToken());
            long boxWidth = Integer.parseInt(st.nextToken());
            long boxHeight = Integer.parseInt(st.nextToken());
            byte cubeTypeCount = Byte.parseByte(br.readLine());

            for (int i = 0; i < cubeTypeCount; i++) {
                st = new StringTokenizer(br.readLine());
                cubes[Byte.parseByte(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            fillBox(boxLength, boxWidth, boxHeight);
        } catch (Exception e) {
            useCount = -1;
        } finally {
            System.out.println(useCount);
        }
    }

    private static void fillBox(long length, long width, long height) throws Exception {
        byte power = 19;

        do {
            int sideSize = powerOfTwo[power];

            /*
            박스를 분리한다.
            변의 크기보다 박스 전체 사이즈가 크면 변의 크기를 가진 정사각형만큼은 분리할 수 있다.
             */
            if (sideSize <= length && sideSize <= width && sideSize <= height) {
                long sameBoxCount = (length / sideSize) * (width / sideSize) * (height / sideSize);

                // 2의 거듭제곱 사이즈 정사각형으로 채울 수 있을 만큼 채운다.
                for (long i = 0; i < sameBoxCount; i++) {
                    fillBox(power);
                }

                /*
                기존 박스 사이즈에서 위에서 채운 사이즈만큼을 제외하고 나머지 부분들을 분리해서 큐브로 채운다.
                2차원으로 단순화해서 좌측면, 상단면, 박스의 천장쪽을 따로 분리한다.

                X는 분리해서 채울 부분, O는 이미 채워진 부분

                좌상단 분리  천장쪽 분리
                XXX         ---
                XOO         -XX
                XOO         -XX
                 */
                long separatedLengthSize = sideSize * (length / sideSize);
                long separatedWidthSize = sideSize * (width / sideSize);
                long separatedHeightSize = sideSize * (height / sideSize);

                fillSeparatedBox(separatedLengthSize, width - separatedWidthSize, height);
                fillSeparatedBox(length - separatedLengthSize, width, height);
                fillSeparatedBox(separatedLengthSize, separatedWidthSize, height - separatedHeightSize);

                break;
            }
        }
        while (--power >= 0);
    }

    private static void fillBox(byte boxPower) throws Exception {
        byte cubePower = boxPower;
        long boxSize = 1;

        while (boxSize > 0) {
            if (cubes[cubePower] > 0) {
                boxSize--;
                cubes[cubePower]--;
                useCount++;
            } else {
                // 부피 기준으로 한 단계 낮은 거듭제곱일 때 8배의 큐브가 필요한 점에 따른 계산
                boxSize *= 8;
                cubePower--;
            }

            if (cubePower < 0) {
                throw new Exception("Cube is not enough");
            }
        }
    }

    private static void fillSeparatedBox(long length, long width, long height) throws Exception {
        if (length * width * height > 0) {
            fillBox(length, width, height);
        }
    }
}