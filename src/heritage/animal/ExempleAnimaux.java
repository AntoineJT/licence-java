package heritage.animal;

import java.util.ArrayList;

public class ExempleAnimaux
{
    public static void main(String[] args) {
        ArrayList<IAnimal> animaux = new ArrayList<>();
        animaux.add(new Chat("Ronron"));
        animaux.add(new Chien("Médor"));
        animaux.add(new Vache("Huguette"));
        for (IAnimal animal : animaux)
            System.out.println(animal.cri());
    }
}

abstract class Animal implements IAnimal, Comparable<Animal> {
    protected String nom;

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int compareTo(Animal other) {
        int n = nom.compareTo(other.nom);
        int c = cri().compareTo(other.cri());
        return (n != 0) ? n : c;
    }
}

class Chat extends Animal {
    public Chat(String nom) {
        this.setNom(nom);
    }

    @Override
    public String cri() {
        return "Miaou !";
    }
}

class Chien extends Animal {
    public Chien(String nom) {
        this.setNom(nom);
    }

    @Override
    public String cri() {
        return "Ouaf !";
    }
}

class Vache extends Animal {
    public Vache(String nom) {
        this.setNom(nom);
    }

    @Override
    public String cri() {
        return "Meuh !";
    }
}
