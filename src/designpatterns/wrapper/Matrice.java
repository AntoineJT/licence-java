package designpatterns.wrapper;

import java.util.Vector;

// TODO Finir ça correctement
public class Matrice<T extends Anneau> implements Anneau<Matrice> {
    private final int nbLines;
    private final int nbColumns;
    private Vector<Vector<T>> data;

    public Matrice(int nbLines, int nbColumns) {
        this.nbLines = nbLines;
        this.nbColumns = nbColumns;
        this.data = new Vector<>();
    }

    public Vector<Vector<T>> get() {
        return data;
    }

    public void set(Vector<Vector<T>> data) {
        this.data = data;
    }

    @Override
    public Matrice un() {
        /*
        for (int line = 0; line < nbLines; ++line) {
            for (int column = 0; column < nbColumns; ++column) {
                data.get(line).set(column, new T().un());
            }
        }
         */

        return null;
    }

    @Override
    public Matrice zero() {
        return null;
    }

    @Override
    public Matrice add(Matrice other) {
        return null;
    }

    @Override
    public Matrice mul(Matrice other) {
        return null;
    }
}
