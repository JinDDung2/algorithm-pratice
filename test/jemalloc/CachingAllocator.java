package test.jemalloc;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * jemalloc은 매번 메모리를 할당하고 해제하는 대신, 한 번 할당된 메모리를 캐싱해 두고 재사용하는 전략
 * 객체 재사용을 통해 메모리 효율성 높이기
 */

public class CachingAllocator implements MemoryAllocator {
    private final Map<Integer, byte[]> cache = new HashMap<>();

    @Override
    public Object allocate(int size) {
        if (cache.containsKey(size)) {
            System.out.println("재사용되는 cached memory of size: " + size);
            return cache.remove(size);
        }
        System.out.println("No cached memory of size " + size + ", 새로 만듭니다.");
        return new byte[size];
    }

    @Override
    public void release(Object block) {
        if (block instanceof byte[]) {
            int size = ((byte[]) block).length;
            System.out.println("Caching memory of size: " + size);
            cache.put(size, (byte[]) block);
        }
    }
}
