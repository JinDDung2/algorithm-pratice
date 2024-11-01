package test.jemalloc;

public class ThreadLocalAllocator implements MemoryAllocator {
    private final ThreadLocal<Object> threadLocalMemory = ThreadLocal.withInitial(() -> new byte[64]); // 64바이트 예시

    @Override
    public Object allocate(int size) {
        Object memory = threadLocalMemory.get();
        if (memory == null) {
            System.out.println("이 스레드는 할당 가능한 메모리가 없습니다. 새로운 공간을 확보합니다.");
            memory = new byte[size];
            threadLocalMemory.set(memory);
        } else {
            System.out.println("thread-local의 기존 메모리를 재사용합니다.");
        }
        return memory;
    }

    @Override
    public void release(Object block) {
        System.out.println("thread-local 메모리를 제거합니다.");
        threadLocalMemory.remove();
    }
}

