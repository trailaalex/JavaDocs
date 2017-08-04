package ro.teamnet.zerotohero.Proiect.Zoo;

import ro.teamnet.zerotohero.Proiect.ExceptionZoo.AnimalManancaAnimal;
import ro.teamnet.zerotohero.Proiect.ExceptionZoo.AnimalManancaOmException;

/**
 * Created by Alexandra.Traila on 7/27/2017.
 */
public class AnimalZooRar extends Animal {

    private String nume;
    private String numeleTariiDeOrigine;

    AnimalZooRar()
    {
        this.nume="Leu";
        this.numeleTariiDeOrigine="Namibia";
    }

    AnimalZooRar(String nume)
    {
        this.nume=nume;
    }
    AnimalZooRar(String nume,String numeleTariiDeOrigine)
    {
        this.numeleTariiDeOrigine=numeleTariiDeOrigine;
    }

    void faceBaie()
    {
        System.out.println("AnimalulZooRar face baie");
    }

    void seJoaca()
    {
        System.out.println("AnimalulZooRar se joaca");
        super.doarme();

    }

    void mananca(Object a) throws AnimalManancaAnimal {
        if(a instanceof AngajatZoo)
            throw new AnimalManancaOmException("nu e ok");
        else
            if(a instanceof Animal)
                throw new AnimalManancaAnimal("AnimalManancaAnimal");
        else
            System.out.println("AnimalZooRar mananca");
    }


    /*Sa se creeze clasa AnimalZooRar care extinde clasa Animal.
    Sa se pastreze principiul encapsularii datelor pentru aceasta clasa,
     pentru a tine informatii despre numele si numeleTariiDeOrigine despre AnimalZooRar.
     Sa se implementeze toti constructorii clasei.
In implementarea metodei faceBaie sa se afiseze text in consola “AnimalulZooRar face baie”.
 In cadrul clasei AnimalZooRar, in implementarea metodei seJoaca sa se sa se afiseze text
 in consola “AnimalulZooRar se joaca” si apoi sa se apeleze din parinte metoda doarme. In cadrul metodei mananca,
 in cazul in care obiectul primit ca parametru este un AngajatZoo sa se arunce exceptia
 AnimalManancaOmException daca nu, sa se afiseze mesajul in consola “AnimalZooRar mananca”.
*/
}
