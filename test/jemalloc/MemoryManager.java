package test.jemalloc;

public class MemoryManager {
    private final MemoryAllocator allocator;

    public MemoryManager(MemoryAllocator allocator) {
        this.allocator = allocator;
    }

    public Object allocate(int size) {
        System.out.println("Allocating " + size + " bytes using " + allocator.getClass().getSimpleName());
        return allocator.allocate(size);
    }

    public void release(Object memoryBlock) {
        System.out.println("Releasing memory block: " + memoryBlock + " using " + allocator.getClass().getSimpleName());
        allocator.release(memoryBlock);
    }

    public static void main(String[] args) {

        // ObjectPoolingAllocator: 미리 할당된 객체들을 풀링해서 재사용합니다. 메모리 할당/해제 비용을 줄일 수 있습니다.
        // ThreadLocalAllocator: 각 스레드마다 독립적인 메모리 할당을 보장하며, 동시성 문제를 피합니다.
        // SlabAllocator: 동일 크기의 메모리 블록을 슬랩으로 묶어서 관리해 메모리 파편화를 줄입니다.
        // CachingAllocator: 한 번 할당된 메모리를 캐싱해 두고, 요청이 들어오면 이를 재사용합니다.

        // Object Pooling Allocator 사용
        MemoryManager poolingManager = new MemoryManager(new ObjectPoolingAllocator(10));
        Object pooledBlock = poolingManager.allocate(32);
        poolingManager.release(pooledBlock);

        // Thread Local Allocator 사용
        MemoryManager threadLocalManager = new MemoryManager(new ThreadLocalAllocator());
        Object threadLocalBlock = threadLocalManager.allocate(64);

        // Slab Allocator 사용
        MemoryManager slabManager = new MemoryManager(new SlabAllocator(64, 5));
        Object slabBlock = slabManager.allocate(32);
        slabManager.release(slabBlock);

        // Caching Allocator 사용
        MemoryManager cachingManager = new MemoryManager(new CachingAllocator());
        Object cachedBlock = cachingManager.allocate(128);
        cachingManager.release(cachedBlock);
    }
}

