package iterateur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableauCreux<T> implements ITableauCreux<T> {
    private List<T> data;

    public TableauCreux(int size) {
        assert(size > 0);
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
        assert(data.size() > i);
        return data.get(i);
    }

    @Override
    public void set(int i, T item) {
        assert(i > 0 && data.size() > i && item != null);
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
        int size = 20;
        TableauCreux<Boolean> tc = new TableauCreux<>(size);
        for (int i = 0; i < size; ++i) {
            tc.set(i, i % 2 == 0);
        }
        for (boolean b : tc) {
            System.out.println(b);
        }
    }
}
