package test.jemalloc;

public interface MemoryAllocator {
    // 메모리 할당 메서드
    Object allocate(int size);

    // 메모리 해제 메서드
    void release(Object memoryBlock);
}

