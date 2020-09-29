package heritage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pile<T>
{
    /*
     * Tableau contenant les elements de la pile.
     */
    private List<T> tab;

    /********************************************/
    /*
     * Taille de la pile
     */
    private final int taille;

    /********************************************/
    /*
     * Indice du premier element non occupe dans le tableau.
     */
    private int firstFree;

    /********************************************/
    /*
     * Constructeur
     */
    Pile(int taille)
    {
        this.taille = taille;
        tab = new ArrayList<>(taille); // specifies the initial arraylist capacity, avoid to lose time on resizing it
        firstFree = 0;
    }

    /********************************************/
    /*
     * Constructeur de copie.
     */
    Pile(Pile other) {
        this(other.taille);
        firstFree = other.firstFree;
        tab.addAll(other.tab);
    }

    /********************************************/
    /*
     * Retourne vrai si et seulement si la pile est vide
     */
    public boolean estVide() {
        return tab.isEmpty();
    }

    /********************************************/
    /*
     * Retourne vrai si et seulement si la pile est pleine.
     */
    public boolean estPleine() {
        return firstFree == taille;
    }

    /********************************************/
    /*
     * Retourne l'element se trouvant au sommet de la pile, -1 si la pile est
     * vide.
     */
    public Optional<T> sommet() {
        if (estVide()) {
            return Optional.empty();
        }

        return Optional.of(tab.get(firstFree - 1));
    }

    /********************************************/
    /*
     * Supprime l'element se trouvant au sommet de la pile, ne fait rien si la
     * pile est vide.
     */
    public void depile() {
        if (estVide()) {
            return;
        }
        tab.remove(firstFree - 1);
        --firstFree;
    }

    /********************************************/
    /*
     * Ajoute data en haut de la pile, ne fait rien si la pile est pleine.
     */
    public void empile(T data) {
        if (estPleine()) {
            return;
        }
        tab.add(data);
        ++firstFree;
    }

    /********************************************/
    /*
     * Retourne une representation de la pile au format chaine de caracteres.
     */
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < firstFree; i++) {
            res.append(" ").append(tab.get(i));
        }
        return res.append(" ]").toString();
    }

    /********************************************/
    /*
     * Teste le fonctionnement de la pile.
     */
    public static void main(String[] args) {
        Pile p = new Pile(30);
        int i = 0;
        while (!p.estPleine()) {
            p.empile(i++);
        }
        System.out.println(p);
        while (!p.estVide()) {
            System.out.println(p.sommet().get());
            p.depile();
        }
    }
}
