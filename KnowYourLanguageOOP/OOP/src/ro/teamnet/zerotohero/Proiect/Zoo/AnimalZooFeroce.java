package ro.teamnet.zerotohero.Proiect.Zoo;

import ro.teamnet.zerotohero.Proiect.ExceptionZoo.AnimalManancaAnimal;
import ro.teamnet.zerotohero.Proiect.ExceptionZoo.AnimalManancaOmException;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class AnimalZooFeroce extends Animal{

  void faceBaie()
  {
      System.out.println("AnimalulZooFeroce face baie");
  }

  void mananca(Object obj) throws AnimalManancaOmException,AnimalManancaAnimal
  {
    try
     {
       if(!(obj instanceof AngajatZoo) && !(obj instanceof Animal))
       System.out.println("AnimalZooFeroce mananca");
     }
     catch(Exception e)
     {
         if(e instanceof AnimalManancaOmException)
            throw new AnimalManancaOmException("AnimalManancaAnimalException");
         else
             if(e instanceof AnimalManancaAnimal)
                 throw new AnimalManancaAnimal("AnimalManancaAnimalException");
     }

  }

    void doarme()
    {
      super.doarme();
      System.out.println("Animalul feroce vaneaza");
    }
    /*Sa se creeze o clasa AnimalZooFeroce care extinde clasa Animal.
     Sa se afiseze text in consola in implementarile metodelor mostenite de la parinte.
     Se va suprascrie metoda doarme din parinte unde se va folosi atat implementarea din
     clasa Animal (super) a acestei metode dar se va afisa si un nou text in  consola , “Animalul feroce vaneaza”
     .Se va avea grija ca AnimalulZooFeroce sa nu manance un AngajatZoo, ca in exemplul precedent.*/
}
