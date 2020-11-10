package IWaitList;

import java.util.Collection;

public interface IWaitList<E>
{
    void add(E element);
    Object remove(int a);
    boolean contains(E element);
    boolean containsAll(Collection<E> e) ;
    boolean containsAll();
    boolean isEmpty();
}
