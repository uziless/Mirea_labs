//pr_11

//1

public class pr_11 {
    static class ArrayQueue {
        private int qhead = 0;
        private int qtail = 0;
        private Object[] elems = new Object[16];

        public void enqueue(Object element) {
            ensureCapacity(size() + 1);
            elems[qtail] = element;
            qtail = (qtail + 1) % elems.length;
        }//добавить элемент в очередь

        public Object element() {
            if (!isEmpty()) {
                return elems[qhead];
            } else return null;
        }//первый элемент в очереди

        public Object dequeue() {
            if (isEmpty()) {
                return null;
            } else {
                ensureCapacity(size() - 1);
                Object r = elems[qhead];
                elems[qhead] = null;
                qhead = (qhead + 1) % elems.length;
                return r;
            }
        }//удалить и вернуть первый элемент в очереди

        public int size() {
            return qtail - qhead + (qhead > qtail ? elems.length : 0);
        }//текущий размер очереди

        public boolean isEmpty() {
            return qhead == qtail;
        }//является ли очередь пустой;

        public void clear() {
            while (!isEmpty()) {
                dequeue();
            }
        }//удалить все элементы из очереди.

        private void ensureCapacity(int size) {
            if (size == elems.length || (size > 3 && size == elems.length / 4)) {
                Object[] newElements;
                if (size == elems.length) {
                    newElements = new Object[elems.length * 2];
                } else {
                    newElements = new Object[elems.length / 2];
                }
                if (qhead <= qtail) {
                    System.arraycopy(elems, qhead, newElements, 0, size());
                } else {
                    System.arraycopy(elems, qhead, newElements, 0, elems.length - qhead);
                    System.arraycopy(elems, 0, newElements, elems.length - qhead, qtail);
                }
                qtail = size();
                qhead = 0;
                elems = newElements;
            }
        }

        public static void main(String[] args) {
            var obj = new ArrayQueue();
            obj.enqueue(1);
            obj.enqueue(2);
            obj.enqueue(3);
            obj.enqueue(4);
            obj.enqueue(5);

            System.out.println(obj.element());
            System.out.println(obj.dequeue());
            System.out.println(obj.size());
            System.out.println(obj.isEmpty());
            obj.clear();

        }
    }
}


//2

public class pr_11 {
    class ArrayQueueADT {
        private int qhead = 0;
        private int qtail = 0;
        private Object[] elems = new Object[16];

        public int size(ArrayQueueADT queue) {
            return queue.qtail - queue.qhead + (queue.qhead > queue.qtail ? queue.elems.length : 0);
        }

        public boolean isEmpty(ArrayQueueADT queue) { // является ли очередь пустой
            return queue.qhead == queue.qtail;
        }

        private void ensureCapacity(ArrayQueueADT queue, int size) {
            if (size == queue.elems.length || (size > 3 && size == queue.elems.length / 4)) {
                Object[] newElements;
                if (size == queue.elems.length) {
                    newElements = new Object[queue.elems.length * 2];
                } else {
                    newElements = new Object[queue.elems.length / 2];
                }
                if (queue.qhead <= queue.qtail) {
                    System.arraycopy(queue.elems, queue.qhead, newElements, 0, size(queue));
                } else {
                    System.arraycopy(queue.elems, queue.qhead, newElements, 0, queue.elems.length - queue.qhead);
                    System.arraycopy(queue.elems, 0, newElements, queue.elems.length - queue.qhead, queue.qtail);
                }
                queue.qtail = size(queue);
                queue.qhead = 0;
                queue.elems = newElements;
            }
        }

        public  void enqueue(ArrayQueueADT queue, Object element) {
            ensureCapacity(queue, size(queue) + 1);
            queue.elems[queue.qtail] = element;
            queue.qtail = (queue.qtail + 1) % queue.elems.length;
        }

        public  Object element(ArrayQueueADT queue) {
            if (isEmpty(queue)) {
                return null;
            } else {
                return queue.elems[queue.qhead];
            }
        }

        public  Object dequeue(ArrayQueueADT queue) {
            if (isEmpty(queue)) {
                return null;
            }
            ensureCapacity(queue, size(queue) - 1);
            Object r = queue.elems[queue.qhead];
            queue.elems[queue.qhead] = null;
            queue.qhead = (queue.qhead + 1) % queue.elems.length;
            return r;
        }

        public void clear(ArrayQueueADT queue) {
            while (!isEmpty(queue)) {
                dequeue(queue);
            }
        }

        public void main(String[] args) {
            var obj = new ArrayQueueADT();
            obj.enqueue(1,1);
            obj.enqueue(2,2);
            obj.enqueue(3,3);
            obj.enqueue(4,4);
            obj.enqueue(5,5);

            System.out.println(obj.element());
            System.out.println(obj.dequeue());
            System.out.println(obj.size());
            System.out.println(obj.isEmpty());
            obj.clear();

        }
    }
}


//3

public class pr_11 {
public class ArrayQueueModule {
    private int qhead = 0;
    private int qtail = 0;
    private Object[] elems = new Object[16];

    public int cursize() {
        return qtail - qhead + (qhead > qtail ? elems.length : 0);
    }

    public boolean isEmpty() {
        return qhead == qtail;
    }

    private void ensureCapacity(int size) {
        if (size == elems.length || (size > 3 && size == elems.length / 4)) {
            Object[] newElements;
            if (size == elems.length) {
                newElements = new Object[elems.length * 2];
            } else {
                newElements = new Object[elems.length / 2];
            }
            if (qhead <= qtail) {
                System.arraycopy(elems, qhead, newElements, 0, cursize());
            } else {
                System.arraycopy(elems, qhead, newElements, 0, elems.length - qhead);
                System.arraycopy(elems, 0, newElements, elems.length - qhead, qtail);
            }
            qtail = cursize();
            qhead = 0;
            elems = newElements;
        }
    }

    public void enqueue(Object element) {
        ensureCapacity(cursize() + 1);
        elems[qtail] = element;
        qtail = (qtail + 1) % elems.length;
    }

    public Object element() {
        if (isEmpty()) return null;
        return elems[qhead];
    }

    public Object dequeue() {
        if (isEmpty()) return null;
        ensureCapacity(cursize() - 1);
        Object r = elems[qhead];
        elems[qhead] = null;
        qhead = (qhead + 1) % elems.length;
        return r;
    }

    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    public void main(String[] args) {
        var obj = new ArrayQueueModule();
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        obj.enqueue(5);

        System.out.println(obj.element());
        System.out.println(obj.dequeue());
        System.out.println(obj.cursize());
        System.out.println(obj.isEmpty());
        obj.clear();

    }
}
}


//4

interface Queue {
    int size();
    boolean isEmpty();
    void clear();
    Object dequeue();
}



//5

public class LinkedQueue extends AbstractQueue {
    private int size = 0;
    private Node head = null;
    private Node tail = null;
    public Object element() {
        assert !isEmpty();
        return head.value;
    }
    public void enqueue(Object element) {
        Node node = new Node(element);
        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }
    public Object dequeue() {
        if(isEmpty()) { return null; }
        Node node = head;
        head = head.next;
        size--;
        return node.value;
    }
    public int size() {
        return size;
    }
}

