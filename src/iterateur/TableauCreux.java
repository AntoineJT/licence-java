package iterateur;

import static utils.ExAssert.exAssert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableauCreux<T> implements ITableauCreux<T> {
    private final List<T> data;

    public TableauCreux(int size) {
        exAssert((size > 0), "Size is negative");

        data = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            data.add(null);
        }
    }

    public TableauCreux() {
        data = new ArrayList<>();
    }

    @Override
    public T get(int i) {
        exAssert((i >= data.size()), "Index is out of bounds");
        return data.get(i);
    }

    @Override
    public void set(int i, T item) {
        exAssert((i > 0), "Index is negative");
        exAssert((i >= data.size()), "Index is out of bounds", IllegalStateException.class);
        exAssert((item != null), "Item is null. This class doesn't accept null items");

        data.set(i, item);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index + 1 < data.size() && data.get(index + 1) != null;
            }

            @Override
            public T next() {
                return data.get(++index);
            }
        };
    }

    public static void main(String[] args) {
        int size = -20;
        TableauCreux<Boolean> tc = new TableauCreux<>(size);
        for (int i = 0; i < -size; ++i) {
            tc.set(i, i % 2 == 0);
        }
        for (boolean b : tc) {
            System.out.println(b);
        }
    }
}
