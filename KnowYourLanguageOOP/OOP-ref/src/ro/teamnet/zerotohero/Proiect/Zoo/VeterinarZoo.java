package ro.teamnet.zerotohero.Proiect.Zoo;

/**
 * Created by Alexandra.Traila on 7/28/2017.
 */
public class VeterinarZoo implements AngajatZoo {

    int bonusVeterinar=0;
   public void lucreaza(Animal animal)
    {
        System.out.println("Veterinarul are grija de animal");

        if(animal instanceof AnimalZooFeroce) {
            animal.faceBaie();
        }
        bonusVeterinar++;
    }

    public void calculeazaBonusSalarial()
    {
        System.out.println("Bonusul pentru medicul veterinar este "+2*bonusVeterinar);

    }


    /*Sa se creeze clasa VeterinarZoo care implementeaza interfata AngajatZoo.
     In metoda lucreaza se afiseaza in consola “Veterinarul are grija de animal” iar
      in cazul in care Animalul primit ca parametru la metoda lucreaza este un AnimalZooFeroce,
       atunci se va apela metoda faceBaie.*/
}
