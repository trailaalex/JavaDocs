package ro.teamnet.zerotohero.Proiect.Zoo;

import ro.teamnet.zerotohero.Proiect.ExceptionZoo.AnimalManancaAnimal;
import ro.teamnet.zerotohero.Proiect.ExceptionZoo.AnimalPeCaleDeDisparitieException;

/**
 * Created by Alexandra.Traila on 7/28/2017.
 */
public class IngrijitorZoo implements AngajatZoo {

int bonusIngrijtor=0;
 public void lucreaza(Animal animal)
 {
     System.out.println("Ingrijitorul intra in cusca animalului");
 }

 public void lucreaza(Animal animal, Object mancare) throws AnimalPeCaleDeDisparitieException, AnimalManancaAnimal {
     this.lucreaza(animal);
     animal.doarme();
     animal.faceBaie();
     animal.mananca(mancare);
      bonusIngrijtor++;
     if(animal instanceof AnimalZooRar && mancare==null)
         throw new AnimalPeCaleDeDisparitieException("AnimalZooRarException");
 }

 public void calculeazaBonusSalarial()
 {
     System.out.println("Bonusul salarial pentru ingrijitor este "+ 3*bonusIngrijtor);
 }
    /*Sa se creeze clasa IngrijitorZoo care implementeaza interfata AngajatZoo.
     In implementarea metodei lucreaza se va afisa text in consola “Ingrijitorul intra in cusca aninalului”.
Sa se supraincarce metoda lucreaza astfel incat sa primeasca inca un parametru, mancare de tip Object,
 iar in implementarea acestei metode sa se apeleze lucreaza din obiectul curent,
  precum si toate metodele din clasa Animal,metodei mananca i se va pasa parametru de tip Object.
In cazul in care Animalul primit ca parametru este de tip AnimalZooRar
 si obiectul mancare primit ca parametru este null se va arunca exceptia
 AnimalPeCaleDeDisparitieException, exceptia va fi adaugata la semnatura metodei. */
}
