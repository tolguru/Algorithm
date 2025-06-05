package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj_1700 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int holeCount = Integer.parseInt(st.nextToken());
        int usageCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] usageSequence = new int[usageCount];

        for (int i = 0; i < usageCount; i++) {
            usageSequence[i] = Integer.parseInt(st.nextToken());
        }

        Device[] devices = new Device[usageCount];
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        // 각 Device 객체는 다음 Device까지의 거리를 가진다.
        for (int i = usageCount - 1; i >= 0; i--) {
            int deviceName = usageSequence[i];
            int lastIndex = lastIndexMap.getOrDefault(deviceName, i);
            int distance = lastIndex == i ? Integer.MAX_VALUE : lastIndex - i;

            devices[i] = new Device(i, deviceName, distance);

            lastIndexMap.put(deviceName, i);
        }

        Device[] multitap = new Device[holeCount];
        int swapCount = 0;

        for (int i = 0; i < usageCount; i++) {
            Device device = devices[i];
            int farthestDistance = 0;
            int farthestDeviceIndex = 0;
            boolean isReplaced = true;

            for (int j = 0; j < holeCount; j++) {
                Device usingDevice = multitap[j];

                // 비어 있는 플러그일 경우
                if (usingDevice == null) {
                    farthestDeviceIndex = j;
                    isReplaced = false;
                    break;
                } else {
                    // 같은 장치일 경우 교체
                    if (usingDevice.deviceName == device.deviceName) {
                        farthestDeviceIndex = j;
                        isReplaced = false;
                        break;
                    } else {
                        // 가장 멀리 있는 장치 탐색
                        int distance = usingDevice.distance - (i - usingDevice.index);

                        if (farthestDistance < distance) {
                            farthestDistance = distance;
                            farthestDeviceIndex = j;
                        }
                    }
                }
            }

            if (isReplaced) {
                swapCount++;
            }

            multitap[farthestDeviceIndex] = device;
        }

        System.out.println(swapCount);
    }

    static class Device {
        public int index;
        public int deviceName;
        public int distance;

        public Device(int index, int deviceName, int distance) {
            this.index = index;
            this.deviceName = deviceName;
            this.distance = distance;
        }
    }
}