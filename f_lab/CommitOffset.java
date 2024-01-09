package f_lab;

import java.util.*;

/**
 * 예제 1:
 * 입력: [2, 0, 1]
 * 출력: [-1, 0, 2]
 * 
 * 예제 2:
 * 입력: [0, 1, 2]
 * 출력: [0, 1, 2]
 * 
 * 예제 3:
 * 입력: [2, 1, 0, 5, 4]
 * 출력: [-1, -1, 2, -1, -1]
 * 
 * 예제 4:
 * 입력: [2, 1, 0, 5, 4, 3]
 * 출력: [-1, -1, 2, -1, -1, 5]
 * 
 * 예제 5:
 * 입력: [2, 1, 0, 5, 4, 3, 9, 7, 6, 8]
 * 출력: [-1, -1, 2, -1, -1, 5, -1, -1, 7, 9]
 * 
 * 예제 6:
 * 입력: [3, 0, 2, 4, 1, 7, 6, 5, 9]
 * 출력: [-1, 0, -1, -1, 4, -1, -1, 7, -1]
 */

public class CommitOffset {
    // 현재 시점에 호출할 수 있는 가장 높은 오프셋 확인 -> 체이닝을 통해 한번 묶어주면 체이닝 범위 안의 숫자는 더이상 관심사가 아니다.
    // 연결되어 있는 값들의 범위가 어디까지 인지?
    // 값이 추가되어 있을 경우 어느 파트와 연결이 되는지?
    // 아니면 -1
    public int[] commitOffsets(int[] offsets) {
        int n = offsets.length;
        int[] result = new int[n];
        // key: offset value, value: etiher of maximum or chanined minimum
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int currentOffset = offsets[i];
            map.put(currentOffset, currentOffset);
            int lowest = currentOffset, highest = currentOffset;

            if (map.containsKey(currentOffset - 1)) {
                lowest = map.get(currentOffset - 1);
            }

            if (map.containsKey(currentOffset + 1)) {
                highest = map.get(currentOffset + 1);
            }

            // 체이닝을 볼 떄 최솟값에는 최댓값을, 최댓값에는 최솟값을 넣는다. 즉, [key:value] 라는 체이닝이 만들어진다.
            // 체이닝의 최솟값과 최댓값이 갖고 있는 value만 중요하고, 그 사이의 값들은 중요하지 않다.
            map.put(lowest, highest);
            map.put(highest, lowest);

            result[i] = lowest == 0 ? highest : -1;
        }

        return result;
    }

    public static void main(String[] args) {
        CommitOffset obj = new CommitOffset();
        int[] arr = new int[] { 3, 0, 2, 4, 1, 7, 6, 5, 9 };
        System.out.println(Arrays.toString(obj.commitOffsets(arr)));
    }

}
