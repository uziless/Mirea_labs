

import IWaitList.IWaitList;
import java.util.Collection;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

class WaitList<E> implements IWaitList<E> {
    final protected Deque<Object> deque = new ConcurrentLinkedDeque<>();

    public WaitList() {
    }

    public WaitList(Collection<E> c) {
        deque.addAll(c);
    }

    @Override
    public void add(E element) {
        deque.add(element);
    }

    @Override
    public Object remove(int a) {
        return null;
    }


    @Override
    public boolean contains(E element) {
        return false;
    }
    @Override
    public boolean containsAll(Collection<E> e) {
        return false;
    }
    @Override
    public boolean containsAll() {
        return false;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }

    class BoundedWaitList<E> {
        int capacity;
        BoundedWaitList(int capacity){
            this.capacity=capacity;
        }
        public int getCapacity() {
            return capacity;
        }
        void add(E e){
        }
        @Override
        public String toString() {
            return "BoundedWaitList{" +
                    "capacity=" + capacity +
                    '}';
        }
    }

    class UnfairWaitList<E> implements IWaitList{
        UnfairWaitList(){
        }
        void remove(E e){

        }
        void moveToBack(E e){}

        @Override
        public void add(Object element) {
            deque.add(element);
        }

        public Object remove(int a) {
            return null;
        }

        @Override
        public boolean contains(Object element) {
            return false;
        }

        @Override
        public boolean containsAll(Collection e) {
            return false;
        }

        @Override
        public boolean containsAll() {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }

    public class pr_8 {
        public void main(String[] args) {
            var in= new BoundedWaitList<>(5);
            in.add(1);
            in.add(2);
            in.add(3);
            in.add(4);
            in.add(5);

            var win=new UnfairWaitList<E>();
            win.add(1);
            win.add(2);
            win.add(3);
            win.add(5);
            win.add(6);
            win.add(7);
            win.remove(2);
            win.remove(3);
            win.remove(4);
            win.remove(5);
            System.out.println(toString());
        }
    }
}