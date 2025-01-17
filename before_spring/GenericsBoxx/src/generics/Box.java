package generics;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.locks.Lock;

public class Box<T extends Comparable<T>> {
    private T item1;
    private T item2;
    private LockState lockState = LockState.LOCK;

    public Box(T item1, T item2) {
        int res = item1.compareTo(item2);
        if (res > 0) {
            this.item1 = item2;
            this.item2 = item1;
        } else {
            this.item1 = item1;
            this.item2 = item2;
        }
    }

    public void lock() {
        lockState = LockState.LOCK;
    }

    public void unlock() {
        lockState = LockState.UNLOCK;
    }

    public Boolean isLocked() {
        return lockState.equals(LockState.LOCK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return Objects.equals(item1, box.item1) && Objects.equals(item2, box.item2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item1, item2);
    }

    public T getItem1() throws Exception {
        if (isLocked()) {
            throw new Exception("Class is locked!");
        }
        return item1;
    }

    public T getItem2() throws Exception {
        if (isLocked()) {
            throw new Exception("Class is locked!");
        }
        return item2;
    }

    @Override
    public String toString() {
        return "Box{" +
                "item1=" + item1 +
                ", item2=" + item2 +
                '}';
    }
}
