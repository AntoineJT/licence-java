package designpatterns.wrapper;

public interface Anneau<E> {
    E un();
    E zero();
    E add(E other);
    E mul(E other);
}
