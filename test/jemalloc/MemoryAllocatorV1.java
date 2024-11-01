package test.jemalloc;

import java.util.TreeMap;

public class MemoryAllocatorV1 {
    // 크기 클래스를 저장하는 TreeMap (크기 순으로 정렬됨)
    private final TreeMap<Integer, String> sizeClasses = new TreeMap<>();

    public MemoryAllocatorV1() {
        // 다양한 크기 클래스를 정의 (여기서는 간단히 8, 16, 32, 64 바이트 예시)
        sizeClasses.put(8, "8-byte class");
        sizeClasses.put(16, "16-byte class");
        sizeClasses.put(32, "32-byte class");
        sizeClasses.put(64, "64-byte class");
        // 더 많은 크기 클래스를 필요에 따라 추가할 수 있음
    }

    // 메모리 요청
    public String allocate(int size) {
        // 요청된 크기보다 큰 가장 작은 클래스 찾기
        Integer key = sizeClasses.ceilingKey(size);

        if (key != null) {
            // 해당 클래스에 메모리를 할당하는 것으로 처리
            return "Allocated from: " + sizeClasses.get(key);
        } else {
            // 할당 가능한 크기가 없을 때
            return "Allocation failed: 요청된 size가 너무 큽니다.";
        }
    }

    public static void main(String[] args) {
        MemoryAllocatorV1 allocator = new MemoryAllocatorV1();

        // 10바이트 할당 요청 (16-byte 클래스에 할당됨)
        System.out.println(allocator.allocate(10));

        // 50바이트 할당 요청 (64-byte 클래스에 할당됨)
        System.out.println(allocator.allocate(50));

        // 70바이트 할당 요청 (크기 초과로 실패)
        System.out.println(allocator.allocate(70));
    }
}
