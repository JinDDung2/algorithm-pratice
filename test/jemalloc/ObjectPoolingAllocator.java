package test.jemalloc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * jemalloc은 메모리 풀을 사용하여 여러 요청을 그룹화하고 빠르게 할당/해제할 수 있게끔 최적화
 * 메모리 풀링을 통해 객체 생성 비용을 줄일는 방법?
 * Object Pooling을 구현하여 재사용 가능한 객체를 미리 만들어 놓고, 필요할 때 가져와 사용하는 방식 -> 객체 생성에 따른 GC 부담을 줄이기
 */
public class ObjectPoolingAllocator implements MemoryAllocator {
    private final Queue<Object> pool;
    private final int maxSize;

    public ObjectPoolingAllocator(int maxSize) {
        this.pool = new LinkedList<>();
        this.maxSize = maxSize;
    }

    @Override
    public Object allocate(int size) {
        if (!pool.isEmpty()) {
            System.out.println("풀에 있는 객체 재사용합니다.");
            return pool.poll();
        }
        System.out.println("이용가능한 풀이 없습니다. 새로운 객체를 생성합니다.");
        return new byte[size];
    }

    @Override
    public void release(Object block) {
        if (pool.size() < maxSize) {
            System.out.println("풀에 객체를 반환합니다.");
            pool.offer(block);
        } else {
            System.out.println("풀이 꽉차서 객체를 반환할 수 없습니다.");
        }
    }
}
