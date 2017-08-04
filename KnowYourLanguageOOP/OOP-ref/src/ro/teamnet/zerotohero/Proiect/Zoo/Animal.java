package ro.teamnet.zerotohero.Proiect.Zoo;

import ro.teamnet.zerotohero.Proiect.ExceptionZoo.AnimalManancaAnimal;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public abstract class Animal {

    Animal()
    {
        System.out.println("Animal nou");
    }

    abstract void mananca(Object obj) throws AnimalManancaAnimal;
    abstract void faceBaie();
    void doarme()
    {
        System.out.println("Animalul doarme");
    }

    /*-	Metoda abstracta mananca , care are un singur parametru de tip Object
-	Metoda abstracta seJoaca, fara parametrii;
-	Metoda abstracta faceBaie, fara parametrii;
-	Metoda doarme , care nu este abastracta si va afisa text in consola “Animalul doarme”.
*/
}
