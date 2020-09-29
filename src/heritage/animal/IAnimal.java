package heritage.animal;

import java.util.ArrayList;
@SuppressWarnings("unused")

interface IAnimal
{
    // Setter pour le champ nom
    public void setNom(String nom);

    // Getter pour le champ nom
    public String getNom();

    // Retourne le cri de l'animal
    public String cri();
}
