package heritage.tableauint;

import java.util.ArrayList;
import java.util.Random;

public class Tableau<T extends Comparable>
{
    private ArrayList<T> t;

    public Tableau()
    {
        t = new ArrayList<>();
    }

    public Tableau(Tableau<T> other)
    {
        t = new ArrayList<>();
        for (int i = 0 ; i < other.taille() ; i++)
            t.add(other.get(i));
    }

    public int taille()
    {
        return t.size();
    }

    public Tableau copie()
    {
        return new Tableau(this);
    }

    public String toString()
    {
        String res = "[";
        if (taille() >= 1)
            res += get(0);
        for (int i = 1 ; i < taille() ; i++)
            res += ", " + get(i);
        res += "]";
        return res;
    }

    public T get(int index)
    {
        return t.get(index);
    }

    public void set(int index, T value)
    {
        int n = taille();
        if (index < n)
            t.set(index, value);
        if (index == n)
            t.add(value);
        if (index > n)
            System.out.println("Achtung !");
    }

    public void echange(int i, int j)
    {
        T temp = get(i);
        set(i, get(j));
        set(j, temp);
    }

    public void triSelection()
    {
        for (int i = 0 ; i < taille() - 1 ; i++)
        {
            int indiceMin = i;
            for (int j = i + 1 ; j < taille() ; j++)
                if (get(indiceMin).compareTo(get(j)) > 0)
                    indiceMin = j;
            echange(i, indiceMin);
        }
    }

    public static void main(String[] args)
    {
        int n = 10;
        Random r = new Random();
        Tableau<Heure> tab = new Tableau<>();
        for (int i = 0; i < n; i++)
            tab.set(i, new Heure(r.nextInt() % 24, r.nextInt() % 60));
        System.out.println(tab);
        tab.triSelection();
        System.out.println(tab);
    }
}
