package test.jemalloc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * jemalloc은 동일한 크기의 객체들을 하나의 슬랩(slab)에 모아 관리합니다. 메모리 파편화 줄이기 위해 사용
 * 일정 크기의 객체들을 슬랩 구조로 묶어두고 관리
 */

public class SlabAllocator implements MemoryAllocator {
    private final int slabSize;
    private final Queue<byte[]> freeSlabs;

    public SlabAllocator(int slabSize, int initialSlabs) {
        this.slabSize = slabSize;
        this.freeSlabs = new LinkedList<>();
        for (int i = 0; i < initialSlabs; i++) {
            freeSlabs.offer(new byte[slabSize]);
        }
    }

    @Override
    public Object allocate(int size) {
        if (!freeSlabs.isEmpty()) {
            System.out.println("slab을 재사용합니다");
            return freeSlabs.poll();
        }
        System.out.println("free slabs이 없습니다. 새로운 slab을 만듭니다.");
        return new byte[slabSize];
    }

    @Override
    public void release(Object block) {
        if (block instanceof byte[] && ((byte[]) block).length == slabSize) {
            System.out.println("slab을 자유 목록으로 반환합니다.");
            freeSlabs.offer((byte[]) block);
        } else {
            System.out.println("slab이 아닌 블록은 반품이 불가능합니다.");
        }
    }
}
